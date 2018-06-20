package com.ycn.springboot.database.mybatis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 只读注解
 * 	该注解注释在service方法上，标注为连接从数据库
 * 
 * @Package: com.ycn.springboot.database.mybatis
 * @author: ycn
 * @date: 2018年6月17日 上午11:06:05
 */
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadOnlyConnection {

}
