package com.bichuang.controller.account;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bichuang.platform.common.constant.Constant;
import com.bichuang.repository.model.account.BalanceAccountC;
import com.bichuang.service.account.BalanceAccountCService;
import com.bichuang.vo.account.AccountCChangeVo;
import com.bichuang.vo.account.ResponseResultVO;

/**
 * 费用中心调用 账户扣款
 *
 */
@Controller
@RequestMapping("/accountFee")
public class AccountFeeController {
	
	private Logger logger = LoggerFactory.getLogger(AccountFeeController.class);
	
	@Autowired
	BalanceAccountCService balanceAccountCService;
	
	
	@PostMapping(value = "/changeCost")
	@ResponseBody
	public ResponseResultVO changeCost(HttpServletRequest request, @RequestBody AccountCChangeVo vo){
		logger.info(" AccountFeeController  start changeFee ......");
		ResponseResultVO resp = new ResponseResultVO();
		try {
			if(StringUtils.isEmpty(vo.getUserId())){
				resp = new ResponseResultVO(Constant.FAIL_CODE, "用户id不能为空！", null);
				return resp;
			}
			if(vo.getMoney()==null){
				resp = new ResponseResultVO(Constant.FAIL_CODE, "变动金额不能为空！", null);
				return resp;
			}
			if(vo.getOptType()==null){
				resp = new ResponseResultVO(Constant.FAIL_CODE, "操作类型不能为空！", null);
				return resp;
			}
			BalanceAccountC balanceAccountC = balanceAccountCService.getBalanceAccountC(vo.getUserId());
			if(balanceAccountC==null
					||balanceAccountC.getId()==null){
				resp = new ResponseResultVO(Constant.FAIL_CODE, "该用户没有注册！", null);
				return resp;
			}
			BigDecimal money = new BigDecimal(vo.getMoney()/100);
			
			if(balanceAccountC.getAmount()==null
					&&2==vo.getOptType()
					&&balanceAccountC.getAmount().subtract(money).compareTo(BigDecimal.ZERO)<0){
				resp = new ResponseResultVO(Constant.FAIL_CODE, "扣减余额不够！", null);
				return resp;
			}
			
			if(balanceAccountCService.updateAccountAmount(vo, balanceAccountC)){
				resp = new ResponseResultVO(Constant.SUCCEES_CODE, "交易成功！");
			}else{
				resp = new ResponseResultVO(Constant.FAIL_CODE, "交易失败！");
			}
			
		} catch (Exception e) {
			logger.error("交易异常："+e.getMessage());
			resp = new ResponseResultVO(Constant.FAIL_CODE, "交易失败！");
		}
		return resp;
	}
}
