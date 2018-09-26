package com.bichuang.repository.mapper.account;

import com.bichuang.repository.model.account.BalanceAccountCFreezeSeq;

public interface BalanceAccountCFreezeSeqMapper {
    int deleteByPrimaryKey(String sn);

    int insert(BalanceAccountCFreezeSeq record);

    int insertSelective(BalanceAccountCFreezeSeq record);

    BalanceAccountCFreezeSeq selectByPrimaryKey(String sn);

    int updateByPrimaryKeySelective(BalanceAccountCFreezeSeq record);

    int updateByPrimaryKey(BalanceAccountCFreezeSeq record);
}