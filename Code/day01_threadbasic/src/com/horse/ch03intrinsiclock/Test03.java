package com.horse.ch03intrinsiclock;

/**
 * @Description synchronized 同步代码块
 *              使用一个常量对象作为锁对象
 * @Author Mr.Horse
 * @Date 2021/3/4
 */
public class Test03 {
    public static void main(String[] args) {
        //创建两个线程,分别调用 mm()方法
        //先创建 Test01 对象,通过对象名调用 mm()方法
        Test03 obj = new Test03();
        Test03 obj2 = new Test03();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();
            }
        }).start();

        new Thread(() -> obj2.mm()).start();

    }

    public static final Object OBJ = new Object();
    public void mm() {
        synchronized (OBJ) {
            //使用一个常量对象作为锁对象
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i); }
        }
    }


}
