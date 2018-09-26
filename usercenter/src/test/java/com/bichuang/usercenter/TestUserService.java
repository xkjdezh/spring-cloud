package com.bichuang.usercenter;


import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.bichuang.platform.common.vo.UserVoB;
import com.bichuang.usercenter.repository.model.SysUserIdentity;
import com.bichuang.usercenter.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UsercenterApplication.class)
@WebAppConfiguration
public class TestUserService {

    @Autowired
    private UserService  userService;

    @Test
    public void testCanLogin(){
         Map<String, Object> canLogin = userService.canLogin("188123456","wre");
       System.out.println(JSON.toJSONString(canLogin));
    }

    @Test
    public void testGetAgentMapt(){
        Map<String,String> angetMap= userService.getAgentMap();
        System.out.println(angetMap.size());
        for (String key:
                angetMap.keySet()) {
            System.out.println(key+"   "+angetMap.get(key));
        }
    }


    @Test
    public void testGetAgentById(){
      String  name=  userService.getAgentById(1);
      Assert.assertEquals(name,"guanggao");
    }

    @Test
    public void testGetById(){
        SysUserIdentity sysUserIdentity=  userService.getById(1);
        System.out.println(sysUserIdentity.getId());
        System.out.println(sysUserIdentity.getLoginName());
    }

    @Test
    public void testLogout(){
    	SysUserIdentity sysUserIdentity=  userService.getById(1);
        System.out.println(sysUserIdentity.getId());
        System.out.println(sysUserIdentity.getLoginName());
    }

    @Test
    public void testSave() {
    	UserVoB userVoB =new UserVoB();
    	//userVoB.
    	userService.saveUserVoB(userVoB);
    }
}
