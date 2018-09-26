package com.bichuang.platform.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSUtil {
	private static String account = PropertiesUtil.getString("APIID");
	private static String password = PropertiesUtil.getString("APIKEY");
	
	private static final Logger log = LoggerFactory.getLogger(SMSUtil.class);
	
	public static void sendsms(String mobile,String content){
		String sendsmsUrl = "http://106.ihuyi.com/webservice/sms.php?method=Submit";
		sendsmsUrl = sendsmsUrl+"&account="+account+"&password="+password+"&mobile="+mobile+"&content="+content;
		String result = HttpUtils.httpGet(sendsmsUrl);
		log.info("手机号:{}短信:{}发送结果:{}",mobile,content,result);
	}
}
