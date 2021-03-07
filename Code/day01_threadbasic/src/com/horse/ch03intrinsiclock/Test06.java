package com.horse.ch03intrinsiclock;

/**
 * @Description synchronized 同步静态方法
 *                  把整个方法体作为同步代码块
 *                  默认的锁对象是当前类的运行时类对象,Test06.class,有人称它为类锁
 * @Author Mr.Horse
 * @Date 2021/3/6
 */
public class Test06 {
    public static void main(String[] args) {
        //先创建 Test06 对象,通过对象名调用 mm()方法
        Test06 obj = new Test06();
        //一个线程调用 m1()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.m1();   //使用的锁对象是 Test06.class
            }
        }).start();

        //另一个线程调用 m2()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                Test06.m2();    //使用的锁对象是 Test06.class
            }
        }).start();
    }

    //定义方法,打印 100 行字符串
    public void m1() {
        //使用当前类的运行时类对象作为锁对象,可以简单的理解为把 Test06 类的字节码文件作为锁对象
        synchronized(Test06.class) {
            for(int i=1; i<=100; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
    }

    //使用 synchronized 修饰静态方法,同步静态方法, 默认运行时类 Test06.class 作为锁对象
    public synchronized static void m2() {
        for(int i=1; i<=100; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
    }
}
