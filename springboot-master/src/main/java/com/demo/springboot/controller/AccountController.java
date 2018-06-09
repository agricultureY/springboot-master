package com.demo.springboot.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.service.AccountService;

/**
 * account 控制器
 * @author ycn
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	@Resource
	private AccountService accountService;
	
	@RequestMapping("/transferAccounts.do")
	public String transferAccounts() throws Exception {
		accountService.transferAccounts(1, 2, 200);
		return "转账成功";
	}
}
