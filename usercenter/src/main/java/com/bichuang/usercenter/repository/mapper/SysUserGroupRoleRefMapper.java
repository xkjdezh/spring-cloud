package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysUserGroupRoleRef;

public interface SysUserGroupRoleRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserGroupRoleRef record);

    int insertSelective(SysUserGroupRoleRef record);

    SysUserGroupRoleRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserGroupRoleRef record);

    int updateByPrimaryKey(SysUserGroupRoleRef record);
}