package com.ycn.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.ycn.springboot.listener.ApplicationEnvironmentPreparedEventListener;
import com.ycn.springboot.listener.ApplicationFailedEventListener;
import com.ycn.springboot.listener.ApplicationPreparedEventListener;
import com.ycn.springboot.listener.ApplicationReadyEventListener;
import com.ycn.springboot.listener.ApplicationStartedEventListener;
import com.ycn.springboot.listener.ApplicationStartingEventListener;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableScheduling//启动定时任务
//@EnableAsync//开启异步调用
public class APP {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(APP.class);
		app.addListeners(new ApplicationEnvironmentPreparedEventListener(),
				new ApplicationFailedEventListener(),
				new ApplicationPreparedEventListener(),
				new ApplicationReadyEventListener(),
				new ApplicationStartedEventListener(),
				new ApplicationStartingEventListener());
		app.run(args);
	}

	@Bean
	public DataLoader dataLoader() {
		return new DataLoader();
	}
	
	@Slf4j
	static class DataLoader implements CommandLineRunner{
		@Override
		public void run(String... args) throws Exception {
			log.info("<--------------------------------------------->");
			log.warn("Loading data...");
			log.info("<--------------------------------------------->");
		}
	}
}
