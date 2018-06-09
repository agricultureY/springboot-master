package com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.properties.MysqlProperties;

/**
 * HelloWord控制器
 * @author ycn
 */
@RestController
@RequestMapping("/helloword")
public class HelloWordController {
	
	@Value("${mysql.jdbcName}")
	private String jdbcName;
	
	@Value("${mysql.dbUrl}")
	private String dbUrl;
	
	@Value("${mysql.userName}")
	private String userName;
	
	@Value("${mysql.password}")
	private String password;
	
	@Autowired
	private MysqlProperties mysqlProperties;

	@RequestMapping("/hello.do")
	public String say() {
		return "helloword springboot";
	}
	
	@RequestMapping("/jdbcInfo.do")
	public String jdbcInfo() {
		return "mysql.jdbcName: "+jdbcName+
				"<br/>mysql.dbUrl: "+dbUrl+
				"<br/>mysql.userName: "+userName+
				"<br/>mysql.password: "+password;
	}
	
	@RequestMapping("/getJdbcInfoByProperties.do")
	public String getJdbcInfoByProperties() {
		return "getJdbcInfoByProperties--><br/>"+
				"mysql.jdbcName: "+mysqlProperties.getJdbcName()+
				"<br/>mysql.dbUrl: "+mysqlProperties.getDbUrl()+
				"<br/>mysql.userName: "+mysqlProperties.getUserName()+
				"<br/>mysql.password: "+mysqlProperties.getPassword();
	}
}
