package com.horse.ch07wait;

/**
 * @Description wait()/notify()方法需要放在同步代码块中,否则产生java.lang.IllegalMonitorStateException异常
 *  任何对象都可以调用wait()/notify()方法,这两个方法是Object类的方法
 * @Author Mr.Horse
 * @Date 2021/3/7
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            String test = "horse";
            test.wait();    //java.lang.IllegalMonitorStateException
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
