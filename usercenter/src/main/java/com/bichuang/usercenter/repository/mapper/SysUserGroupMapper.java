package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysUserGroup;

public interface SysUserGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserGroup record);

    int insertSelective(SysUserGroup record);

    SysUserGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserGroup record);

    int updateByPrimaryKey(SysUserGroup record);
}