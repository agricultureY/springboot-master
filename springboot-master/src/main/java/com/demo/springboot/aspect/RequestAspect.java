package com.demo.springboot.aspect;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 切面AOP，日志管理
 * @author ycn
 */
@Aspect
@Component
public class RequestAspect {

	private Logger logger = Logger.getLogger(RequestAspect.class);
	
	//定义扫描controller包
	@Pointcut("execution(public * com.demo.springboot.controller.*.*(..))")
    public void log(){
    }
     
    @Before("log()")
    public void deoBefore(JoinPoint joinPoint){
        logger.info("方法执行前...");
        ServletRequestAttributes sra=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=sra.getRequest();
        logger.info("url:"+request.getRequestURI());
        logger.info("ip:"+request.getRemoteHost());
        logger.info("method:"+request.getMethod());
        logger.info("class_method:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("args:"+joinPoint.getArgs());
    }
     
    @After("log()")
    public void doAfter(JoinPoint joinPoint){
        logger.info("方法执行后...");
    }
     
    @AfterReturning(returning="result",pointcut="log()")
    public void doAfterReturning(Object result){
        logger.info("执行返回值："+result);
    }
}
