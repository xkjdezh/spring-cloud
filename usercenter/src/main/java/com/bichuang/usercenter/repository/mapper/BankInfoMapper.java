package com.bichuang.usercenter.repository.mapper;

import com.bichuang.usercenter.repository.model.BankInfo;

public interface BankInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BankInfoMapper record);

    int insertSelective(BankInfo record);

    BankInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BankInfo record);

    int updateByPrimaryKey(BankInfo record);
}