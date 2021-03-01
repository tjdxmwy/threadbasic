package com.horse.threadmethod.p4getid;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/2/26
 */
public class SubThread extends Thread{
    @Override
    public void run() {
        System.out.println("thread.getName()=" + Thread.currentThread().getName() +
                ",id=" + Thread.currentThread().getId());
    }
}
