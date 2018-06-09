package com.ycn.springboot.rabbitmq;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 消息发送
 * 
 * @Package: com.ycn.springboot.rabbitmq
 * @author: ycn
 * @date: 2018年6月7日 上午8:35:22
 */
@Component
public class Sender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(String msg) {
		String context = "hello "+msg+"  date:"+new Date();
		System.out.println("Sender : " + context);
		this.amqpTemplate.convertAndSend("hello", context);
	}
	
	public static void main(String[] args) throws IOException, TimeoutException {
		//创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        //设置 RabbitMQ 地址
        factory.setHost("localhost");
        //建立到代理服务器到连接
        Connection conn = factory.newConnection();
        //获得信道
        Channel channel = conn.createChannel();
        //声明交换器
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);

        String routingKey = "hola";
        //发布消息
        byte[] messageBodyBytes = "quit".getBytes();
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

        channel.close();
        conn.close();
	}
}
