package com.demo.springboot.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.demo.springboot.dao.AccountDAO;
import com.demo.springboot.pojo.Account;
import com.demo.springboot.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDAO accountDao;
	
	/**
	 * 转账
	 */
	@Transactional
	@Override
	public void transferAccounts(int fromUser, int toUser, double account) throws Exception {
		Account fromAccount = accountDao.findOne(fromUser);
		if(fromAccount.getBalance() < account)
			throw new Exception("账户余额不足!");
		fromAccount.setBalance(fromAccount.getBalance() - account);
		accountDao.save(fromAccount);
		//自定义异常
		//System.out.println(1/0);
		
		Account toAccount = accountDao.findOne(toUser);
		toAccount.setBalance(toAccount.getBalance() + account);
		accountDao.save(toAccount);
	}

}
