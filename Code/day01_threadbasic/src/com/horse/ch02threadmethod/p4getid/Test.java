package com.horse.ch02threadmethod.p4getid;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/2/26
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ",id= " +
                Thread.currentThread().getId());

        //子线程的id
        for(int i=0; i<5; i++) {
            SubThread t = new SubThread();
            t.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
