package com.bjsxt.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.pojo.Account;
import com.bjsxt.service.AccountService;

public class AccountServiceImpl implements AccountService{

	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {

		//获取配置信息
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session=  factory.openSession();
		//先判断转出账号密码是否匹配
		Account aOut = session.selectOne("com.bjsxt.mapper.AccountMapper.selByAccnoPwd",accOut);
		if(aOut!=null) {
			//判断余额是否足够
			if(aOut.getBalance()>=accOut.getBalance()) {
				Account aIn = session.selectOne("com.bjsxt.mapper.AccountMapper.selByAccnoName", accIn);
				if(aIn != null) {
					accIn.setBalance(accOut.getBalance());
					accOut.setBalance(-accOut.getBalance());
					int index = session.update("com.bjsxt.mapper.AccountMapper.updBalanceByAccNo", accOut);
					index+=session.update("com.bjsxt.mapper.AccountMapper.updBalanceByAccNo", accIn);
					if(index==2) {
						session.commit();
						session.close();
						return SUCCESS;
					}else {
						session.rollback();
						session.close();
						return ERROR;
					}
				}else {
					return ACCOUN_NAME_NOT_MATCH;
				}
			}else {
				return ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		}else {
			//账号密码不匹配
			return ACCOUNT_PASSWORD_NOT_MATCH;
		}
		
	}

}
