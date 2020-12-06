package com.sswh.study.threadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CreateThread {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "打印-"+Math.random());
            }
        });
        executorService.execute(() ->{
            System.out.println("hello world");
        });
        executorService.execute(()->{
            System.out.println("good morning");
        });
    }

}
