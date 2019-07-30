package com.sswh.model.javase;

/**
 * Created by wangchengcheng on 2019/7/30
 */
public class MyThread {
    public static void main(String[] args) {
        new MyThread();
    }

    public MyThread() {
        ChildThread childThread = new ChildThread();
        childThread.start();
        RunThread s1 = new RunThread();
        new Thread(s1,"helloRunnable").start();
    }

    class  ChildThread extends Thread {
        public ChildThread() {

        }

        public void run() {
            System.out.println(Thread.currentThread().getName()+":hello");
        }

    }
    class RunThread implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+":goodboy");
        }
    }
}
