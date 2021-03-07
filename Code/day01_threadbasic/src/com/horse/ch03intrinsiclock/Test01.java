package com.horse.ch03intrinsiclock;

/**
 * @Description synchronized 同步代码块
 *              this 锁对象
 * @Author Mr.Horse
 * @Date 2021/3/4
 */
public class Test01 {
    public static void main(String[] args) {
        //创建两个线程,分别调用 mm()方法
        //先创建 Test01 对象,通过对象名调用 mm()方法
        Test01 obj = new Test01();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();
            }
        }).start();


        new Thread(() -> obj.mm()).start();
    }

    //定义方法,打印100行字符串
    public void mm() {
        synchronized (this) {
            //经常使用this当前对象作为锁对象
            for(int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
        }
    }

}
