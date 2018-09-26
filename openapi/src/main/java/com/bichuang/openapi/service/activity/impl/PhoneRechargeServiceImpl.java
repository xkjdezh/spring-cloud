package com.bichuang.openapi.service.activity.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.bichuang.openapi.config.PhoneRechargeConfig;
import com.bichuang.openapi.controller.PhoneRechargeiController;
import com.bichuang.openapi.repository.mapper.OpenPhoneRechargeMapper;
import com.bichuang.openapi.repository.model.OpenPhoneRecharge;
import com.bichuang.openapi.repository.model.OpenPhoneRechargeExample;
import com.bichuang.openapi.service.activity.PhoneRechargeService;
import com.bichuang.platform.common.util.DateUtil;
import com.bichuang.platform.common.util.UniqId;
import com.bichuang.platform.common.vo.activity.PhoneRechargeVoReq;
import com.bichuang.platform.common.vo.activity.PhoneRechargeVoRsp;
import com.google.common.collect.Maps;

@Service
public class PhoneRechargeServiceImpl implements PhoneRechargeService{

	private static Logger logger = LoggerFactory.getLogger(PhoneRechargeiController.class);
	
	@Autowired
	private OpenPhoneRechargeMapper openPhoneRechargeMapper;
	
	@Autowired
	RestTemplate rest;
	@Autowired
	PhoneRechargeConfig phoneRechargeConfig;
	
	@Override
	public int recharge(PhoneRechargeVoReq vo) {
		Map<String,Object> map =Maps.newHashMap();
		
		String uniqID = UniqId.getInstance().getUniqID();
		
		map.put("mobile", vo.getMobile());
		map.put("package", phoneRechargeConfig.getPackages());
		map.put("orderid",UniqId.getInstance().getUniqID());
	
		
		JSONObject forObject = phoneRechargeConfig.doReq(map,"recharge",rest);
	
		if(forObject !=null && forObject.containsKey("code") && forObject.containsKey("message")) {
			 logger.info("result: " +forObject.toJSONString());
			OpenPhoneRecharge re=  getNewVo(vo);
			re.setApplyAmount(new BigDecimal(phoneRechargeConfig.getPackages()));
			re.setBizType(vo.getBizType());
			re.setInitSubmitTime(new Date());
			re.setOrderId(uniqID);
			re.setCode(forObject.getInteger("code"));
			re.setMessage(forObject.getString("message"));
			if(forObject.containsKey("taskid")) {
				re.setTaskId(forObject.getString("taskid"));
			}
			 return openPhoneRechargeMapper.insert(re);
			
		}
		return 0;
		
	}



	@Override
	public int rechargeCallback(PhoneRechargeVoRsp vo ) {
		OpenPhoneRecharge re=  new OpenPhoneRecharge();
		re.setStatus(vo.getStatus());
		re.setCertId(vo.getCert());
		re.setMessage(vo.getMessage());
		re.setCode(vo.getCode());
		re.setDeductAmount(new BigDecimal(vo.getMoney()));
		re.setTaskId(vo.getTaskid());
		
		OpenPhoneRechargeExample ex=new  OpenPhoneRechargeExample();
		ex.createCriteria().andOrderIdEqualTo(vo.getOrderid()).andMobilePhoneEqualTo(vo.getMobile());
		return openPhoneRechargeMapper.updateByExampleSelective(re, ex);
	}
	
	private OpenPhoneRecharge getNewVo(PhoneRechargeVoReq vo) {
		OpenPhoneRecharge re= new OpenPhoneRecharge();
		re.setOrderId(vo.getOrderid());
		re.setUserId(vo.getUserId());
		re.setMobilePhone(vo.getMobile());
		re.setApplyAmount(new BigDecimal(vo.getApplyAmount()));
		re.setBizType(vo.getBizType());
		re.setStatus(vo.getStatus());
		return re;
	}
	

}
