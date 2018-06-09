package com.ycn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Message Broker与AMQP简介
 * 	Message Broker是一种消息验证、传输、路由的架构模式，其设计目标主要应用于下面这些场景：
 * 		消息路由到一个或多个目的地
 * 		消息转化为其他的表现方式
 * 		执行消息的聚集、消息的分解，并将结果发送到他们的目的地，然后重新组合相应返回给消息用户
 * 		调用Web服务来检索数据
 * 		响应事件或错误
 * 		使用发布-订阅模式来提供内容或基于主题的消息路由
 * 	AMQP是Advanced Message Queuing Protocol的简称，它是一个面向消息中间件的开放式标准应用层协议。AMQP定义了这些特性：
 * 		消息方向
 * 		消息队列
 * 		消息路由（包括：点到点和发布-订阅模式）
 * 		可靠性
 * 		安全性
 * 
 * RabbitMQ就是以AMQP协议实现的一种中间件产品，它可以支持多种操作系统，多种编程语言，几乎可以覆盖所有主流的企业级技术平台
 * 	http://localhost:15672/		username:guest		pwd:guest
 * 
 * @Package: com.ycn.springboot
 * @author: ycn
 * @date: 2018年6月6日 下午2:15:20
 */
@SpringBootApplication
public class SpringbootRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitMqApplication.class, args);
	}
}
