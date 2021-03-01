package com.horse.threadmethod.p1currentmethod;

/**
 * @Description 测试当前线程
 * @Author Mr.Horse
 * @Date 2021/2/26
 */
public class Test01CurrentThread {
    public static void main(String[] args) {
        System.out.println("main方法中打印当前线程: " + Thread.currentThread().getName());
        //创建子线程, 调用SubThread1()构造方法, 在main线程中调用构造方法,所以构造方法中的当前线程就是main线程
        Thread subThread = new Thread(new SubThread1());
//        subThread.start();  //启动子线程,子线程会调用run()方法,所以run()方法中的当前线程就是Thread-0子线程
        subThread.run();    //在 main方法中直接调用run()方法,没有开启新的线程,所以在run方法中的当前线程就是main线程

    }
}
