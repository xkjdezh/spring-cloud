package com.bichuang.repository.mapper.account;

import com.bichuang.repository.model.account.BalanceAccountBInner;

public interface BalanceAccountBInnerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BalanceAccountBInner record);

    int insertSelective(BalanceAccountBInner record);

    BalanceAccountBInner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BalanceAccountBInner record);

    int updateByPrimaryKey(BalanceAccountBInner record);
}