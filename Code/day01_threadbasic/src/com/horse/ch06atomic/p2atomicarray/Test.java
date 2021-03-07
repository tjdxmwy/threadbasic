package com.horse.ch06atomic.p2atomicarray;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Description AtomicIntegerArray 的基本操作
 *              原子更新数组
 * @Author Mr.Horse
 * @Date 2021/3/7
 */
public class Test {
    public static void main(String[] args) {
        //1)创建一个指定长度的原子数组
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        System.out.println(atomicIntegerArray); //[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        //2)返回指定位置的元素
        System.out.println(atomicIntegerArray.get(0));  //0
        System.out.println(atomicIntegerArray.get(1));  //0
        //3)设置指定位置的元素
        atomicIntegerArray.set(0, 10);
        //在设置数组元素的新值时, 同时返回数组元素的旧值
        System.out.println(atomicIntegerArray.getAndSet(1, 20));    //0
        System.out.println(atomicIntegerArray); //[10, 20, 0, 0, 0, 0, 0, 0, 0, 0]
        //4)修改数组元素的值,把数组元素加上某个值
        System.out.println(atomicIntegerArray.addAndGet(0, 22));    //32
        System.out.println(atomicIntegerArray.getAndAdd(1, 33));    //20
        System.out.println(atomicIntegerArray); //[32, 53, 0, 0, 0, 0, 0, 0, 0, 0]
        //5)CAS 操作
        //如果数组中索引值为 0 的元素的值是 32 , 就修改为 222
        System.out.println(atomicIntegerArray.compareAndSet(0, 32, 222));   //true
        System.out.println(atomicIntegerArray); //[222, 53, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(atomicIntegerArray.compareAndSet(1, 22, 333));   //false
        System.out.println(atomicIntegerArray); //[222, 53, 0, 0, 0, 0, 0, 0, 0, 0]

        //6)自增/自减
        System.out.println(atomicIntegerArray.incrementAndGet(0));  //223
        System.out.println(atomicIntegerArray.getAndIncrement(1));  //53
        System.out.println(atomicIntegerArray);    //[223, 54, 0, 0, 0, 0, 0, 0, 0, 0]
        System.out.println(atomicIntegerArray.decrementAndGet(2));  //-1
        System.out.println(atomicIntegerArray.getAndDecrement(3));  //0
        System.out.println(atomicIntegerArray);    //[223, 54, -1, -1, 0, 0, 0, 0, 0, 0]


    }
}
