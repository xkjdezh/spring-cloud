package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysUserIdentity;

public interface SysUserIdentityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserIdentity record);

    int insertSelective(SysUserIdentity record);

    SysUserIdentity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserIdentity record);

    int updateByPrimaryKey(SysUserIdentity record);
}