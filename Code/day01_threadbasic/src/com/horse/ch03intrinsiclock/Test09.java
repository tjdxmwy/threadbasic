package com.horse.ch03intrinsiclock;

/**
 * @Description 同步过程中线程出现异常,会自动释放锁对象
 * @Author Mr.Horse
 * @Date 2021/3/6
 */
public class Test09 {
    public static void main(String[] args) {
        Test09 obj = new Test09();
        new Thread(() -> obj.m1()).start();
        new Thread(() -> Test09.m2()).start();
    }

    public void m1() {
        synchronized (Test09.class) {
            for(int i=1; i<=100; i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);

                if(i == 50) {
                    int a = Integer.parseInt("abc");//把字符串转换为 int 类型时,如果字符串不符合 数字格式会产生异常
                }
            }
        }
    }

    //使用 synchronized 修饰静态方法,同步静态方法, 默认运行时类 Test06.class 作为锁对象
    public static synchronized void m2() {
        for(int i=1; i<=100; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
    }
}
