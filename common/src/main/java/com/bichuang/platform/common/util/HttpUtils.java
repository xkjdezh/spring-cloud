package com.bichuang.platform.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * 发送http请求
 * @author ChenWangWu
 * @createTime 2017年11月23日上午9:22:52
 */
public class HttpUtils   {
	
	private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
	
	public static String httpGet(String httpUrl) {
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		try {
			log.info("httpGet请求开始:httpUrl="+httpUrl);
			URL url = new URL(httpUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestProperty("content-type", "text/xml");
			httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.connect();
			in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
			while (true) {
				String line = in.readLine();
				if (line == null) {
					break;
				} else {
					result.append(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("httpGet请求出现异常 url: " + httpUrl + " fail. error info:" + e.getMessage(), e);
		} finally {
			if(null!=in){//关闭流
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
					log.error("httpGet请求关闭出现异常 url: " + httpUrl + " fail. error info:" + e.getMessage(), e);
				}
			}
		}
		log.info("httpGet请求结束:httpUrl="+httpUrl);
		return result.toString();
	}

	public static String httpPost(String httpUrl, String httpJson) {
		StringBuffer result = new StringBuffer();
		BufferedWriter out=null;
		BufferedReader in=null;
		try {
			log.info("httpsPost请求开始:httpUrl="+httpUrl+";params:"+httpJson);
			URL url = new URL(httpUrl);

			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestProperty("content-type", "text/xml");
			httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
			httpURLConnection.setRequestProperty("contentType", "UTF-8");
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.connect();
			out = new BufferedWriter(
					new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));

			out.write(JSONObject.parse(httpJson).toString());
			out.flush();
			in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
			while (true) {
				String line = in.readLine();
				if (line == null) {
					break;
				} else {
					result.append(line);
				}
			}
			System.out.println(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=out){//关闭输出流
					out.close();
				}
				if(null!=in){//关闭输入流
					in.close();
				}
			} catch (IOException e) {
				log.error("httpsPost请求关闭出现异常 url: " + httpUrl + " fail. error info:" + e.getMessage(), e);
			}
		}
		log.info("httpsPost请求结束:httpUrl="+httpUrl+",httpJson="+httpJson);
		return result.toString();
	}
	
	
}