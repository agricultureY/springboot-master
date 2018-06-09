package com.demo.springboot.service;
/**
 * 账户接口
 * @author ycn
 */
public interface AccountService {

	/**
	 * 转账
	 * @param fromUser  转出账户
	 * @param toUser  转入账户
	 * @param account  转账金额
	 * @throws Exception
	 */
	public void transferAccounts(int fromUser,int toUser,double account) throws Exception;
}
