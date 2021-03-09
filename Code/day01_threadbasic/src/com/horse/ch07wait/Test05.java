package com.horse.ch07wait;

/**
 * @Description Interrupt()会中断线程的wait()等待
 * @Author Mr.Horse
 * @Date 2021/3/9
 */
public class Test05 {
    public static void main(String[] args) throws InterruptedException {
        SubThread t = new SubThread();
        t.start();

        Thread.sleep(1000); //主线程睡眠2秒, 确保子线程处于Wait等待状态
        t.interrupt();

    }

    private static final Object LOCK = new Object();    //定义常量作为锁对象
    static class SubThread extends Thread {
        @Override
        public void run() {
            synchronized (LOCK) {
                try {
                    System.out.println("begin wait ...");
                    LOCK.wait();
                    System.out.println("end wait ...");
                }catch (InterruptedException e) {
                    System.out.println("wait 等待被中断了****");
                }
            }
        }
    }
}
