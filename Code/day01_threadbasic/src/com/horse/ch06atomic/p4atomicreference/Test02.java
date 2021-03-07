package com.horse.ch06atomic.p4atomicreference;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description 演示AtomicReference可能会出现CAS的ABA问题
 * @Author Mr.Horse
 * @Date 2021/3/7
 */
public class Test02 {
    private static AtomicReference<String> atomicReference = new AtomicReference<>("abc");

    public static void main(String[] args) throws InterruptedException {
        //创建第一个线程,先把 abc 字符串改为"def",再把字符串还原为 abc
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicReference.compareAndSet("abc", "def");
                System.out.println(Thread.currentThread().getName() + "-->" +atomicReference.get());
                atomicReference.compareAndSet("def", "abc");
                System.out.println(Thread.currentThread().getName() + "-->" +atomicReference.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(atomicReference.compareAndSet("abc", "ghg"));
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(atomicReference.get());
    }
}
