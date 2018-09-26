package com.bichuang.repository.mapper.account;

import com.bichuang.repository.model.account.BalanceAccountC;

public interface BalanceAccountCMapper extends BaseMapper<BalanceAccountC, Integer> {

	public BalanceAccountC selectAll(BalanceAccountC balanceAccountC);
 
	public int updateByCusId(BalanceAccountC balanceAccountC);

}