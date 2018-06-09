package com.ycn.springboot.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;
/**
 * 项目启动完成的监听
 * 
 * @Package: com.ycn.springboot.application
 * @author: ycn
 * @date: 2018年5月15日 上午10:53:24
 */
@Slf4j
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		log.info("<--------------------------------------------->");
		log.warn("......ApplicationStartedEvent......");
		log.info("<--------------------------------------------->");
	}


}
