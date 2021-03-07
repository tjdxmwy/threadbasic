package com.horse.ch02threadmethod.p1currentmethod;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/2/26
 */

/**
 * 定义线程类
 *      分别在构造方法中和run方法中打印当前线程
 */
public class SubThread1 implements Runnable{

    public SubThread1() {
        System.out.println("构造方法打印当前线程的名称:" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法打印当前线程名称:" + Thread.currentThread().getName());
    }
}
