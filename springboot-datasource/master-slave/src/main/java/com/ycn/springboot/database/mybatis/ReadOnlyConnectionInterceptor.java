package com.ycn.springboot.database.mybatis;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 只读连接拦截器
 * 
 * @Package: com.ycn.springboot.database.mybatis
 * @author: ycn
 * @date: 2018年6月17日 上午11:14:45
 */
@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered {

	public static final Logger logger = LoggerFactory.getLogger(ReadOnlyConnectionInterceptor.class);

    @Around("@annotation(readOnlyConnection)")
	public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {
		try {
			logger.info("set database connection to read only");
			DbContextHolder.setDbType(DbContextHolder.DbType.SLAVE);
			/**环绕通知-->让目标方法执行 环绕通知=前置+目标方法执行+后置通知，proceed方法就是用于启动目标方法执行的 */
			Object result = proceedingJoinPoint.proceed();
			return result;
		} finally {
			DbContextHolder.clearDbType();
			logger.info("restore database connection");
		}
	}

	@Override
	public int getOrder() {
		return 0;
	}

}
