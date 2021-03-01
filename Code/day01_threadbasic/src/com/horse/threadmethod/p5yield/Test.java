package com.horse.threadmethod.p5yield;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/3/1
 */
public class Test {
    public static void main(String[] args) {
        //开启子线程,计算累加和
        SubThread thread = new SubThread();
        thread.start();

        //在 main 线程中计算累加和
        long begin = System.currentTimeMillis();
        long sum = 0;
        for(int i = 0; i < 10000000; i++) {
            sum += i;
            Thread.yield();     //线程让步,放弃CPU执行权
        }

        long end = System.currentTimeMillis();
        System.out.println("main线程用时:" + (end - begin));
    }
}
