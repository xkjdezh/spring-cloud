package com.bichuang.usercenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsercenterApplicationTests {

	@Test
	public void contextLoads() {
		Object parse = JSONObject.parse("{'ab':'1','list':[{'b':'1','c':'2'},{'b':'1','c':'2'}]}");
		System.out.println(parse.toString());
	}

}
