package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.UserPopulousProC;

public interface UserPopulousProCMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserPopulousProC record);

    int insertSelective(UserPopulousProC record);

    UserPopulousProC selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserPopulousProC record);

    int updateByPrimaryKey(UserPopulousProC record);
}