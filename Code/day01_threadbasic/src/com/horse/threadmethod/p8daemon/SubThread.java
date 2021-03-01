package com.horse.threadmethod.p8daemon;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/3/1
 */
public class SubThread extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("sub Thread...");
        }
    }
}
