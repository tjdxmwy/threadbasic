package com.horse.ch03intrinsiclock;

/**
 * @Description synchronized 同步代码块
 *              使用一个常量对象作为锁对象,不同方法中的同步代码块也可以同步
 * @Author Mr.Horse
 * @Date 2021/3/4
 */
public class Test04 {
    public static void main(String[] args) {
        //创建两个线程,分别调用 mm()方法
        //先创建 Test01 对象,通过对象名调用 mm()方法
        Test04 obj = new Test04();
        Test04 obj2 = new Test04();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj2.mm();
            }
        }).start();

        //第三个线程调用静态方法
        new Thread(() -> sm()).start();

    }

    public static final Object OBJ = new Object();

    //定义方法,打印 100 行字符串
    public void mm() {
        synchronized (OBJ){
            //使用一个常量对象作为锁对象
            for(int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }
        }
    }

    //定义方法,打印 100 行字符串
    public static void sm() {
        synchronized (OBJ) {
            for(int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }
        }
    }

}
