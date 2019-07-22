package com.bjsxt.service;

import java.io.IOException;

import com.bjsxt.pojo.Account;

public interface AccountService {

	/**
	 * 账户不匹配
	 */
	int ACCOUNT_PASSWORD_NOT_MATCH=1;
	/**
	 * 余额不足
	 */
	int ACCOUNT_BALANCE_NOT_ENOUGH=2;
	
	int ACCOUN_NAME_NOT_MATCH=3;
	
	int ERROR=4;
	int SUCCESS=5;
	/**
	 * 转账
	 * @param accIn 收款账户
	 * @param accOut 放款账户
	 * @return
	 */
	int transfer(Account accIn,Account accOut) throws IOException;
}
