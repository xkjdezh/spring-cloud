package com.bichuang.usercenter.repository.mapper.ext;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bichuang.platform.common.vo.UserVoB;
import com.bichuang.usercenter.repository.model.SysUserIdentity;

public interface SysUserIdentityExtMapper {


    int insertSelectiveAndGetId(SysUserIdentity record);

    SysUserIdentity selectByMobile(@Param("mobile") String mobile, @Param("password") String password);

	SysUserIdentity queryUserByMobile(@Param("mobile")String mobile);
	
	void deleteUserById(Map<String,Object> map);

	int isExistBySystemInletId(Integer systemInletId);

	void saveSystemInlet(UserVoB userVoB);
}