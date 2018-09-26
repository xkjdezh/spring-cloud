package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysPageElement;

public interface SysPageElementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPageElement record);

    int insertSelective(SysPageElement record);

    SysPageElement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPageElement record);

    int updateByPrimaryKey(SysPageElement record);
}