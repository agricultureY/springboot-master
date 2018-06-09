package com.ycn.springboot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

import com.ycn.springboot.properties.FooProperties;
import com.ycn.springboot.properties.PostInfo;

@SpringBootApplication
public class ContextApp {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ContextApp.class, args);
		//获取Binder对象
		Binder binder = Binder.get(context.getEnvironment());
		//绑定简单的配置
		FooProperties foo = binder.bind("com.ycn.learn", Bindable.of(FooProperties.class)).get();
		System.out.println(foo.getFoo());
		//绑定list配置
		List<String> post = binder.bind("com.ycn.learn.post", Bindable.listOf(String.class)).get();
		System.out.println(post);
		List<PostInfo> posts = binder.bind("com.ycn.learn.posts", Bindable.listOf(PostInfo.class)).get();
		System.out.println(posts);
		//读取配置
		System.out.println(context.getEnvironment().getProperty("com.ycn.learn.database-platform"));
		System.out.println(context.getEnvironment().getProperty("com.ycn.learn.databasePlatform"));
		
	}
}
