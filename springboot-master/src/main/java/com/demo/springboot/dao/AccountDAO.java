package com.demo.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.pojo.Account;

/**
 * account  数据库接口
 * @author ycn
 */
public interface AccountDAO extends JpaRepository<Account, Integer> {

}
