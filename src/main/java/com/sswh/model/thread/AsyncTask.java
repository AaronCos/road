package com.sswh.model.thread;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nuanfeng
 * @date 2020/8/29 10:23
 */
@Controller
public class AsyncTask {
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    //@PostConstruct
    @RequestMapping("/thread")
    public void testAsycTask() {
        long current = DateUtil.current(false);
        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                asyncTask(current);
            }
        });
        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                asyncTask1(current);
            }
        });
    }

    private void asyncTask(long current) {

        for (int i = 0; i < 1000000000; i++) {
            System.out.println("---" + Thread.currentThread().getName());

        }
        System.out.println("____________asyncTask:"+(DateUtil.current(false)-current));
    }
    private void asyncTask1(long current) {
        for (int i=0;i<1000000000;i++) {
            System.out.println("+++" + Thread.currentThread().getName());
        }
        System.out.println("++++++++++++asyncTask1:"+(DateUtil.current(false)-current));
    }


}
