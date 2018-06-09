package com.ycn.springboot.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;
/**
 * spring boot 配置环境事件监听
 * 		spring boot 对应Enviroment已经准备完毕，但此时上下文context还没有创建
 * 
 * @Package: com.ycn.springboot.listener
 * @author: ycn
 * @date: 2018年5月15日 上午11:45:50
 */
@Slf4j
public class ApplicationEnvironmentPreparedEventListener
		implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		log.info("<--------------------------------------------->");
		log.warn("......ApplicationEnvironmentPreparedEvent......");
		log.info("<--------------------------------------------->");
	}

}
