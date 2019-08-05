package com.sswh.model.mutithread;

/**
 * Created by wangchengcheng on 2019/8/5
 */
public class MultiThreadMother {

    public static void main(String[] args) {
        new MultiThreadMother();
    }

    public MultiThreadMother() {
        SonThread s1 = new SonThread();
        Thread t1 = new Thread(s1, "线程一");
        ChildThread childThread = new ChildThread();
        Thread t2 = new Thread(childThread, "线程二");
        t1.start();
        t2.start();


    }


    class SonThread implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 100; i++) {
                System.out.println("我是："+ Thread.currentThread().getName()+":i="+i);
                try {
                    Thread.sleep(100);
                    System.out.println("休息结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ChildThread implements Runnable {

        @Override
        public void run() {
            for (int j = 0; j < 100; j++) {
                System.out.println("我是："+ Thread.currentThread().getName()+":j="+j);
            }
        }
    }
}
