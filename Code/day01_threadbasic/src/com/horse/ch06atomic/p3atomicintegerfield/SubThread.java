package com.horse.ch06atomic.p3atomicintegerfield;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Description 线程类
 * @Author Mr.Horse
 * @Date 2021/3/7
 */
public class SubThread extends Thread {

    private User user;  //需要更新的对象

    //创建 AtomicIntegerFieldUpdater 更新器
    private AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public SubThread(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        //在子线程中对 user 对象的 age 字段自增 10 次
        for(int i=0; i<10; i++) {
            System.out.println(updater.getAndIncrement(user));
        }
    }
}
