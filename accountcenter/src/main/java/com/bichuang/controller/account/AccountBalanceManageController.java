package com.bichuang.controller.account;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bichuang.platform.common.constant.ApiConstant;
import com.bichuang.platform.common.constant.Constant;
import com.bichuang.platform.common.exception.SystemException;
import com.bichuang.platform.common.util.FastJsonUtil;
import com.bichuang.service.account.BalanceAccountCService;
import com.bichuang.vo.account.AccountReqVO;
import com.bichuang.vo.account.DepositApplyReqVO;
import com.bichuang.vo.account.DepositNotifyReqVO;
import com.bichuang.vo.account.ResponseResultVO;
import com.bichuang.vo.account.WithdrawApplyReqVO;

import io.swagger.annotations.ApiOperation;

/**
 * 账户资金管理api入口
 * 
 * 充值、提现、扣款、转账等交易管理
 * 
 * @author meidf
 * @version
 * @see AccountBalanceManageController
 * @since
 */
@RestController
@RequestMapping("/accountBalance")
public class AccountBalanceManageController {

	private Logger logger = LoggerFactory.getLogger(AccountManageController.class);

	@Autowired
	BalanceAccountCService balanceAccountCService;

	/**
	 * 充值申请
	 * 
	 * @param request
	 * @param accountReqVO
	 * @return
	 * @throws Exception
	 * @throws SystemException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/depositApply", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "充值功能接口" + ApiConstant.DEVELOPER_MDF, notes = "充值申请", produces = Constant.JSON_UTF8)
	public ResponseResultVO depositApply(HttpServletRequest request, @RequestBody DepositApplyReqVO depositApplyReqVO)
			throws SystemException, Exception {
		logger.info("start depositApply ......");
		ResponseResultVO resp = new ResponseResultVO();
		Map<String, Object> resultMap = balanceAccountCService.requestDepositApply(depositApplyReqVO);
		if (resultMap.get("status").toString().equals("success")) {
			resp = new ResponseResultVO(Constant.SUCCEES_CODE, "充值成功", FastJsonUtil.toJson(resultMap));
			return resp;
		}
		resp = new ResponseResultVO(Constant.FAIL_CODE, "depositApply faild");
		return resp;
	}

	/**
	 * 充值通知
	 * 
	 * @param request
	 * @param accountReqVO
	 * @return
	 * @throws Exception
	 * @throws SystemException
	 */
	@RequestMapping(value = "/depositNotify", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "充值通知功能接口" + ApiConstant.DEVELOPER_MDF, notes = "充值通知", produces = Constant.JSON_UTF8)
	public void depositNotify(HttpServletRequest request, HttpServletResponse response)
			throws SystemException, Exception {
		logger.info("start depositNotify ......");
		StringBuffer receiveMessage = new StringBuffer();
		Scanner scanner = new Scanner(request.getInputStream(), "utf-8");
		while (scanner.hasNext()) {
			receiveMessage.append(scanner.next());
		}
		scanner.close();
		String json = receiveMessage.toString();
		Map<String, Object> resMap = FastJsonUtil.jsonToMap(json);

		// 修改账户余额 TODO Mapper 文件
		if (!CollectionUtils.isEmpty(resMap)) {
			DepositNotifyReqVO vo = new DepositNotifyReqVO();
			vo.setBizUserId(resMap.get("buyerBizUserId").toString());
			vo.setAmount(new BigDecimal(resMap.get("amount").toString()));
			vo.setType(1);
			balanceAccountCService.updateAmount(vo);
			logger.info("充值成功......");

			// 修改订单状态,记录回调时间 TODO
			//vo.setOrderNo(resMap.get("orderNo").toString());
			vo.setBizOrderNo(resMap.get("bizOrderNo").toString());
			balanceAccountCService.updateOrderStatus(vo);
			logger.info("修改订单状态成功......");
		}
	}

	/**
	 * 申请提现
	 * 
	 * @param request
	 * @param accountReqVO
	 * @return
	 * @throws Exception
	 * @throws SystemException
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/withdrawApply", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "申请提现功能接口" + ApiConstant.DEVELOPER_MDF, notes = "申请提现", produces = Constant.JSON_UTF8)
	public ResponseResultVO withdrawApply(HttpServletRequest request,
			@RequestBody WithdrawApplyReqVO withdrawApplyReqVO) throws SystemException, Exception {
		logger.info("start  withdrawApply ......");
		ResponseResultVO resp = new ResponseResultVO();
		Map<String, Object> resultMap = balanceAccountCService.requestWithdrawApply(withdrawApplyReqVO);
		if (resultMap.get("status").toString().equals(Constant.SUCCEES_CODE)) {
			resp = new ResponseResultVO(Constant.SUCCEES_CODE, "withdrawApply success", FastJsonUtil.toJson(resultMap));
			return resp;
		}
		resp = new ResponseResultVO(Constant.FAIL_CODE, "withdrawApply faild");
		return resp;
	}

	/**
	 * 提现确认支付(后台加短信)
	 * 
	 * @param request
	 * @param accountReqVO
	 * @return
	 * @throws Exception
	 * @throws SystemException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/withDrawConfirmPay", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "提现确认支付功能接口" + ApiConstant.DEVELOPER_MDF, notes = "提现确认支付", produces = Constant.JSON_UTF8)
	public ResponseResultVO withDrawConfirmPay(HttpServletRequest request,
			@RequestBody WithdrawApplyReqVO withdrawApplyReqVO) throws SystemException, Exception {
		logger.info("start  withDrawConfirmPay ......");
		ResponseResultVO resp = new ResponseResultVO();
		Map<String, Object> resultMap = balanceAccountCService.WithdrawConfirmPay(withdrawApplyReqVO);
		if (resultMap.get("status").toString().equals(Constant.SUCCEES_CODE)) {
			resp = new ResponseResultVO(Constant.SUCCEES_CODE, "withDrawConfirmPay success",
					FastJsonUtil.toJson(resultMap));
			return resp;
		}   
		resp = new ResponseResultVO(Constant.FAIL_CODE, "withDrawConfirmPay faild");
		return resp;
	}

	/**
	 * 申请提现通知
	 * 
	 * @param request
	 * @param accountReqVO
	 * @return
	 * @throws Exception
	 * @throws SystemException
	 */
	@RequestMapping(value = "/withdrawNotify", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "申请提现通知功能接口" + ApiConstant.DEVELOPER_MDF, notes = "申请提现通知", produces = Constant.JSON_UTF8)
	public void withdrawNotify(HttpServletRequest request, @RequestBody WithdrawApplyReqVO withdrawApplyReqVO)
			throws SystemException, Exception {
		logger.info("start  withdrawNotify ......");
		StringBuffer receiveMessage = new StringBuffer();
		Scanner scanner = new Scanner(request.getInputStream(), "utf-8");
		while (scanner.hasNext()) {
			receiveMessage.append(scanner.next());
		}
		scanner.close();
		String json = receiveMessage.toString();
		Map<String, Object> resMap = FastJsonUtil.jsonToMap(json);

		if (!CollectionUtils.isEmpty(resMap)) {
			// 修改账户余额
			DepositNotifyReqVO vo = new DepositNotifyReqVO();
			vo.setBizUserId(resMap.get("buyerBizUserId").toString());
			vo.setAmount(new BigDecimal(resMap.get("amount").toString()));
			vo.setType(2);
			balanceAccountCService.updateAmount(vo);
			logger.info("提现成功......");

			// 修改订单状态,记录回调时间
			vo.setBizOrderNo(resMap.get("bizOrderNo").toString());
			balanceAccountCService.updateOrderStatus(vo);
			logger.info("修改订单状态成功......");
		}
	}

	/**
	 * 查询余额
	 * 
	 * @param request
	 * @param accountReqVO
	 * @return
	 * @throws Exception
	 * @throws SystemException
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/queryBalance", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "查询余额功能接口" + ApiConstant.DEVELOPER_MDF, notes = "查询余额", produces = Constant.JSON_UTF8)
	public ResponseResultVO queryBalance(HttpServletRequest request, @RequestBody AccountReqVO accountReqVO)
			throws SystemException, Exception {
		logger.info("start  queryBalance ......");
		ResponseResultVO resp = new ResponseResultVO();
		Map<String, Object> resultMap = balanceAccountCService.requestQueryBalance(accountReqVO);
		if (!CollectionUtils.isEmpty(resultMap)) {
			resp = new ResponseResultVO(Constant.SUCCEES_CODE, "queryBalance success", FastJsonUtil.toJson(resultMap));
			return resp;
		}
		resp = new ResponseResultVO(Constant.FAIL_CODE, "queryBalance faild", FastJsonUtil.toJson(resultMap));
		return resp;
	}

	/**
	 * 查询账户流水
	 * 
	 * @param request
	 * @param accountReqVO
	 * @return
	 * @throws Exception
	 * @throws SystemException
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/queryInExpDetail", method = RequestMethod.POST, produces = Constant.JSON_UTF8)
	@ApiOperation(value = "查询账户流水接口" + ApiConstant.DEVELOPER_MDF, notes = "查询账户流水", produces = Constant.JSON_UTF8)
	public ResponseResultVO queryInExpDetail(HttpServletRequest request, @RequestBody AccountReqVO accountReqVO)
			throws SystemException, Exception {
		logger.info("start  queryInExpDetail ......");
		ResponseResultVO resp = new ResponseResultVO();
		Map<String, Object> resultMap = balanceAccountCService.queryInExpDetail(accountReqVO);
		if (!CollectionUtils.isEmpty(resultMap)) {
			resp = new ResponseResultVO(Constant.SUCCEES_CODE, "queryInExpDetail success",
					FastJsonUtil.toJson(resultMap));
			return resp;
		}
		return resp;
	}

}
