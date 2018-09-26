package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysRolePopedomRef;

public interface SysRolePopedomRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRolePopedomRef record);

    int insertSelective(SysRolePopedomRef record);

    SysRolePopedomRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRolePopedomRef record);

    int updateByPrimaryKey(SysRolePopedomRef record);
}