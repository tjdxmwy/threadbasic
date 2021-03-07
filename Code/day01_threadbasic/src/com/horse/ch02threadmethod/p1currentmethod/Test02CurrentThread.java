package com.horse.ch02threadmethod.p1currentmethod;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/2/26
 */
public class Test02CurrentThread {
    public static void main(String[] args) throws InterruptedException {
        SubThread2 t = new SubThread2();
        t.setName("t1");    //设置当前线程名称
        t.start();

        Thread.sleep(1000);

        //Thread(Runnable)构造方法形参是 Runnable 接口,调用时传递的实参是接口的实现类对象
        Thread t2 = new Thread(t);
        t2.start();

        /**
         * 构造方法中,Thread.currentThread().getname(): main
         * 构造方法,this.getName():Thread-0
         * run方法中,Thread.currentThread().getname(): t1
         * run方法,this.getName():t1
         * run方法中,Thread.currentThread().getname(): Thread-1
         * run方法,this.getName():t1
         */


    }
}
