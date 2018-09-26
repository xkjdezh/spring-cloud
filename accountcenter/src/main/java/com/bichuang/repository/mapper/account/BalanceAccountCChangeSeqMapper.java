package com.bichuang.repository.mapper.account;

import java.util.List;

import com.bichuang.repository.model.account.BalanceAccountCChangeSeq;


public interface BalanceAccountCChangeSeqMapper extends BaseMapper<BalanceAccountCChangeSeq, Integer> {

	List<BalanceAccountCChangeSeq> selectBalanceSeq(BalanceAccountCChangeSeq balanceAccountCChangeSeq);
	
	public int updateOrderStatus(BalanceAccountCChangeSeq balanceAccountCChangeSeq);

	public BalanceAccountCChangeSeq selectAll(BalanceAccountCChangeSeq balanceAccountCChangeSeq);
}