package com.horse.ch07wait;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description notify不会立即释放锁
 * @Author Mr.Horse
 * @Date 2021/3/7
 */
public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        //定义一个list作为锁对象
        List<String> list = new ArrayList<>();

        //定义第二个线程,list集合长度不等于5时线程等待
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list) {
                    if(list.size() != 5) {
                        System.out.println("线程1等待开始" + System.currentTimeMillis());
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("线程1等待结束" + System.currentTimeMillis());
                    }
                }
            }
        });

        //定义第二个线程,往list集合中添加元素
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list) {
                    for(int i = 0; i < 10; i ++) {
                        list.add("data--" + i);
                        System.out.println("list集合添加了第" + i +"个元素");

                        //判断list的size是否等于5,满足的话唤醒线程1
                        if(list.size() == 5) {
                            System.out.println("线程2发现了唤醒线程");
                            list.notify();
                        }
                    }
                }
            }
        });

        t1.start();
        Thread.sleep(100);
        t2.start();
    }
}
