package com.ycn.springboot.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

/**
 * 启动过程监听
 * 
 * @Package: com.ycn.springboot.application
 * @author: ycn
 * @date: 2018年5月15日 上午10:50:54
 */
@Slf4j
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {
	
	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		log.info("<--------------------------------------------->");
		log.warn("......ApplicationStartingEvent......");
		log.info("<--------------------------------------------->");
	}

}
