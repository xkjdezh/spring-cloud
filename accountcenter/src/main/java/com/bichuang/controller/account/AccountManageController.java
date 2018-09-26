package com.bichuang.controller.account;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bichuang.platform.common.constant.ApiConstant;
import com.bichuang.platform.common.constant.Constant;
import com.bichuang.platform.common.util.FastJsonUtil;
import com.bichuang.service.account.BalanceAccountCService;
import com.bichuang.vo.account.AccountReqVO;
import com.bichuang.vo.account.ApplyBindBankCardReqVO;
import com.bichuang.vo.account.BindBankCardReqVO;
import com.bichuang.vo.account.ResponseResultVO;
import com.bichuang.vo.account.SendSmsReqVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 账户管理api入口类
 * 
 * 开户、修改、实名认证、绑卡、修改密码、账户查询等
 * 
 * @author meidf
 * @version v1.0
 * @see AccountManageController
 * @since 2018/03/26
 */
@RestController
@RequestMapping("/account")
@Api(tags = ApiConstant.SWAGGER_GROUP_ACCOUNT)
public class AccountManageController {

	private Logger logger = LoggerFactory.getLogger(AccountManageController.class);

	@Autowired
	BalanceAccountCService balanceAccountCService;

	/**
	 * 开户
	 * 
	 * @param request
	 * @param accountReqVO
	 * @return
	 * @throws Exception
	 * @throws SystemException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/createAccount", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "开户功能接口" + ApiConstant.DEVELOPER_MDF, notes = "开户", produces = Constant.JSON_UTF8)
	public ResponseResultVO createAccount(HttpServletRequest request, @RequestBody AccountReqVO accountReqVO) {
		logger.info("start createAccount  .......");
		ResponseResultVO resp = new ResponseResultVO();
		Map<String, Object> resultMap;
		try {
			resultMap = balanceAccountCService.requestCreateMember(accountReqVO);
			if (resultMap.get("status").toString().equals(Constant.SUCCEES_CODE)) {
				resp = new ResponseResultVO(Constant.SUCCEES_CODE, "createAccount success");
				return resp;
			} else if (resultMap.get("status").toString().equals(Constant.RESULT_1001)) {
				resp = new ResponseResultVO(Constant.RESULT_1001, "已开户");
				return resp;
			}
		} catch (Exception e) {
			logger.error("createAccount", e);
		}
		resp = new ResponseResultVO(Constant.FAIL_CODE, "createAccount faild");
		return resp;

	}

	/**
	 * 修改账户
	 * 
	 * @param request
	 * @param accountReqVO
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/editAcount", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "修改账户功能接口" + ApiConstant.DEVELOPER_MDF, notes = "修改账户", produces = Constant.JSON_UTF8)
	public ResponseResultVO editAcount(HttpServletRequest request, @RequestBody AccountReqVO accountReqVO) {
		logger.info("start editAcount .......");
		ResponseResultVO resp = new ResponseResultVO();
		int row = balanceAccountCService.updateAccount(accountReqVO);
		if (row > 0) {
			resp = new ResponseResultVO(Constant.SUCCEES_CODE, "修改账户成功");
			return resp;
		}
		return resp;
	}

	/**
	 * 实名认证
	 * 
	 * @param request
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/authRealName", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "实名认证功能接口" + ApiConstant.DEVELOPER_MDF, notes = "实名认证", produces = Constant.JSON_UTF8)
	public ResponseResultVO authRealName(HttpServletRequest request, @RequestBody AccountReqVO accountReqVO)
			throws Exception {
		logger.info("start authRealName ......");
		ResponseResultVO resp = new ResponseResultVO();
		Map<String, Object> map = balanceAccountCService.requestAuthRealname(accountReqVO);
		if (map.get("status").toString().equals(Constant.SUCCEES_CODE)) {
			resp = new ResponseResultVO(Constant.SUCCEES_CODE, "authRealName success");
			return resp;
		} else if (map.get("status").toString().equals(Constant.RESULT_1001)) {
			resp = new ResponseResultVO(Constant.RESULT_1001, "已实名");
			return resp;
		}
		resp = new ResponseResultVO(Constant.FAIL_CODE, "authRealName falid");
		return resp;
	}

	/**
	 * 会员电子协议签约
	 * 
	 * @param request
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/signContract", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "会员电子协议签约功能接口" + ApiConstant.DEVELOPER_MDF, notes = "会员电子协议签约", produces = Constant.JSON_UTF8)
	public ResponseResultVO signContract(HttpServletRequest request, @RequestBody AccountReqVO accountReqVO)
			throws Exception {
		logger.info("start signContract ......");
		ResponseResultVO resp = new ResponseResultVO();
		Map<String, Object> map = balanceAccountCService.requestSignContract(accountReqVO);
		if (map.get("status").toString().equals(Constant.SUCCEES_CODE)) {
			resp = new ResponseResultVO(Constant.SUCCEES_CODE, "signContract success");
			return resp;
		}
		resp = new ResponseResultVO(Constant.FAIL_CODE, "signContract faild");
		return resp;
	}

	/**
	 * 会员电子协议签约通知
	 * 
	 * @param request
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/signContractNotify", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "会员电子协议签约通知接口"
			+ ApiConstant.DEVELOPER_MDF, notes = "会员电子协议签约通知", produces = Constant.JSON_UTF8)
	public ResponseResultVO signContractNotify(HttpServletRequest request, @RequestBody AccountReqVO accountReqVO)
			throws Exception {
		logger.info("start signContract ......");
		ResponseResultVO resp = new ResponseResultVO();
		JSONObject json = balanceAccountCService.requestSignContractNotify(accountReqVO);
		if (json.getString("status").toString().equals(Constant.SUCCEES_CODE)) {
			resp = new ResponseResultVO(Constant.SUCCEES_CODE, "signContract success");
			return resp;
		}
		return resp;
	}

	/**
	 * 发送短信验证码
	 * 
	 * @param request
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/sendSmsCode", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "发送短信验证码接口" + ApiConstant.DEVELOPER_MDF, notes = "实名认证", produces = Constant.JSON_UTF8)
	public ResponseResultVO sendSmsCode(HttpServletRequest request, @RequestBody SendSmsReqVO sendSmsReqVO)
			throws Exception {
		logger.info("start sendSmsCode ......");
		ResponseResultVO resp = new ResponseResultVO();
		JSONObject json = balanceAccountCService.requestSendSms(sendSmsReqVO);
		if (json.get("status").toString().equals(Constant.SUCCEES_CODE)) {
			resp = new ResponseResultVO<>(Constant.SUCCEES_CODE, "sendSmsCode success");
		}
		return resp;
	}

	/**
	 * 绑定手机(无验证码)
	 * 
	 * @param request
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/bindPhone", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "绑定手机接口" + ApiConstant.DEVELOPER_MDF, notes = "绑定手机", produces = Constant.JSON_UTF8)
	public ResponseResultVO bindPhone(HttpServletRequest request, @RequestBody SendSmsReqVO sendSmsReqVO)
			throws Exception {
		logger.info("start bindPhone ......");
		ResponseResultVO resp = new ResponseResultVO();
		Map<String, Object> map = balanceAccountCService.requestBindPhone(sendSmsReqVO);
		if (map.get("status").toString().equals(Constant.SUCCEES_CODE)) {
			resp = new ResponseResultVO<>(Constant.SUCCEES_CODE, "bindPhone success");
			return resp;
		} 
		if(map.get("status").toString().equals(Constant.RESULT_1001)){
			resp = new ResponseResultVO<>(Constant.FAIL_CODE, "已绑定");
			return resp;
		}
		resp = new ResponseResultVO<>(Constant.FAIL_CODE, "bindPhone faild");
		return resp;
	}

	/**
	 * 设置支付密码
	 * 
	 * @param request
	 * @param accountReqVO
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/setPayPwd", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "设置支付密码接口" + ApiConstant.DEVELOPER_MDF, notes = "设置支付密码", produces = Constant.JSON_UTF8)
	public ResponseResultVO setPayPwd(HttpServletRequest request, @RequestBody AccountReqVO accountReqVO)
			throws Exception {
		logger.info("start setPayPwd ......");
		ResponseResultVO resp = new ResponseResultVO();
		Map<String, Object> map = balanceAccountCService.requestSetPayPwd(accountReqVO);
		if (map.get("status").toString().equals(Constant.SUCCEES_CODE)) {
			resp = new ResponseResultVO<>(Constant.SUCCEES_CODE, "setPayPwd success");
		}
		return resp;
	}

	/**
	 * 修改支付密码
	 * 
	 * @param request
	 * @param account
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "修改密码功能接口" + ApiConstant.DEVELOPER_MDF, notes = "实名认修改支付密码", produces = Constant.JSON_UTF8)
	public ResponseResultVO updatePwd(HttpServletRequest request, @RequestBody AccountReqVO accountReqVO) {
		logger.info("进入修改密码功能接口 authRealName");

		return null;
	}

	/**
	 * 查询卡 bin
	 * 
	 * @param request
	 * @param account
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getBankCardBin", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "查询卡 bin功能接口" + ApiConstant.DEVELOPER_MDF, notes = "查询卡 bin", produces = Constant.JSON_UTF8)
	public ResponseResultVO getBankCardBin(HttpServletRequest request,
			@RequestBody ApplyBindBankCardReqVO applyBindBankCardReqVO) throws Exception {
		logger.info("start getBankCardBin ......");
		ResponseResultVO resp = new ResponseResultVO<>();
		Map<String, Object> resultMap = balanceAccountCService.requestgetBankCardBin(applyBindBankCardReqVO);
		if (resultMap.get("status").toString().equals(Constant.SUCCEES_CODE)) {
			resp = new ResponseResultVO(Constant.SUCCEES_CODE, "getBankCardBin successs",
					FastJsonUtil.toJson(resultMap));
			return resp;
		}
		return resp;
	}

	/**
	 * 请求绑定银行卡
	 * 
	 * @param request
	 * @param applyBindBankCardReqVO
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/applyBindBankCard", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "请求绑定银行卡功能接口" + ApiConstant.DEVELOPER_MDF, notes = "请求绑定银行卡", produces = Constant.JSON_UTF8)
	public ResponseResultVO applyBindBankCard(HttpServletRequest request,
			@RequestBody ApplyBindBankCardReqVO applyBindBankCardReqVO) throws Exception {
		logger.info("start applyBindBankCard ......");
		ResponseResultVO resp = new ResponseResultVO<>();
		Map<String, Object> resultMap = balanceAccountCService.requestApplyBindBankCard(applyBindBankCardReqVO);
		if (resultMap.get("status").toString().equals(Constant.SUCCEES_CODE)) {
			resp = new ResponseResultVO(Constant.SUCCEES_CODE, "applyBindBankCard successs",
					FastJsonUtil.toJson(resultMap));
			return resp;
		} else if (resultMap.get("status").toString().equals(Constant.RESULT_1001)) {
			resp = new ResponseResultVO(Constant.RESULT_1001, "已绑卡");  
			return resp;
		}
		resp = new ResponseResultVO(Constant.FAIL_CODE, "绑卡失败"); 
		return resp;
	}

	/**
	 * 确认绑定银行卡
	 * 
	 * @param request
	 * @param bindBankCardReqVO
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/bindBankCard", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "确认绑定银行卡功能接口" + ApiConstant.DEVELOPER_MDF, notes = "确认绑定银行卡", produces = Constant.JSON_UTF8)
	public ResponseResultVO bindBankCard(HttpServletRequest request, @RequestBody BindBankCardReqVO bindBankCardReqVO)
			throws Exception {
		logger.info("start getAccount ......");
		ResponseResultVO resp = new ResponseResultVO();
		Map<String, Object> resultMap = balanceAccountCService.requestBindBankCard(bindBankCardReqVO);
		if (resultMap.get("status").toString().equals(Constant.SUCCEES_CODE)) {
			resp = new ResponseResultVO(Constant.SUCCEES_CODE, "bindBankCard successs", FastJsonUtil.toJson(resultMap));
			return resp;
		}
		resp = new ResponseResultVO(Constant.FAIL_CODE, "bindBankCard faild");
		return resp;
	}

}
