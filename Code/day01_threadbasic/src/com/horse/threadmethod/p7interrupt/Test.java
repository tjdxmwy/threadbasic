package com.horse.threadmethod.p7interrupt;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/3/1
 */
public class Test {
    public static void main(String[] args) {
        SubThread thread = new SubThread();
        thread.start(); //开启子线程

        //当前线程是 main 线程
        for(int i = 0; i < 100; i++) {
            System.out.println("main run ==> " + i);
        }

        //中断子线程,但是仅仅是给子线程标记中断
        thread.interrupt();
    }
}
