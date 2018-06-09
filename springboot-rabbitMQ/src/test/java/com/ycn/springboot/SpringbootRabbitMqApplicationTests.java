package com.ycn.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ycn.springboot.rabbitmq.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootRabbitMqApplication.class})
public class SpringbootRabbitMqApplicationTests {

	@Autowired
	private Sender sender;
	
	@Test
	public void contextLoads() {
		sender.send("张三");
	}

}
