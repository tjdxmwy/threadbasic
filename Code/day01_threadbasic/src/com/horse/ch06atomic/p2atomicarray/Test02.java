package com.horse.ch06atomic.p2atomicarray;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Description 在多线程中使用 AtomicIntegerArray 原子数组
 * @Author Mr.Horse
 * @Date 2021/3/7
 */
public class Test02 {
    //定义原子数组
    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);

    public static void main(String[] args) {
        //定义线程数组
        Thread[] threads = new Thread[10];
        //给线程数组元素赋值
        for(int i=0; i < threads.length; i++) {
            threads[i] = new AddThread();
        }
        //开启子线程
        for (Thread thread : threads) {
            thread.start();
        }

        //在主线程中查看自增完以后原子数组中的各个元素的值,在主线程中需要在所有子线程都执行完后再查看
        //把所有的子线程合并到当前主线程中
        for(Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(atomicIntegerArray);

    }

    //定义一个线程类,在线程类中修改原子数组
    static class AddThread extends Thread {
        @Override
        public void run() {
            //把原子数组的每个元素自增 100000 次
            for(int j = 0; j < 100000; j++) {
                for(int i = 0; i < atomicIntegerArray.length(); i++) {
                    atomicIntegerArray.incrementAndGet(i % atomicIntegerArray.length());
                }
            }
        }
    }

}
