package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysPopedomMenuRef;

public interface SysPopedomMenuRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPopedomMenuRef record);

    int insertSelective(SysPopedomMenuRef record);

    SysPopedomMenuRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPopedomMenuRef record);

    int updateByPrimaryKey(SysPopedomMenuRef record);
}