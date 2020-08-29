package com.sswh.model.thread;

import cn.hutool.core.date.DateUtil;

/**
 * @author nuanfeng
 * @date 2020/8/29 16:40
 */
public class OneTask {
    public static void main(String[] args) {
        asyncTask1(2000000000);
    }
    private static void asyncTask1(int num) {
        long current = DateUtil.current(false);
        for (int i=0;i<num;i++) {
            System.out.println("+++" + Thread.currentThread().getName());
        }
        System.out.println("++++++++++++asyncTask1:"+(DateUtil.current(false)-current));
    }
}
