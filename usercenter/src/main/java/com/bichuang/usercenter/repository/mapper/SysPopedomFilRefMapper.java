package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysPopedomFilRef;

public interface SysPopedomFilRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPopedomFilRef record);

    int insertSelective(SysPopedomFilRef record);

    SysPopedomFilRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPopedomFilRef record);

    int updateByPrimaryKey(SysPopedomFilRef record);
}