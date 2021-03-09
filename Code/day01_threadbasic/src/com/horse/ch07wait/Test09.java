package com.horse.ch07wait;

/**
 * @Description notify()通知过早, 就不让线程等待了
 * @Author Mr.Horse
 * @Date 2021/3/9
 */
public class Test09 {
    static boolean isFirst = true;  //定义静态变量作为是否第一个运行的线程标志

    public static void main(String[] args) {
        final Object obj = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    while(isFirst) {    //当线程是第一个开启的线程就等待
                        try {
                            System.out.println("start wait...");
                            obj.wait();
                            System.out.println("end wait...");
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("start notify");
                    obj.notify();
                    System.out.println("end notify");

                    isFirst = false;    //通知后,就把第一个线程标志修改为 false
                }
            }
        });

        //如果先开启 t1,再开启 t2 线程,大多数情况下, t1 先等待,t1 再把 t1 唤醒
        t1.start();
        t2.start();

        //如果先开启 t2 通知线程,再开启 t1 等待线程,可能会出现 t1 线程等待没有收到通知的情况
//        t2.start();
//        t1.start();

        /**
         * 实际上,调用 start()就是告诉线程调度器,当前线程准备就绪,线程调度器在什么时候开启这个线程不确定,
         * 即调用 start()方法的顺序,并不一定就是线程实际开启的顺序.
         * 在当前示例中,t1 等待后让 t2 线程唤醒 , 如果 t2 线程先唤醒了,就不让 t1 线程等待了
         */

    }
}
