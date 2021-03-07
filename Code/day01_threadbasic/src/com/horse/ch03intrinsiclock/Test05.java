package com.horse.ch03intrinsiclock;

/**
 * @Description synchronized 同步实例方法
 *                  把整个方法体作为同步代码块
 *                  默认的锁对象是 this 对象
 * @Author Mr.Horse
 * @Date 2021/3/6
 */
public class Test05 {
    public static void main(String[] args) {
        //先创建 Test05 对象,通过对象名调用 mm()方法
        Test05 obj = new Test05();

        //一个线程调用 mm()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();
            }
        }).start();

        //另一个线程调用 mm22()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm2();  //使用的锁对象this也是obj对象,可以同步
//                new Test05().mm2(); //使用的锁对象 this 是刚刚 new 创建的一个新对象,不是同一个锁对象不能同步
            }
        }).start();
    }

    //定义方法,打印 100 行字符串
    public void mm() {
        synchronized(this) {
            //经常使用this作为锁对象
            for(int i=1; i<=100; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
        }
    }

    //使用 synchronized 修饰实例方法,同步实例方法, 默认 this 作为锁对象
    public synchronized void mm2() {
        for(int i=1; i<=100; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
