package com.ycn.springboot.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * user实体
 * 
 * @Package: com.ycn.springboot.domain
 * @author: ycn
 * @date: 2018年5月15日 下午4:55:13
 */
public class User implements RowMapper<User>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8607592655598156851L;

	private Long id;
	
	private String name;

	private String sex;

	private Integer age;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}

	public User() { }
	
	public User(Long id, String name, String sex, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(rs.getLong("id"), rs.getString("name"), rs.getString("sex"), rs.getInt("age"));
	}
}
