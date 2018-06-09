package com.ycn.springboot.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * 
 * @Package: com.ycn.springboot.task
 * @author: ycn
 * @date: 2018年5月23日 下午5:47:02
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 5S调用一次
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
    	/*do some thing...*/
        //System.out.println("当前时间：" + dateFormat.format(new Date()));
    }

}
