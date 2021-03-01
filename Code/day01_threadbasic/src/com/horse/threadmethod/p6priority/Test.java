package com.horse.threadmethod.p6priority;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/3/1
 */
public class Test {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.setPriority(1);
        threadA.start();

        ThreadB threadB = new ThreadB();
        threadB.setPriority(10);
        threadB.start();
    }
}
