package com.bichuang.repository.mapper.account;

import com.bichuang.repository.model.account.BalanceAccountOptLog;

public interface BalanceAccountOptLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BalanceAccountOptLog record);

    int insertSelective(BalanceAccountOptLog record);

    BalanceAccountOptLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BalanceAccountOptLog record);

    int updateByPrimaryKey(BalanceAccountOptLog record);
}