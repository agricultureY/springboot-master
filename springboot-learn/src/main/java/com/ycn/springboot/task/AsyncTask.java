package com.ycn.springboot.task;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * 异步调用任务
 * 
 * @Package: com.ycn.springboot.task
 * @author: ycn
 * @date: 2018年5月23日 下午5:54:38
 */
@Component
public class AsyncTask {

	public static Random random = new Random();
	
	@Async
	public Future<String> doTaskOne() throws Exception {
		System.out.println("开始任务一1111111111111");
		Long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		Long end = System.currentTimeMillis();
		System.out.println("完成任务一耗时："+(end - start)+"ms");
		return new AsyncResult<String>("任务一完成.............");
	}
	
	@Async
	public Future<String> doTaskTwo() throws Exception {
		System.out.println("开始任务二22222222222222");
		Long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		Long end = System.currentTimeMillis();
		System.out.println("完成任务二耗时："+(end - start)+"ms");
		return new AsyncResult<String>("任务二完成.............");
	}
	
	@Async
	public Future<String> doTaskThree() throws Exception {
		System.out.println("开始任务三333333333333333");
		Long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		Long end = System.currentTimeMillis();
		System.out.println("完成任务三耗时："+(end - start)+"ms");
		return new AsyncResult<String>("任务三完成.............");
	}
}
