package com.horse.createthread.p1;

/**
 * @Description 1)定义类继承 Thread
 * @Author Mr.Horse
 * @Date 2021/2/26
 */
public class MyThread extends Thread{
    //2) 重写 Thread 父类中的 run()
    // run()方法体中的代码就是子线程要执行的任务
    @Override
    public void run() {
        System.out.println("这是子线程需要打印的内容");
    }
}
