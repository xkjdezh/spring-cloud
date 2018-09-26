package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.SysPopedom;

public interface SysPopedomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPopedom record);

    int insertSelective(SysPopedom record);

    SysPopedom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPopedom record);

    int updateByPrimaryKey(SysPopedom record);
}