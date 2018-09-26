package com.bichuang.openapi;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.bichuang.openapi.config.PhoneRechargeConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OpenApiApplication.class)
@WebAppConfiguration
public class TestOpenApiService {

	@Autowired
	PhoneRechargeConfig phoneRechargeConfig;
	
   

   @Test
   public void test02() {
	   System.out.println(JSON.toJSON(phoneRechargeConfig));
   }
   
   
}
