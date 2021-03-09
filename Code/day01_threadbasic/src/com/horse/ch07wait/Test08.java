package com.horse.ch07wait;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/3/9
 */
public class Test08 {
    public static void main(String[] args) {
        final Object obj = new Object();    //定义对象作为锁对象

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        System.out.println("begin wait");
                        obj.wait();
                        System.out.println("end wait");
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("begin notify");
                    obj.notify();
                    System.out.println("end notify");
                }
            }
        });

        //如果先开启 t1,再开启 t2 线程,大多数情况下, t1 先等待,t1 再把 t1 唤醒
//        t1.start();
//        t2.start();

        //如果先开启 t2 通知线程,再开启 t1 等待线程,可能会出现 t1 线程等待没有收到通知的情况
        t2.start();
        t1.start();
    }
}
