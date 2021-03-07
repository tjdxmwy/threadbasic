package com.horse.ch06atomic.p4atomicreference;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description AtomicStampedReference 原子类可以解决 CAS 中的 ABA 问题
 *              在 AtomicStampedReference 原子类中有一个整数标记值 stamp,
 *              每次执行 CAS 操作时,需要对比它的版本,即比较 stamp 的值
 * @Author Mr.Horse
 * @Date 2021/3/7
 */
public class Test03 {
    //定义 AtomicStampedReference 引用操作"abc"字符串,指定初始化版本号为 0
    static AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("abc", 0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicStampedReference.compareAndSet("abc", "def", atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName() + "---" + atomicStampedReference.getReference());
                atomicStampedReference.compareAndSet("def", "abc", atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName() + "---" + atomicStampedReference.getReference());

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = atomicStampedReference.getStamp();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(atomicStampedReference.compareAndSet("abc", "ghg", stamp, stamp + 1));
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(atomicStampedReference.getReference());
    }
}
