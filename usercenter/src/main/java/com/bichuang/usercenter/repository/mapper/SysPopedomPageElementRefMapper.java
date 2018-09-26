package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysPopedomPageElementRef;

public interface SysPopedomPageElementRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPopedomPageElementRef record);

    int insertSelective(SysPopedomPageElementRef record);

    SysPopedomPageElementRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPopedomPageElementRef record);

    int updateByPrimaryKey(SysPopedomPageElementRef record);
}