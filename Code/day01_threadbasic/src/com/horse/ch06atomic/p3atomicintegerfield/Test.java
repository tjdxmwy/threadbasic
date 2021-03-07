package com.horse.ch06atomic.p3atomicintegerfield;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/3/7
 */
public class Test {
    public static void main(String[] args) {
        User user = new User(1024, 10);

        //开启10个线程
        for(int i=0; i<10; i++) {
            new SubThread(user).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(user);
    }
}
