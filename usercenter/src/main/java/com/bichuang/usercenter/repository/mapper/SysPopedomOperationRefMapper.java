package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysPopedomOperationRef;

public interface SysPopedomOperationRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPopedomOperationRef record);

    int insertSelective(SysPopedomOperationRef record);

    SysPopedomOperationRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPopedomOperationRef record);

    int updateByPrimaryKey(SysPopedomOperationRef record);
}