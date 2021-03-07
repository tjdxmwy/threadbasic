package com.horse.ch04volatilekw;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 使用原子类进行自增
 * @Author Mr.Horse
 * @Date 2021/3/6
 */
public class Test03 {
    public static void main(String[] args) throws InterruptedException{
        //在 main 线程中创建 10 个子线程
        for(int x=0; x<1000; x++) {
            new SubThread().start();
        }
        Thread.sleep(1000);
        System.out.println(SubThread.count.get());
    }

    static class SubThread extends Thread {
        //使用 AtomicInteger 对象
        private static AtomicInteger count = new AtomicInteger();

        public static synchronized void addCount() {
            for(int i = 0; i < 10000; i++) {
                //自增的后缀形式
                count.getAndIncrement();
            }
            System.out.println(Thread.currentThread().getName() + ": count=" + count.get());
        }

        @Override
        public void run() {
            addCount();
        }
    }
}
