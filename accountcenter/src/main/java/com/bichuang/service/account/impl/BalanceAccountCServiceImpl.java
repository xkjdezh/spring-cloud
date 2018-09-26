package com.bichuang.service.account.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bichuang.platform.common.constant.Constant;
import com.bichuang.platform.common.util.FastJsonUtil;
import com.bichuang.platform.common.util.IDUtil;
import com.bichuang.platform.common.util.SignUtil;
import com.bichuang.repository.mapper.account.BalanceAccountCChangeSeqMapper;
import com.bichuang.repository.mapper.account.BalanceAccountCMapper;
import com.bichuang.repository.mapper.account.BalanceBankcardCMapper;
import com.bichuang.repository.mapper.account.ext.BalanceAccountCExtMapper;
import com.bichuang.repository.model.account.BalanceAccountC;
import com.bichuang.repository.model.account.BalanceAccountCChangeSeq;
import com.bichuang.repository.model.account.BalanceBankcardC;
import com.bichuang.service.account.BalanceAccountCService;
import com.bichuang.util.ImsUtil;
import com.bichuang.vo.account.AccountCChangeVo;
import com.bichuang.vo.account.AccountReqVO;
import com.bichuang.vo.account.ApplyBindBankCardReqVO;
import com.bichuang.vo.account.BalanceAccountCChangeSeqResp;
import com.bichuang.vo.account.BindBankCardReqVO;
import com.bichuang.vo.account.DepositApplyReqVO;
import com.bichuang.vo.account.DepositNotifyReqVO;
import com.bichuang.vo.account.SendSmsReqVO;
import com.bichuang.vo.account.WithdrawApplyReqVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("balanceAccountCService")
public class BalanceAccountCServiceImpl extends BaseServiceImpl<BalanceAccountC, Integer>
		implements BalanceAccountCService {
	
	private Logger logger = LoggerFactory.getLogger(BalanceAccountCServiceImpl.class);

	@Autowired
	SignUtil signUtil;

	@Autowired
	ImsUtil imsUtil;

	@Value("${tl.accountSetNo}")
	private String accountSetNo;

	@Autowired
	BalanceAccountCMapper balanceAccountCMapper;

	@Autowired
	BalanceBankcardCMapper balanceBankCardCMapper;

	@Autowired
	BalanceAccountCExtMapper balanceAccountCExtMapper;

	@Autowired
	BalanceAccountCChangeSeqMapper balanceAccountCChangeSeqMapper;

	private Map<String, Object> traceMap = new HashMap<String, Object>();

	@Override
	public void setBaseMapper() {
		super.setBaseMapper(baseMapper);
	}

	@Override
	public int updateAmount(DepositNotifyReqVO vo) {
		BalanceAccountC bean = new BalanceAccountC();
		bean.setBizUserId(vo.getBizUserId());  
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		// 1.充值 2.提现
		if(vo.getType()==1){
			int num = balanceAccountC.getAmount().compareTo(BigDecimal.ZERO);
			if (num > 0) {
				BigDecimal amount2 = balanceAccountC.getAmount().add(vo.getAmount());
				bean.setAmount(amount2);
			} else {
				bean.setAmount(vo.getAmount());
			}
			logger.info("充值金额...."+bean.getAmount());   
		}else if (vo.getType()==2){
			BigDecimal amount2 = balanceAccountC.getAmount().subtract(vo.getAmount());
			bean.setAmount(amount2);
			logger.info("提现金额...."+bean.getAmount());   
		}
		return balanceAccountCMapper.updateByCusId(bean);
	}

	@Override
	public int updateByCusId(BalanceAccountC balanceAccountC) {
		return balanceAccountCMapper.updateByCusId(balanceAccountC);
	}

	@Override
	public int updateOrderStatus(DepositNotifyReqVO depositNotifyReqVO) {
		BalanceAccountCChangeSeq bean = new BalanceAccountCChangeSeq();
		bean.setOrderId(depositNotifyReqVO.getBizOrderNo());// 商户订单号
		//bean.setRefSn(depositNotifyReqVO.getOrderNo());//关接流水号，云商通订单号
		bean.setBackTime(new Date());
		bean.setCreateTime(new Date());
		bean.setOrderStatus(1);
		return balanceAccountCChangeSeqMapper.updateOrderStatus(bean);
	}

	@Override
	public Map<String, Object> requestCreateMember(AccountReqVO accountReqVO) throws Exception {
		// 先查询是否已开户
		Map<String, Object> resultMap = new HashMap<String, Object>();
		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustId(accountReqVO.getCustId());
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		if (balanceAccountC == null) {
			JSONObject param = new JSONObject();
			param.put("bizUserId", IDUtil.getUUID());
			// memberType 2 企业会员 3 个人会员
			param.put("memberType", accountReqVO.getMemberType());
			param.put("source", accountReqVO.getSource()); // 1.mobile 2.pc
			JSONObject json = imsUtil.sendHttpRequst(Constant.MEMBER_SERVCIE, Constant.CREATE_MEMBER, param);
			if (json.getString("status").toString().equals(Constant.SUCCEES_CODE)) {
				bean.setBizUserId(param.get("bizUserId").toString());
				bean.setCustName(accountReqVO.getCustName());
				// bean.setPayPwd(ImsUtil.rsaEncrypt(accountReqVO.getPayPwd()));
				// //
				// 密码RSA加密
				bean.setIdentityType(accountReqVO.getIdentityType());
				bean.setIdentityNo(accountReqVO.getIdentityNo());
				bean.setCreateTime(new Date());
				bean.setStatus("02");
				// TODO 修改status 状态
				balanceAccountCMapper.insertSelective(bean);

				String str = json.getString("signedValue");
				Map<String, Object> map = FastJsonUtil.jsonToMap(str);
				Object bizUserId = map.get("bizUserId");
				resultMap.put("bizUserId", bizUserId);
				resultMap.put("status", Constant.SUCCEES_CODE);
			}
		} else {
			resultMap.put("status", Constant.RESULT_1001);
			resultMap.put("msg", "你已开户");
		}
		return resultMap;
	}

	@Override
	public BalanceAccountC getAccount(AccountReqVO accountReqVO) {
		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustName(accountReqVO.getCustName());
		// 查询账户余额
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		// 查询今日账户消耗
		return null;
	}

	@Override
	public Map<String, Object> requestAuthRealname(AccountReqVO accountReqVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustId(accountReqVO.getCustId());
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		if (balanceAccountC.getStatus() != null && balanceAccountC.getStatus().equals("03")) {
			resultMap.put("status", Constant.RESULT_1001);
			return resultMap;
		}
		if (balanceAccountC != null) {
			JSONObject params = new JSONObject();
			params.put("bizUserId", balanceAccountC.getBizUserId());
			// params.put("isAuth", true); // true/false 默认为true
			params.put("name", accountReqVO.getRealName());
			params.put("identityType", accountReqVO.getIdentityType());// 1.身份证
			params.put("identityNo", imsUtil.rsaEncrypt(accountReqVO.getIdentityNo()));
			JSONObject json = imsUtil.sendHttpRequst(Constant.MEMBER_SERVCIE, Constant.SET_REALNAME, params);
			if (json.getString("status").equals(Constant.SUCCEES_CODE)) {
				resultMap.put("status", Constant.SUCCEES_CODE);
				String str = json.getString("signedValue");
				resultMap.put("signedValue", str);
				balanceAccountC.setCustId(accountReqVO.getCustId());
				balanceAccountC.setStatus("03");
				balanceAccountCMapper.updateByCusId(balanceAccountC);
			} else {
				resultMap.put("status", Constant.FAIL_CODE);
				String str = json.getString("signedValue");
				resultMap.put("signedValue", str);
			}
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> requestSignContract(AccountReqVO accountReqVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		JSONObject json = new JSONObject();
		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustId(accountReqVO.getCustId());
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		if (balanceAccountC != null) {
			JSONObject params = new JSONObject();
			params.put("bizUserId", balanceAccountC.getBizUserId());
			// params.put("isAuth", true); // true/false 默认为true
			params.put("memberType", accountReqVO.getMemberType());
			params.put("jumpUrl", "");
			params.put("backUrl", "");// TODO
			params.put("source", accountReqVO.getSource());
			json = imsUtil.sendHttpRequst(Constant.MEMBER_SERVCIE, Constant.SIGN_CONTRACT, params);
			if (json.getString("status").equals(Constant.SUCCEES_CODE)) {
				resultMap.put("status", Constant.SUCCEES_CODE);
				return resultMap;
			}
		}
		resultMap.put("status", "请先开户");
		return resultMap;
	}

	@Override
	public JSONObject requestSignContractNotify(AccountReqVO accountReqVO) throws Exception {
		JSONObject json = new JSONObject();
		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustId(accountReqVO.getCustId());
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		if (balanceAccountC != null) {
			JSONObject params = new JSONObject();
			params.put("bizUserId", balanceAccountC.getBizUserId());
			// params.put("isAuth", true); // true/false 默认为true
			params.put("memberType", accountReqVO.getRealName());
			params.put("jumpUrl", "");
			params.put("backUrl", "");// TODO
			params.put("source", accountReqVO.getSource());
			json = imsUtil.sendHttpRequst(Constant.MEMBER_SERVCIE, Constant.SIGN_CONTRACT, params);
			return json;
		}
		return json;
	}

	@Override
	public Map<String, Object> requestSetPayPwd(AccountReqVO accountReqVO) throws Exception {
		JSONObject param = new JSONObject();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustId(accountReqVO.getCustId());
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		param.put("bizUserId", balanceAccountC.getBizUserId());
		param.put("phone", accountReqVO.getPhone());
		param.put("phone", accountReqVO.getCustName());
		param.put("identityType", accountReqVO.getCustName());
		param.put("identityNo", accountReqVO.getCustName());
		param.put("jumpUrl", Constant.JUMP_URL);// TODO jumpUrl
		param.put("backUrl", Constant.SET_PAYPWD);
		JSONObject json = imsUtil.sendHttpRequst(Constant.MEMBER_PWD_SERVICE, Constant.SET_PAY_PWD, param);
		if (json.getString("status").toString().equals(Constant.SUCCEES_CODE)) {
			String str = json.getString("signedValue");
			Map<String, Object> map = FastJsonUtil.jsonToMap(str);
			Object result = map.get("result");
			resultMap.put("result", result);
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> requestUpdatePayPwd(AccountReqVO accountReqVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		JSONObject param = new JSONObject();
		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustId(accountReqVO.getCustId());
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		param.put("bizUserId", balanceAccountC.getBizUserId());
		param.put("phone", accountReqVO.getPhone());
		param.put("phone", accountReqVO.getCustName());
		param.put("identityType", accountReqVO.getCustName());
		param.put("identityNo", accountReqVO.getCustName());
		// TODO jumpUrl
		param.put("backUrl", "");
		JSONObject json = imsUtil.sendHttpRequst(Constant.MEMBER_PWD_SERVICE, Constant.UPDATE_PAY_PWD, param);
		if (json.getString("status").toString().equals(Constant.SUCCEES_CODE)) {
			String str = json.getString("signedValue");
			Map<String, Object> map = FastJsonUtil.jsonToMap(str);
			Object status = map.get("status");
			resultMap.put("status", status);
			return resultMap;
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> requestBindPhone(SendSmsReqVO sendSmsReqVO) throws Exception {
		// 先应调用发送短信接口
		Map<String, Object> resultMap = new HashMap<String, Object>();
		JSONObject param = new JSONObject();
		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustId(sendSmsReqVO.getCustId());
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		param.put("bizUserId", balanceAccountC.getBizUserId());
		param.put("phone", sendSmsReqVO.getPhone());
		// param.put("verificationCode", sendSmsReqVO.getVerificationCode());
		JSONObject json = imsUtil.sendHttpRequst(Constant.MEMBER_SERVICE_WITHOUT_CONFIRM,
				Constant.BIND_PHONE_WITHOUT_CONFIRM, param);
		if (json.getString("status").toString().equals(Constant.SUCCEES_CODE)) {
			balanceAccountC.setCustId(sendSmsReqVO.getCustId());
			balanceAccountC.setPhone(sendSmsReqVO.getPhone());
			balanceAccountCMapper.updateByCusId(balanceAccountC);
			resultMap.put("status", Constant.SUCCEES_CODE);
			return resultMap;
		}
		if (json.getString("errorCode").toString().equals("30024")) {
			resultMap.put("status", Constant.RESULT_1001);
			return resultMap;
		}
		resultMap.put("status", Constant.FAIL_CODE);
		return resultMap;
	}

	@Override
	public JSONObject requestSendSms(SendSmsReqVO sendSmsReqVO) throws Exception {
		JSONObject param = new JSONObject();
		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustId(sendSmsReqVO.getCustId());
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		param.put("bizUserId", balanceAccountC.getBizUserId());
		param.put("phone", sendSmsReqVO.getPhone());
		param.put("verificationCodeType", sendSmsReqVO.getVerificationCodeType());// 9-绑定手机
		return imsUtil.sendHttpRequst(Constant.MEMBER_SERVCIE, Constant.SEND_SMS, param);
	}

	@Override
	public Map<String, Object> requestgetBankCardBin(ApplyBindBankCardReqVO applyBindBankCardReqVO) throws Exception {
		JSONObject param = new JSONObject();
		param.put("cardNo", imsUtil.rsaEncrypt(applyBindBankCardReqVO.getCardNo()));
		JSONObject json = imsUtil.sendHttpRequst(Constant.MEMBER_SERVCIE, Constant.GET_BANK_CARD_BIN, param);
		if (json.getString("status").equals(Constant.SUCCEES_CODE)) {
			String str = json.getString("signedValue");
			Map<String, Object> map = FastJsonUtil.jsonToMap(str);
			Object cardBinInfo = map.get("cardBinInfo");
			String str2 = FastJsonUtil.toJson(cardBinInfo);
			Map<String, Object> map2 = FastJsonUtil.jsonToMap(str2);
			// TODO
		}
		return null;
	}

	@Override
	public Map<String, Object> requestApplyBindBankCard(ApplyBindBankCardReqVO applyBindBankCardReqVO)
			throws Exception {
		JSONObject param = new JSONObject();
		Map<String, Object> resultMap = new HashMap<>();

		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustId(applyBindBankCardReqVO.getCustId());
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);

		BalanceBankcardC record = new BalanceBankcardC();
		record.setCustId(applyBindBankCardReqVO.getCustId());
		record.setBankCardno(applyBindBankCardReqVO.getCardNo());
		List<BalanceBankcardC> list = balanceBankCardCMapper.selectAll(record);
		if (!CollectionUtils.isEmpty(list)) {
			resultMap.put("status", Constant.RESULT_1001);
			return resultMap;
		}
		param.put("bizUserId", balanceAccountC.getBizUserId());
		param.put("cardNo", imsUtil.rsaEncrypt(applyBindBankCardReqVO.getCardNo()));
		param.put("phone", applyBindBankCardReqVO.getPhone());
		param.put("name", applyBindBankCardReqVO.getName());
		param.put("identityType", applyBindBankCardReqVO.getIdentityType());
		param.put("identityNo", imsUtil.rsaEncrypt(applyBindBankCardReqVO.getIdentityNo()));
		JSONObject json = imsUtil.sendHttpRequst(Constant.MEMBER_SERVCIE, Constant.APPLY_BIND_BANK_CARD, param);
		if (json.getString("status").toString().equals(Constant.SUCCEES_CODE)) {
			String data = json.getString("signedValue");
			Map<String, Object> map = FastJsonUtil.jsonToMap(data);
			Object bizUserId = map.get("bizUserId");
			Object tranceNum = map.get("tranceNum");
			Object transDate = map.get("transDate");
			Object bankName = map.get("bankName");
			Object bankCode = map.get("bankCode");
			Object cardType = map.get("cardType");
			Object sign = map.get("sign");
			resultMap.put("bizUserId", bizUserId);
			resultMap.put("tranceNum", tranceNum);// 流水号
			traceMap.put("tranceNum", tranceNum);
			resultMap.put("transDate", transDate);// 申请时间
			traceMap.put("transDate", transDate);
			traceMap.put("bankName", bankName);
			traceMap.put("cardType", cardType);
			traceMap.put("cardNo", applyBindBankCardReqVO.getCardNo());
			resultMap.put("bankName", bankName);
			resultMap.put("bankCode", bankCode);
			resultMap.put("cardType", cardType);// 1 储蓄卡 2 信用卡
			resultMap.put("sign", sign);
			resultMap.put("status", Constant.SUCCEES_CODE);
			return resultMap;
		}
		resultMap.put("status", Constant.FAIL_CODE);
		return resultMap;
	}

	@Override
	public Map<String, Object> requestBindBankCard(BindBankCardReqVO bindBankCardReqVO) throws Exception {
		JSONObject param = new JSONObject();
		Map<String, Object> resultMap = new HashMap<>();
		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustId(bindBankCardReqVO.getCustId());
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		param.put("bizUserId", balanceAccountC.getBizUserId());
		param.put("tranceNum", traceMap.get("tranceNum"));// 请求绑定银行卡接口返回
		param.put("transDate", traceMap.get("transDate"));// 请求绑定银行卡接口返回
		param.put("phone", bindBankCardReqVO.getPhone());
		param.put("verificationCode", bindBankCardReqVO.getVerificationCode());
		JSONObject json = imsUtil.sendHttpRequst(Constant.MEMBER_SERVCIE, Constant.BIND_BANK_CARD, param);
		if (json.getString("status").toString().equals(Constant.SUCCEES_CODE)) {
			// 账户和银行卡关联 TODO
			BalanceBankcardC record = new BalanceBankcardC();
			record.setCustId(bindBankCardReqVO.getCustId());
			record.setBankCardno(traceMap.get("cardNo").toString());
			record.setBankName(traceMap.get("bankName").toString());
			record.setCardType(Integer.parseInt(traceMap.get("cardType").toString())); // 1
																						// 储蓄卡
																						// 2
																						// 信用卡
			record.setPhone(bindBankCardReqVO.getPhone());
			balanceBankCardCMapper.insertSelective(record);
			traceMap.clear();
			String data = json.getString("signedValue");
			Map<String, Object> map = FastJsonUtil.jsonToMap(data);
			Object bizUserId = map.get("bizUserId");
			Object tranceNum = map.get("tranceNum");
			resultMap.put("bizUserId", bizUserId);
			resultMap.put("tranceNum", tranceNum);
			resultMap.put("status", Constant.SUCCEES_CODE);
			return resultMap;
		}
		resultMap.put("status", Constant.FAIL_CODE);
		return resultMap;
	}

	@Override
	public Map<String, Object> requestDepositApply(DepositApplyReqVO depositApplyReqVO) throws Exception {
		JSONObject param = new JSONObject();
		Map<String, Object> resultMap = new HashMap<>();
		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustId(depositApplyReqVO.getCustId());
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		BigDecimal preAmount = balanceAccountC.getAmount();
		param.put("bizOrderNo", depositApplyReqVO.getBizOrderNo());
		param.put("bizUserId", balanceAccountC.getBizUserId());
		param.put("accountSetNo", accountSetNo);
		param.put("amount", depositApplyReqVO.getAmount());
		param.put("fee", "0.01");//
		param.put("ordErexpireDatetime", depositApplyReqVO.getOrdErexpireDatetime());
		param.put("frontUrl", depositApplyReqVO.getFrontUrl());
		param.put("backUrl", Constant.DEPOSIT_NOTIFY);
		// 1.B2C 个人网银（借记卡） 11.B2C 个人网银（信用卡) 4.B2B 企业网银
		JSONObject SCAN_WEIXIN = new JSONObject();
		JSONObject payMethod = new JSONObject();
		if (depositApplyReqVO.getPayMethod().equals("SCAN_WEIXIN")) {
			SCAN_WEIXIN.put("payType", "W01");
			SCAN_WEIXIN.put("amount", depositApplyReqVO.getAmount());
			payMethod.put("SCAN_WEIXIN", SCAN_WEIXIN);
		}
		param.put("payMethod", payMethod);
		param.put("industryCode", depositApplyReqVO.getIndustryCode());
		param.put("industryName", depositApplyReqVO.getIndustryName());
		param.put("source", depositApplyReqVO.getSource());
		JSONObject json = imsUtil.sendHttpRequst(Constant.ORDER_SERVICE, Constant.DEPOSIT_APPLY, param);
		if (json.getString("status").toString().equals(Constant.SUCCEES_CODE)) {

			// 组装返回参数
			String str = json.getString("signedValue");
			Map<String, Object> map = FastJsonUtil.jsonToMap(str);
			// Object payStatus = map.get("payStatus");//交易验证方式为0 时 返回
			Object orderNo = map.get("orderNo");
			Object bizOrderNo = map.get("bizOrderNo");
			Object payInfo = map.get("payInfo");
			// resultMap.put("payStatus", payStatus);
			resultMap.put("orderNo", orderNo); // 云商通订单号
			resultMap.put("bizOrderNo", bizOrderNo); // 商户订单号（支付订单）
			resultMap.put("payInfo", payInfo);
			resultMap.put("status", "success");

			// 记录充值流水
			BalanceAccountCChangeSeq record = new BalanceAccountCChangeSeq();
			record.setSn(IDUtil.getUUID());
			record.setCustId(depositApplyReqVO.getCustId());
			record.setChangeType("01");
			record.setPreamount(preAmount);// 充值前金额
			record.setAmount(preAmount.add(depositApplyReqVO.getAmount()).divide(BigDecimal.valueOf(100)));// 充值后金额
			record.setRefSn(orderNo.toString());// 云商通订单号
			record.setOrderId(bizOrderNo.toString());// 商户订单号
			record.setOrderStatus(0);
			record.setCreateTime(new Date());
			balanceAccountCChangeSeqMapper.insertSelective(record);

			return resultMap;
		}
		resultMap.put("status", Constant.FAIL_CODE);
		return resultMap;
	}

	@Override
	public Map<String, Object> requestWithdrawApply(WithdrawApplyReqVO withdrawApplyReqVO) throws Exception {
		JSONObject param = new JSONObject();
		Map<String, Object> resultMap = new HashMap<>();
		BalanceAccountC bean = new BalanceAccountC();
		bean.setCustId(withdrawApplyReqVO.getCustId());
		BalanceAccountC balanceAccountC = balanceAccountCMapper.selectAll(bean);
		BigDecimal preBalance = balanceAccountC.getAmount();
		//BigDecimal balance = new BigDecimal("0");
		param.put("bizUserId", balanceAccountC.getBizUserId());
		param.put("accountSetNo", accountSetNo);
		JSONObject json = imsUtil.sendHttpRequst(Constant.ORDER_SERVICE, Constant.QUERY_BALANCE, param);
		if (balanceAccountC != null) {
			if (json.getString("status").toString().equals(Constant.SUCCEES_CODE)) {
				String str = json.getString("signedValue");
				Map<String, Object> map = FastJsonUtil.jsonToMap(str);
				Object allAmount = map.get("allAmount");
				// BigDecimal freezenAmount = new
				// BigDecimal(map.get("freezenAmount").toString());// 分为单位,转为元
				// int a = bigdemical.compareTo(bigdemical2)
				int a = new BigDecimal(String.valueOf(allAmount))
						.compareTo(new BigDecimal(String.valueOf(withdrawApplyReqVO.getAmount())));
				if (a == 1) {
					param.put("bizOrderNo", withdrawApplyReqVO.getBizOrderNo());
					param.put("amount", withdrawApplyReqVO.getAmount());
					param.put("fee", "1");
					param.put("backUrl", Constant.WITHDRAW_NOTIFY);
					param.put("bankCardNo", imsUtil.rsaEncrypt(withdrawApplyReqVO.getBankCardNo()));// RSA加密
					// 0：个人银行卡 1：企业对公账户 如果不传默认为 0
					param.put("bankCardPro", withdrawApplyReqVO.getBankCardPro());
					param.put("industryCode", withdrawApplyReqVO.getIndustryCode());
					param.put("industryName", withdrawApplyReqVO.getIndustryName());
					param.put("source", withdrawApplyReqVO.getSource());
					JSONObject json2 = imsUtil.sendHttpRequst(Constant.ORDER_SERVICE, Constant.WITHDRAW_APPLY, param);
					if (json2.getString("status").toString().equals(Constant.SUCCEES_CODE)) {
						// 组装返回参数
						String str2 = json2.getString("signedValue");
						Map<String, Object> map2 = FastJsonUtil.jsonToMap(str2);
						Object orderNo = map2.get("orderNo");
						Object bizOrderNo = map2.get("bizOrderNo");
						resultMap.put("status", Constant.SUCCEES_CODE);

						// 记录提现流水
						BalanceAccountCChangeSeq seq = new BalanceAccountCChangeSeq();
						seq.setSn(IDUtil.getUUID());  
						seq.setCustId(withdrawApplyReqVO.getCustId());
						seq.setPreamount(preBalance);
						seq.setAmount(balanceAccountC.getAmount());
						seq.setChangeType("03");  
						seq.setRefSn(orderNo.toString());//关接流水，云商通订单号
						seq.setOrderId(bizOrderNo.toString());//商户订单号
						seq.setCreateTime(new Date());
						balanceAccountCChangeSeqMapper.insertSelective(seq);
						return resultMap;
					}
				} else {
					// 余额不足
					resultMap.put("status", "余额不足");
					return resultMap;
				}
			}
		}
		resultMap.put("status", "未开户不允许提现");
		return resultMap;
	}

	@Override
	public Map<String, Object> WithdrawConfirmPay(WithdrawApplyReqVO withdrawApplyReqVO) throws Exception {
		BalanceAccountC bean = new BalanceAccountC();
		JSONObject param = new JSONObject();
		Map<String, Object> resultMap = new HashMap<>();
		bean.setBizUserId(withdrawApplyReqVO.getBizUserId());  
		BalanceAccountC accountC = balanceAccountCMapper.selectAll(bean);
		param.put("bizUserId", accountC.getBizUserId());
		param.put("bizOrderNo", withdrawApplyReqVO.getBizOrderNo());
		param.put("verificationCode", withdrawApplyReqVO.getVerificationCode());
		param.put("consumerIp", withdrawApplyReqVO.getConsumerIp());
		JSONObject json = imsUtil.sendHttpRequst(Constant.ORDER_SERVICE, Constant.PAY, param);
		if (json.getString("status").toString().equals(Constant.SUCCEES_CODE)) {
			String str = json.getString("signedValue");  
			Map<String, Object> map = FastJsonUtil.jsonToMap(str);
			Object payStatus = map.get("payStatus");
			Object payFailMessage = null;
			if (payStatus.toString().equals("fail")) {
				payFailMessage = map.get("payFailMessage");
			}
			Object bizOrderNo = map.get("bizOrderNo");
			resultMap.put("payStatus", payStatus);
			if (payFailMessage != null) {
				resultMap.put("payFailMessage", payFailMessage);
				resultMap.put("bizOrderNo", bizOrderNo);
				resultMap.put("status", "提现失败");
				return resultMap;
			} else {
				resultMap.put("bizOrderNo", bizOrderNo);
				resultMap.put("status", Constant.SUCCEES_CODE);
				return resultMap;
			}
		}
		resultMap.put("status", "提现失败");
		return resultMap;
	}

	@Override
	public BalanceAccountC getBalanceAccountC(String custId) {
		BalanceAccountC balanceAccountC = new BalanceAccountC();
		balanceAccountC.setCustId(custId);
		return balanceAccountCExtMapper.getBalanceAccountC(balanceAccountC);
	}

	@Override
	public Map<String, Object> requestQueryBalance(AccountReqVO accountReqVO) throws Exception {
		BalanceAccountC bean = new BalanceAccountC();
		JSONObject param = new JSONObject();
		Map<String, Object> resultMap = new HashMap<>();
		bean.setCustId(accountReqVO.getCustId());
		BalanceAccountC accountC = balanceAccountCMapper.selectAll(bean);
		param.put("bizUserId", accountC.getBizUserId());
		param.put("accountSetNo", accountSetNo);
		JSONObject json = imsUtil.sendHttpRequst(Constant.ORDER_SERVICE, Constant.QUERY_BALANCE, param);
		if (accountC != null) {
			if (json.getString("status").toString().equals(Constant.SUCCEES_CODE)) {
				String str = json.getString("signedValue");
				Map<String, Object> map = FastJsonUtil.jsonToMap(str);
				Object allAmount = map.get("allAmount");
				BigDecimal freezenAmount = new BigDecimal(map.get("freezenAmount").toString());// 分为单位,转为元
				freezenAmount.divide(BigDecimal.valueOf(100));
				// TODO 赠送金额 今日账户消耗
				resultMap.put("todayAccountConsume", "");// 今日账户消耗
				resultMap.put("totalAmount", allAmount);// 账户总余额
				resultMap.put("cashAmount", accountC.getCashAmount());// 现金金额
				resultMap.put("giveAmount", "");// 赠送金额
				resultMap.put("availableBalance", accountC.getCashAmount().add(accountC.getUncashAmount())); // 可用余额
				resultMap.put("freezeAmount", freezenAmount);// 冻结金额
				return resultMap;
			}
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> queryInExpDetail(AccountReqVO accountReqVO) throws Exception {
		BalanceAccountCChangeSeq balance = new BalanceAccountCChangeSeq();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		balance.setCustId(accountReqVO.getCustId());
		// balance.setChangeType("02"); // 查询总支出和现金支出
		balance.setStartTimeStr(accountReqVO.getStartTime());
		balance.setEndTimeStr(accountReqVO.getEndTime());
		List<BalanceAccountCChangeSeq> SeqList = balanceAccountCChangeSeqMapper.selectBalanceSeq(balance);
		BigDecimal totalPay = new BigDecimal("0");// 总支出
		BigDecimal cashAmountPay = new BigDecimal("0");// 现金支出
		BigDecimal cashAmount = new BigDecimal("0");// 提现支出
		BigDecimal totalDeposit = new BigDecimal("0");// 总存入
		BigDecimal totalShiftTo = new BigDecimal("0");// 总转入
		BigDecimal lastSurplus = new BigDecimal("0");// 日中结余 TODO
		BigDecimal freezeCashAmout = new BigDecimal("0");// 冻结

		PageHelper.startPage(accountReqVO.getPageNum(), accountReqVO.getPageSize());
		List<BalanceAccountCChangeSeqResp> list = new ArrayList<BalanceAccountCChangeSeqResp>();
		PageInfo<BalanceAccountCChangeSeqResp> pageList = new PageInfo<BalanceAccountCChangeSeqResp>(list);
		if (!CollectionUtils.isEmpty(SeqList)) {
			for (BalanceAccountCChangeSeq seq : SeqList) {
				BalanceAccountCChangeSeqResp resp = new BalanceAccountCChangeSeqResp();
				if (seq.getChangeType().equals("02")) {
					// 查询总支出和现金支出
					totalPay = seq.getPreamount().subtract(seq.getAmount());
					cashAmountPay = seq.getPreamount().subtract(seq.getAmount());
				}
				if (seq.getChangeType().equals("03")) {
					// 查询提现支出
					cashAmount = seq.getPreamount().subtract(seq.getAmount());
				}
				if (seq.getChangeType().equals("01")) {
					// 总存入
					totalDeposit = seq.getAmount().subtract(seq.getPreamount());
				}
				resp.setTotalPay(totalPay);
				resp.setCashAmountPay(cashAmountPay);
				resp.setCashAmount(cashAmount);
				resp.setTotalDeposit(totalDeposit);
				resp.setTotalShiftTo(totalShiftTo);
				resp.setLastSurplus(lastSurplus);
				resp.setTotalShiftTo(freezeCashAmout);
				list.add(resp);
			}
		}
		resultMap.put("data", pageList);
		return resultMap;
	}

	@Override
	public int updateAccount(AccountReqVO accountReqVO) {
		/*
		 * BalanceAccountC bean = new BalanceAccountC();
		 * bean.setCustId(accountReqVO.getCustId());
		 * bean.setCustName(accountReqVO.getCustName()); return
		 * balanceAccountCMapper.updateByCustId(bean);
		 */
		return 1; // TODO
	}

	@Override
	@Transactional
	public boolean updateAccountAmount(AccountCChangeVo vo, BalanceAccountC balanceAccountC) {
		BigDecimal oldAmount = (balanceAccountC.getAmount() == null ? BigDecimal.ZERO : balanceAccountC.getAmount());
		BigDecimal amount = oldAmount.add(new BigDecimal(vo.getMoney()).divide(new BigDecimal("100")));
		balanceAccountC.setAmount(amount);
		int refV = balanceAccountCMapper.updateByPrimaryKeySelective(balanceAccountC);

		BalanceAccountCChangeSeq seq = new BalanceAccountCChangeSeq();
		seq.setSn(UUID.randomUUID().toString());
		seq.setAccountId(balanceAccountC.getId());
		seq.setCustId(vo.getUserId());
		seq.setAccountType(vo.getcOrB() + "");
		seq.setSeqFlag(vo.getOptType() == 1 ? "0" : "1");
		seq.setChangeType(vo.getOptType() == 1 ? "09" : "02");
		seq.setCustName(balanceAccountC.getCustName());
		seq.setPreamount(oldAmount);
		seq.setAmount(amount);
		seq.setOrderId(vo.getOrderId());
		seq.setOrderStatus(1);
		seq.setCreateTime(new Date());
		int refV1 = balanceAccountCChangeSeqMapper.insert(seq);
		return refV == 1 && refV1 == 1 ? true : false;
	}

}
