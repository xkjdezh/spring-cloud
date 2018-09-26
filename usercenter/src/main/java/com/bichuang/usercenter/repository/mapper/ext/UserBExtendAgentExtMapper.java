package com.bichuang.usercenter.repository.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bichuang.usercenter.repository.model.UserBExtendAgent;

public interface UserBExtendAgentExtMapper {

	/**
	 * 获取所有的
	 * @author ZhangZeBiao
	 * @createTime 2018年3月6日下午5:26:55
	 * @description 
	 * @param id
	 * @return
	 */
    List<UserBExtendAgent> getAllAgent();

    /**
     * 获取没绑定的代理商
     * @author ZhangZeBiao
     * @param userId 
     * @createTime 2018年3月6日下午5:28:43
     * @description 
     * @return
     */
    List<UserBExtendAgent> getAgentListByNotBinding(@Param("userId") String userId);
    
}