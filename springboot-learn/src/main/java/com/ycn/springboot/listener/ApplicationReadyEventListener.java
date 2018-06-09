package com.ycn.springboot.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;
/**
 * 始化完成，可以准备接收请求
 * 
 * @Package: com.ycn.springboot.listener
 * @author: ycn
 * @date: 2018年5月15日 下午3:27:14
 */
@Slf4j
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.info("<--------------------------------------------->");
		log.warn("......ApplicationReadyEvent......");
		log.info("<--------------------------------------------->");
	}

}
