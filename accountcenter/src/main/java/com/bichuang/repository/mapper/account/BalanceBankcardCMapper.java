package com.bichuang.repository.mapper.account;

import java.util.List;

import com.bichuang.repository.model.account.BalanceBankcardC;


public interface BalanceBankcardCMapper extends BaseMapper<BalanceBankcardC, Integer> {
	List<BalanceBankcardC> selectAll(BalanceBankcardC balanceBankcardC);
}