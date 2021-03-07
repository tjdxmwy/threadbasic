package com.horse.ch02threadmethod.p1currentmethod;

/**
 * @Description 当前线程的复杂案例
 * @Author Mr.Horse
 * @Date 2021/2/26
 */
public class SubThread2 extends Thread {
    public SubThread2() {
        System.out.println("构造方法中,Thread.currentThread().getname(): " + Thread.currentThread().getName());
        System.out.println("构造方法,this.getName():" + this.getName());
    }

    @Override
    public void run() {
        System.out.println("run方法中,Thread.currentThread().getname(): " + Thread.currentThread().getName());
        System.out.println("run方法,this.getName():" + this.getName());
    }
}
