package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.UserBExtendAgent;

public interface UserBExtendAgentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBExtendAgent record);

    int insertSelective(UserBExtendAgent record);

    UserBExtendAgent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBExtendAgent record);

    int updateByPrimaryKey(UserBExtendAgent record);
}