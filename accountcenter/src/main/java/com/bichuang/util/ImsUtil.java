package com.bichuang.util;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import ime.service.client.SOAClient;
import ime.service.util.RSAUtil;

@Component
public class ImsUtil implements CommandLineRunner {
	
	private static SOAClient client;
	private static PublicKey publicKey;
	private static PrivateKey privateKey;
	
	@Value("${tl.sysid}")
	private  String sysId;

	@Value("${tl.server.address}")
	private  String tlServerAddress;

	@Value("${tl.pwd}")
	private  String passwd;

	@Value("${tl.alias}")
	private  String tlAlias;
	
  
	/*@BeforeClass
	public  void beforeClass() throws Exception {
		String serverAddress =  tlServerAddress;
		String sysid =sysId;
		String pwd = passwd;
		// 证书名称
		String alias = tlAlias;
		String path =  ClassUtils.getDefaultClassLoader().getResource("100009001000.pfx").getPath();
		String signMethod = "SHA1WithRSA";
		try {
			privateKey = RSAUtil.loadPrivateKey(alias, path, pwd);
			publicKey = RSAUtil.loadPublicKey(alias, path, pwd);
			client = new SOAClient();
			client.setServerAddress(serverAddress);
			client.setSignKey(privateKey);
			client.setPublicKey(publicKey);
			client.setSysId(sysid);
			client.setSignMethod(signMethod);
			System.out.println("beforeClass success.");
		} catch (Exception e) {
			System.out.println("beforeClass error.");
			e.printStackTrace();
		}
	
	}*/

	// RSA加密
	public  String rsaEncrypt(String str) throws Exception {
		try {
			System.out.println("rsaEncrypt start");
			RSAUtil rsaUtil = new RSAUtil((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);
			String encryptStr = rsaUtil.encrypt(str);
			return encryptStr;
		} catch (Exception e) {
			System.out.println("rsaEncrypt error");
			e.printStackTrace();
			throw e;
		}
	}
	
	public JSONObject sendHttpRequst(String service, String method, JSONObject param) throws Exception {
		String path = ClassUtils.getDefaultClassLoader().getResource("100009001000.pfx").getPath();
		String serverAddress = tlServerAddress;
		String sysid = sysId;
		String pwd = passwd;// 密钥密码
		String alias = tlAlias;// 证书名称
		String signMethod = "SHA1WithRSA";
		JSONObject response = new JSONObject();
		try {
			privateKey = RSAUtil.loadPrivateKey(alias, path, pwd);
			publicKey = RSAUtil.loadPublicKey(alias, path, pwd);
			client = new SOAClient();
			client.setServerAddress(serverAddress);
			client.setSignKey(privateKey);
			client.setPublicKey(publicKey);
			client.setSysId(sysid);
			client.setSignMethod(signMethod);
			System.out.println("request:" + param);
			response = client.request(service, method, param);
			System.out.println("response:" + response);
		} catch (Exception e) {
			System.out.println("beforeClass error.");
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public void run(String... arg0) throws Exception {
	/*	beforeClass();*/
	}
}
