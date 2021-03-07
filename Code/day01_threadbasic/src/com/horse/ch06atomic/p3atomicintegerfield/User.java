package com.horse.ch06atomic.p3atomicintegerfield;

/**
 * @Description 使用 AtomicIntegerFieldUpdater 更新的字段必须使用 volatile 修饰
 * @Author Mr.Horse
 * @Date 2021/3/7
 */
public class User {
    int id;
    volatile int age;

    public User(int id, int age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public String
    toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
