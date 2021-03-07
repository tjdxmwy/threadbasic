package com.horse.ch01createthread.p2;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/2/26
 */
public class Test {
    public static void main(String[] args) {
        //3)创建 Runnable 接口的实现类对象
        MyRunnable runnable = new MyRunnable();
        //4)创建线程对象
        Thread thread = new Thread(runnable);
        //5)开启线程
        thread.start();

        //当前是 main 线程
        for(int i=0; i <= 1000; i++) {
            System.out.println("main==>" + i);
        }

        //有时调用 Thread(Runnable)构造方法时,实参也会传递匿名内部类对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<=1000; i++) {
                    System.out.println("sub -------> " + i);
                }
            }
        }).start();
    }
}
