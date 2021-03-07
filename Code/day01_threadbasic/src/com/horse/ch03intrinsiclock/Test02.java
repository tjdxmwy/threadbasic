package com.horse.ch03intrinsiclock;

/**
 * @Description synchronized同步代码块
 *              如果线程的锁不同,不能实现同步
 *              想要同步必须使用同一个锁对象
 * @Author Mr.Horse
 * @Date 2021/3/4
 */
public class Test02 {
    public static void main(String[] args) {
        //创建两个线程,分别调用 mm()方法
        //先创建 Test01 对象,通过对象名调用 mm()方法
        Test01 obj = new Test01();
        Test02 obj2 = new Test02();

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
    }

    //定义方法,打印 100 行字符串
    public void mm() {
        synchronized(this) {
            //经常使用this当前对象作为锁对象
            for(int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
        }

    }
}
