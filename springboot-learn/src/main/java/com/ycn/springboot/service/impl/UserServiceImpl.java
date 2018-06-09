package com.ycn.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ycn.springboot.domain.User;
import com.ycn.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public void create(String name, Integer age) {
		jdbc.update("insert into user (name,age) values (?, ?)", name, age);
	}

	@Override
	public void deleteByName(String name) {
		jdbc.update("delete from user where name = ?", name);
	}

	@Override
	public Integer getAllUsers() {
		return jdbc.queryForObject("select count(1) from user", Integer.class);
	}

	@Override
	public void deleteAllUsers() {
		jdbc.update("delete from user");
	}

	@Override
	public List<User> getUserList() {
		return jdbc.query("select * from user", new User());
	}

}
