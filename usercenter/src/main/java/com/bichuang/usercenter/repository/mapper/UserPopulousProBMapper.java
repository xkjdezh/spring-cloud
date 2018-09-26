package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.UserPopulousProB;

public interface UserPopulousProBMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserPopulousProB record);

    int insertSelective(UserPopulousProB record);

    UserPopulousProB selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserPopulousProB record);

    int updateByPrimaryKey(UserPopulousProB record);
}