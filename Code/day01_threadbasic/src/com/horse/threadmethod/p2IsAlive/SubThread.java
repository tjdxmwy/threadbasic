package com.horse.threadmethod.p2IsAlive;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/2/26
 */
public class SubThread extends Thread{
    @Override
    public void run() {
        System.out.println("run方法.isalive=" + this.isAlive());
    }
}