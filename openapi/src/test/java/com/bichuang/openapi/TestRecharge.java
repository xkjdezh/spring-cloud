package com.bichuang.openapi;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.bichuang.platform.common.util.DateUtil;
import com.bichuang.platform.common.util.UniqId;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.collect.Maps;

public class TestRecharge {

	
	@Test
	public void test01() {
		Map<String,Object> map =Maps.newHashMap();
		map.put("ausername", "username");
		map.put("mobile","mobile");
		map.put("package", 5);
		map.put("orderid",UniqId.getInstance().getUniqID());
		map.put("Atimestamp", DateUtil.date2Str(new Date(), DateUtil.yyyyMMDDHHDDSS));
	
		 Map<String,Object> result = new LinkedHashMap<>();
		 
	        map.entrySet().stream()
	                .sorted(Map.Entry.<String,Object>comparingByKey()
	                        ).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		System.out.println("map:" +result);
	}
	
	@Test
	public void test02() {
		Map<String, Object> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		MapJoiner mapJoiner = Joiner.on("&").withKeyValueSeparator("=");
		System.out.println(mapJoiner.join(map));
	}
}
