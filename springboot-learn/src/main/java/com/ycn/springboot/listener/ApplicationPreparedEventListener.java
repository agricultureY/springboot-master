package com.ycn.springboot.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;
/**
 * 上下文创建完成后执行的事件监听器
 * 		上下文context创建完成，但此时spring中的bean是没有完全加载完成的
 * 
 * @Package: com.ycn.springboot.listener
 * @author: ycn
 * @date: 2018年5月15日 上午11:50:06
 */
@Slf4j
public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		log.info("<--------------------------------------------->");
		log.warn("......ApplicationPreparedEvent......");
		log.info("<--------------------------------------------->");
	}

}
