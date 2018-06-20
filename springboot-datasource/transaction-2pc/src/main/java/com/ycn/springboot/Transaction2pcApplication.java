package com.ycn.springboot;

import com.ycn.springboot.config.properties.DBProperties;
import com.ycn.springboot.config.properties.DBProperties1;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * 多数据配置需设置主数据源
 */
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.ycn.springboot")
@MapperScan(basePackages = "com.ycn.springboot.mapper")
@EnableConfigurationProperties(value = {DBProperties.class, DBProperties1.class})
@SpringBootApplication
public class Transaction2pcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Transaction2pcApplication.class, args);
    }
}
