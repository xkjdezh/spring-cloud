package com.bichuang.platform.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * 
 * @author meidf
 * @since 2018/03/28
 *
 */

@Component
public class SignUtil {
	/**
	 * 服务器签名
	 * 
	 * @param params
	 * @return
	 */
	public static String createSign(Map<String, String> params, String private_key) {
		// 获取待签名字符串
		String preSignStr = createLinkString(params);
		return RSAUtil.sign(preSignStr, private_key, "UTF-8");
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */

	public static String createLinkString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			// 拼接时，不包括最后一个&字符
			if (i == keys.size() - 1) {
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		return prestr;
	}
}
