package com.horse.ch05cas;

/**
 * @Description 使用CAS实现一个线程安全的计数器
 * @Author Mr.Horse
 * @Date 2021/3/6
 */
public class CASTest {
    public static void main(String[] args) {
        CASCounter casCounter = new CASCounter();

        for(int i=0; i<100000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(casCounter.incrementAndGet());
                }
            }).start();
        }
    }

}

class CASCounter {
    //使用 volatile 修饰 value 值,使线程可见
    volatile private long value;

    public long getValue() {
        return value;
    }

    //定义 comare and swap 方法
    public boolean compareAndSwap(long expectValue, long newValue) {
        //如果当前 value 的值与期望的 expectedValue 值一样,就把当前的 Value 字段替换为 newValue 值
        synchronized (this) {
            if(value == expectValue) {
                value = newValue;
                return true;
            }else {
                return false;
            }
        }
    }

    //定义自增的方法
    public long incrementAndGet() {
        long oldValue;
        long newValue;

        do {
            oldValue = value;
            newValue = oldValue + 1;
        }while(! compareAndSwap(oldValue, newValue));

        return value;
    }
}
