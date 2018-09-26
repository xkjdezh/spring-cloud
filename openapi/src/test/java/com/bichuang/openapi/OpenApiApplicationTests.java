package com.bichuang.openapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.bichuang.openapi.repository.mapper.OpenPhoneRechargeMapper;
import com.bichuang.openapi.repository.model.OpenPhoneRecharge;
import com.bichuang.openapi.repository.model.OpenPhoneRechargeExample;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenApiApplicationTests {

	@Autowired
	public OpenPhoneRechargeMapper openPhoneRechargeMapper;
	
	@Test
	public void contextLoads() {
		Object parse = JSONObject.parse("{'ab':'1','list':[{'b':'1','c':'2'},{'b':'1','c':'2'}]}");
		System.out.println(parse.toString());
	}

	@Test
	public void test01() {
		OpenPhoneRecharge vo = new OpenPhoneRecharge();
		vo.setUserId(11L);
		vo.setBizType((short) 1);
		vo.setMobilePhone("1301301301");
		vo.setOrderId("110110110110");
		vo.setStatus(0);
		int insert = openPhoneRechargeMapper.insert(vo);
		System.out.println("insert:" +insert);
	}
	

	@Test
	public void test02() {
		OpenPhoneRechargeExample ex=new  OpenPhoneRechargeExample();
		ex.createCriteria().andOrderIdEqualTo("110110110110").andUserIdEqualTo(11L).andBizTypeEqualTo((short)1);
		OpenPhoneRecharge vo = new OpenPhoneRecharge();
		vo.setStatus(3);
		int update = openPhoneRechargeMapper.updateByExampleSelective(vo, ex);
		System.out.println("update:" +update);
	}
}
