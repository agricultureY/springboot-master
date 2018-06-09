package com.ycn.springboot.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;
/**
 * 启动异常时执行事件
 * 
 * @Package: com.ycn.springboot.listener
 * @author: ycn
 * @date: 2018年5月15日 上午11:46:36
 */
@Slf4j
public class ApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

	@Override
	public void onApplicationEvent(ApplicationFailedEvent event) {
		log.info("<--------------------------------------------->");
		log.warn("......ApplicationFailedEvent......");
		log.info("<--------------------------------------------->");
	}

}
