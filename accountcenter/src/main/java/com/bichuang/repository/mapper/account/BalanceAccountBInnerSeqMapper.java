package com.bichuang.repository.mapper.account;

import com.bichuang.repository.model.account.BalanceAccountBInnerSeq;

public interface BalanceAccountBInnerSeqMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BalanceAccountBInnerSeq record);

    int insertSelective(BalanceAccountBInnerSeq record);

    BalanceAccountBInnerSeq selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BalanceAccountBInnerSeq record);

    int updateByPrimaryKey(BalanceAccountBInnerSeq record);
}