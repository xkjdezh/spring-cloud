package com.bichuang.openapi.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bichuang.openapi.config.PhoneRechargeConfig;
import com.bichuang.openapi.service.activity.PhoneRechargeService;
import com.bichuang.platform.common.base.RespCode;
import com.bichuang.platform.common.base.RespEntity;
import com.bichuang.platform.common.util.DoubleUtils;
import com.bichuang.platform.common.vo.activity.PhoneRechargeVoReq;
import com.bichuang.platform.common.vo.activity.PhoneRechargeVoRsp;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




@Api(tags= {"openapi"})
@RestController("/openapi")
public class PhoneRechargeiController {

	private static Logger logger = LoggerFactory.getLogger(PhoneRechargeiController.class);


	@Autowired
	PhoneRechargeService phoneRechargeService;

	@Autowired
	PhoneRechargeConfig phoneRechargeConfig;
	@Autowired
	RestTemplate rest;
	@Autowired
    private Environment env;

	@ApiOperation(value = "用户话费充值", notes = "用户话费充值接口")
	@GetMapping("/phone/recharge")
	public RespEntity phoneRearge(@Validated PhoneRechargeVoReq vo,BindingResult result) {
		logger.info("/phone/recharge :"+ JSON.toJSONString(vo));
		for (ObjectError error : result.getAllErrors()) {
            return RespEntity.getRespEntityFail(error.getDefaultMessage());
        }
		int res = phoneRechargeService.recharge(vo);
		if(res>0) {
			return new RespEntity(RespCode.SUCCESS);
		}
		return RespEntity.getRespEntityFail("话费充值失败");
}

	@ApiOperation(value = "用户话费充值回调接口", notes = "用户话费充值回调接口")
	@PostMapping("/phone/recharge/callback")
	public String phoneReargeCallback( PhoneRechargeVoRsp vo) {
		logger.info("/phone/recharge/callback :"+ JSON.toJSONString(vo));
          int res = phoneRechargeService.rechargeCallback(vo);
		if(res > 0) {
			return "success";
		}
		return "fail";
	}
	
	@ApiOperation(value = "配置用户话费充值金额(0-100之间)", notes = "配置用户话费充值金额(0-100之间)")
	@GetMapping("/phone/recharge/config")
	public RespEntity configReargeAmount(double packages) {
		packages=DoubleUtils.round(packages,2);
		Range<Double> numberRange = Range.closed(0.01, 100.00);
		if(numberRange.contains(packages)) {
			phoneRechargeConfig.setPackages(packages);
			
			return new RespEntity(RespCode.SUCCESS);
		}
		return RespEntity.getRespEntityFail("话费充值金额设置失败,金额应该在0.01到100之间");
	}
	
	@ApiOperation(value = "话费账户可用余额查询", notes = "话费账户可用余额查询")
	@GetMapping("/phone/recharge/balance")
	public RespEntity getBalance() {
		 JSONObject doReq = phoneRechargeConfig.doReq(null, "getbalance", rest);
		return RespEntity.getRespEntitySuc(doReq);
	}
	
	@ApiOperation(value = "话费充值订单状态查询", notes = "话费充值订单状态查询")
	@GetMapping("/phone/recharge/orderid")
	public RespEntity getOrderInfo(String orderid) {
        Map<String,Object> map =Maps.newHashMap();
      	map.put("orderid", orderid);
		JSONObject doReq = phoneRechargeConfig.doReq(map, "getorderinfo", rest);
		return RespEntity.getRespEntitySuc(doReq);
	}
	@ApiOperation(value = "话费充值查询话费包档位", notes = "话费充值查询话费包档位")
	@GetMapping("/phone/recharge/packages")
	public RespEntity getPackages() {
		JSONObject doReq = phoneRechargeConfig.doReq(null, "getpackages", rest);
		return RespEntity.getRespEntitySuc(doReq);
	}
}
