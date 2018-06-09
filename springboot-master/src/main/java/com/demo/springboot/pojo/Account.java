package com.demo.springboot.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 账户数据库实体类
 * @author ycn
 */
@Entity
@Table(name = "t_account")
public class Account {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 100)
	private String userName;
	
	@Column(length = 32)
	private Double balance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
