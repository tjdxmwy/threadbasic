package com.horse.ch04volatilekw;

/**
 * @Description  volatile 不是具备原子性
 * @Author Mr.Horse
 * @Date 2021/3/6
 */
public class Test02 {
    public static void main(String[] args) {
        //在main线程中创建100个子线程
        for(int x=0; x<100; x++) {
            new SubThread().start();
        }
    }

    static class SubThread extends Thread {
        //volatile 关键仅仅是表示所有线程从主内存读取 count 变量的值
        private /*volatile*/ static int count;

        /*
        //这段代码运行后不是线程安全的,想要线程安全,需要使用 synchronized 进行同步,
        //如果使用 synchronized 同时,也就不需要 volatile 关键字了
        public static void addCount() {
            for(int i=0; i<1000; i++) {
                count ++;
            }
            System.out.println(Thread.currentThread().getName() + ": count=" + count);
        }
        */

        public static synchronized void addCount() {
            for(int i=0; i<1000; i++) {
                count ++;
            }
            System.out.println(Thread.currentThread().getName() + ": count=" + count);
        }

        @Override
        public void run() {
            addCount();
        }
    }
}
