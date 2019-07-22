package com.bjsxt.mapper;

import com.bjsxt.pojo.Account;

public interface AccountMapper {

	Account selByAccnoPwd(Account account);
	
	Account selByAccnoName(Account account);
	
	Integer updBalanceByAccNo(Account account);
}
