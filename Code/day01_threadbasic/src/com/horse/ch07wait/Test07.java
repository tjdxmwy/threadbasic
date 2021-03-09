package com.horse.ch07wait;

/**
 * @Description wait(long)
 * @Author Mr.Horse
 * @Date 2021/3/9
 */
public class Test07 {
    public static void main(String[] args) {
        final Object LOCK = new Object();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK) {
                    try {
                        System.out.println("thread begin wait");
                        LOCK.wait(2000);
                        System.out.println("thread end wait");
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();
    }
}
