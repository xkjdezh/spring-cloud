package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysUserGroupRef;

public interface SysUserGroupRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserGroupRef record);

    int insertSelective(SysUserGroupRef record);

    SysUserGroupRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserGroupRef record);

    int updateByPrimaryKey(SysUserGroupRef record);
}