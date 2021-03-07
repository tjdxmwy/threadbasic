package com.horse.ch02threadmethod.p2IsAlive;

/**
 * @Description 测试当前线程的活动状态
 * @Author Mr.Horse
 * @Date 2021/2/26
 */
public class Test {
    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        System.out.println("begin ==" + subThread.isAlive());   //false,在启动线程之前

        subThread.start();
        System.out.println("end ==" + subThread.isAlive());
        //结果不一定,打印这一行时,如果subThread线程还没结束就返回true,如果subThread线程已结束,就返回false
    }
}
