package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.UserSystemInletRef;

public interface UserSystemInletRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSystemInletRef record);

    int insertSelective(UserSystemInletRef record);

    UserSystemInletRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserSystemInletRef record);

    int updateByPrimaryKey(UserSystemInletRef record);
}