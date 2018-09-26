package com.bichuang.repository.mapper.account.ext;

import com.bichuang.repository.model.account.BalanceAccountC;

public interface BalanceAccountCExtMapper {
	/**
	 * 根据账户id,用户id查找账户数据
	 * @param balanceAccountC
	 * @return
	 */
	BalanceAccountC getBalanceAccountC(BalanceAccountC balanceAccountC);
	
}
