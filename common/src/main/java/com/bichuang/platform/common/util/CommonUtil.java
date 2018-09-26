package com.bichuang.platform.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;

/**
 * 公共工具
 * @author ZhangZeBiao
 * @date 2018年1月22日 下午2:34:14
 *
 */
public class CommonUtil {

	private static Logger log = LoggerFactory.getLogger(CommonUtil.class);
	
	/** 获取UUID字符串 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
	/** 
     * md5加密方法 
     * @param password 
     * @return 
     */  
    public static String md5Password(String password) {  
  
        try {  
            // 得到一个信息摘要器  
            MessageDigest digest = MessageDigest.getInstance("md5");  
            byte[] result = digest.digest(password.getBytes());  
            StringBuffer buffer = new StringBuffer();  
            // 把没一个byte 做一个与运算 0xff;  
            for (byte b : result) {  
                // 与运算  
                int number = b & 0xff;// 加盐  
                String str = Integer.toHexString(number);  
                if (str.length() == 1) {  
                    buffer.append("0");  
                }  
                buffer.append(str);  
            }  
  
            // 标准的md5加密后的结果  
            return buffer.toString();  
        } catch (NoSuchAlgorithmException e) {  
        	log.error(e.getMessage());
            return "";  
        }  
    }  
    /**
     * 转换字符串的格式  11111,22222 --> '11111','22222'
     * @param str
     * @return
     */
    public static String getFormatStr(String str){
  	StringBuffer sb = new StringBuffer();
  	String[] temp = str.split(",");
  	for (int i = 0; i < temp.length; i++) {
  		if (!"".equals(temp[i]) && temp[i] != null)
  				sb.append("'" + temp[i] + "',");
  	}
  	String result = sb.toString();
  	String tp = result.substring(result.length() - 1, result.length());
  	if (",".equals(tp))
  		return result.substring(0, result.length() - 1);
  	else
  		return result;
    }
    
    /**
     * 判断是否为空 
     * @author ZhangZeBiao
     * @createTime 2018年1月29日下午4:01:44
     * @description 
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
		return obj == null || obj.toString().equalsIgnoreCase("null")
				|| obj.toString().length() == 0;
	}
    

    /*
     * 基于jdk8 stream 式快速排序
     * 按照key排序
     */
    public static <K extends Comparable<? super K>, V > Map<K, V> sortByKey(Map<K, V> map ,boolean asc) {
       if(map == null) {
    	   return null;
       }
    	Map<K, V> result = new LinkedHashMap<>();
 
        if(asc) {
        	map.entrySet().stream()
            .sorted(Map.Entry.<K, V>comparingByKey()
                   ).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }else {
        	 map.entrySet().stream()
             .sorted(Map.Entry.<K, V>comparingByKey()
                     .reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }
    /*
		将map 拼接给get请求参数
     */
    public static String mapToGet(Map<String ,Object> map) {
    	if(map ==null) {
    		return null;
    	}
    	MapJoiner joiner = Joiner.on("&").withKeyValueSeparator("=");
		return joiner.join(map);
    	
    }
}
