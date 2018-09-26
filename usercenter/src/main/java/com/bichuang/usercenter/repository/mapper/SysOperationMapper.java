package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysOperation;

public interface SysOperationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOperation record);

    int insertSelective(SysOperation record);

    SysOperation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOperation record);

    int updateByPrimaryKey(SysOperation record);
}