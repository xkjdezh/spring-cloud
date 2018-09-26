package com.bichuang.openapi.config;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bichuang.openapi.controller.PhoneRechargeiController;
import com.bichuang.platform.common.util.CommonUtil;
import com.bichuang.platform.common.util.DateUtil;
import com.google.common.collect.Maps;

@Component
@ConfigurationProperties(prefix="huyi.config")
public class PhoneRechargeConfig {

	private static Logger logger = LoggerFactory.getLogger(PhoneRechargeConfig.class);
	
	String username;
	
	Double packages;
	
	String appKey;
	
	Map<String,String> map =new HashMap<>(8);

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getPackages() {
		return packages;
	}

	public void setPackages(Double packages) {
		this.packages = packages;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
	public JSONObject doReq(Map<String, Object> map,String which ,RestTemplate rest) {
		if(map == null) {
			map =Maps.newHashMap();
		}
		map.put("username", this.getUsername());
		map.put("timestamp", DateUtil.date2Str(new Date(), DateUtil.yyyyMMDDHHDDSS));
		map=CommonUtil.sortByKey(map,true);//
		String reqData=CommonUtil.mapToGet(map);
		
		String toSigin= MessageFormat.format("apikey={0}&{1}", this.getAppKey(),reqData);
		
		String sgin =DigestUtils.md5Hex(toSigin);
		
		String url =this.getMap().get(which);
		
		String completeUrl = MessageFormat.format("{0}&{1}&sign={2}", url,reqData, sgin);
		
		logger.debug("requsetUrl:" +completeUrl);
		
		 JSONObject forObject = rest.getForObject(completeUrl,JSONObject.class);
		return forObject;
	}
}
