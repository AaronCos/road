package com.sswh.config;

import com.sswh.model.thread.AsyncTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author nuanfeng
 * @date 2020/8/29 9:51
 */

@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy){
        ThreadPoolTaskExecutor tpe = new ThreadPoolTaskExecutor();
        tpe.setCorePoolSize(10);
        tpe.setMaxPoolSize(100);
        //任务队列2000
        tpe.setQueueCapacity(2000);
        tpe.setKeepAliveSeconds(60);
        tpe.setAllowCoreThreadTimeOut(true);
        tpe.setRejectedExecutionHandler(discardOldestPolicy);
        return tpe;
    }

    @Bean
    public ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy(){
        return new ThreadPoolExecutor.DiscardOldestPolicy();
    }

    /**
     * 测试线程类
     * @return
     */
    @Bean
    public AsyncTask asyncTask(){
        return new AsyncTask();
    }





}
