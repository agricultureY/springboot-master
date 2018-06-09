package com.ycn.springboot.rabbitmq;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置队列、交换器、路由等高级信息
 * 
 * @Package: com.ycn.springboot.rabbitmq
 * @author: ycn
 * @date: 2018年6月7日 上午10:13:35
 */
@Configuration
public class RabbitmqConfig {

	@Bean
	public Queue helloQueue() {
		return new Queue("hello");
	}
}
