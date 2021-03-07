package com.horse.ch06atomic.p4atomicreference;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description 使用AtomicReference原子读写一个对象
 * @Author Mr.Horse
 * @Date 2021/3/7
 */
public class Test01 {
    static AtomicReference<String> atomicReference = new AtomicReference<>("abc");

    public static void main(String[] args) throws InterruptedException {
        //创建100个线程修改字符串
        for(int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(20));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(atomicReference.compareAndSet("abc", "def")) {
                        System.out.println(Thread.currentThread().getName() + "把字符串abc更改为def");
                    }
                }
            }).start();
        }

        //再创建 100 个线程
        for(int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(20));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(atomicReference.compareAndSet("def", "abc")) {
                        System.out.println(Thread.currentThread().getName() + "把字符串还原成abc");
                    }
                }
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(atomicReference.get());
    }
}
