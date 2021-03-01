package com.horse.createthread.p2;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/2/26
 */

/**
 * 当线程类已经有父类了,就不能用继承 Thread 类的形式创建线程,可以使用实现 Runnable 接口的形式
 *  1)定义类实现 Runnable 接口
 */
public class MyRunnable implements Runnable{
    //2)重写 Runnable 接口中的抽象方法 run(), run()方法就是子线程要执行的代码
    @Override
    public void run() {
        for(int i=0; i<=1000; i++) {
            System.out.println("sub thread->" + i);
        }
    }
}
