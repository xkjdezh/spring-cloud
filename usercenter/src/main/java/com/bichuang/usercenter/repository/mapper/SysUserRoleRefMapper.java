package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysUserRoleRef;

public interface SysUserRoleRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRoleRef record);

    int insertSelective(SysUserRoleRef record);

    SysUserRoleRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRoleRef record);

    int updateByPrimaryKey(SysUserRoleRef record);
}