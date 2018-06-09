package com.ycn.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ycn.springboot.domain.User;
import com.ycn.springboot.domain.mapper.UserMapper;
import com.ycn.springboot.properties.TestProperties;
import com.ycn.springboot.service.UserService;
import com.ycn.springboot.task.AsyncTask;
import com.ycn.springboot.task.ThreadPoolAsyncTask;
import com.ycn.springboot.web.HelloController;
import com.ycn.springboot.web.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = {MockServletContext.class, APP.class})
@SpringBootTest(classes = {MockServletContext.class, APP.class})
@WebAppConfiguration
public class APPTest {
	private MockMvc mvc;
	
	@Autowired
	private TestProperties property;
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AsyncTask asyncTask;
	@Autowired
	private ThreadPoolAsyncTask threadPoolAsyncTask;
	@Autowired
	private JavaMailSender mailSender;
	
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController(), new UserController()).build();
	}
	
	@Test
	public void testSendSimpleMail() throws Exception {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("15001141049@163.com");
		message.setTo("1278824040@qq.com");
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");
		mailSender.send(message);
	}
	
	@Test
	public void testThreadTimeout() throws Exception {
		Future<String> futureResult = threadPoolAsyncTask.doTask();
        String result = futureResult.get(5, TimeUnit.SECONDS);
        System.out.println(result);
	}
	
	@Test
	public void testClosedThread() throws Exception {
		for (int i = 0; i < 10000; i++) {
			threadPoolAsyncTask.doTaskOne();
			threadPoolAsyncTask.doTaskTwo();
			threadPoolAsyncTask.doTaskThree();
			if(i == 19)
				System.exit(0);
		}
	}
	
	@Test
	public void ThreadPoolAsyncTask() throws Exception {
		threadPoolAsyncTask.doTaskOne();
		threadPoolAsyncTask.doTaskTwo();
		threadPoolAsyncTask.doTaskThree();
		Thread.currentThread().join();
	}
	
	@Test
	public void testAsyncTask() throws Exception {
		Long start = System.currentTimeMillis();
		Future<String> task1 = asyncTask.doTaskOne();
		Future<String> task2 = asyncTask.doTaskTwo();
		Future<String> task3 = asyncTask.doTaskThree();
		while (true) {
			if(task1.isDone() && task2.isDone() && task3.isDone())
				break;
			Thread.sleep(1000);
		}
		Long end = System.currentTimeMillis();
		System.out.println("任务全部完成耗时："+(end - start)+"ms--------------");
	}

	@Test
	@Rollback
	public void testUserMapper() throws Exception {
		userMapper.addUser("AAA", "男", 22);
		userMapper.addUser("BBB", "女", 23);
		userMapper.addUser("CCC", "男", 24);
		System.out.println("<------------------------------------->");
		System.out.println(userMapper.selectByName("A"));
		userMapper.updateAgeByName("BBB", 21);
		System.out.println("<------------------------------------->");
		System.out.println(userMapper.selectUserList());
		User user = userMapper.selectByName("C");
		user.setName("DDD");
		userMapper.updateUserInfoById(user);
		System.out.println("<------------------------------------->");
		System.out.println(userMapper.selectUserList());
		
	}
	
	@Test
	public void testUserService() throws Exception {
		userService.create("aaa", 11);
		userService.create("bbb", 22);
		userService.create("ccc", 23);
		userService.create("ddd", 24);
		userService.create("eee", 25);
		System.out.println("<------------------------------------->");
		System.out.println(userService.getAllUsers());
		userService.deleteByName("aaa");
		userService.deleteByName("ddd");
		System.out.println("<------------------------------------->");
		System.out.println(userService.getUserList());
		userService.deleteAllUsers();
		System.out.println("<------------------------------------->");
		System.out.println(userService.getUserList());
	}
	
	@Test
	public void testUserController() throws Exception {
		RequestBuilder request = null;
		//查询用户列表
		request = get("/user/getUsers");
		System.out.println("<------------------------------>");
		System.out.println(mvc.perform(request).andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
		//添加用户
		request = post("/user/postUser").param("id", "1001").param("name", "张三").param("sex", "男").param("age", "21");
		System.out.println("<------------------------------>");
		System.out.println(mvc.perform(request).andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
		//查询用户
		request = get("/user/getUser/1001");
		System.out.println("<------------------------------>");
		System.out.println(mvc.perform(request).andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
		//修改用户
		request = put("/user/putUser/1001").param("id", "1001").param("name", "李四").param("sex", "男").param("age", "21");
		System.out.println("<------------------------------>");
		System.out.println(mvc.perform(request).andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
		//查询用户列表
		request = get("/user/getUsers");
		System.out.println("<------------------------------>");
		System.out.println(mvc.perform(request).andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
		//删除用户
		request = delete("/user/deleteUser/1001");
		System.out.println("<------------------------------>");
		System.out.println(mvc.perform(request).andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
		//查询用户列表
		request = get("/user/getUsers");
		System.out.println("<------------------------------>");
		System.out.println(mvc.perform(request).andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
	}
	
	@Test
	public void testProperties() throws Exception  {
		System.out.println("====================================================");
		System.out.println(property.getName());
		System.out.println(property.getTitle());
		System.out.println(property.getDesc());
		System.out.println(property.getValue());
		System.out.println(property.getNumber());
		System.out.println(property.getBignumber());
		System.out.println(property.getTest1());
		System.out.println(property.getTest2());
		System.out.println(property.getPort());
	}

	@Test
	public void getHello() throws Exception {
		ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("helloword")));
		String str = result.andReturn().getResponse().getContentAsString();
		System.out.println(str);
	}
}
