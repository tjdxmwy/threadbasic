package com.horse.ch07wait;

/**
 * @Description wait会使程序暂停
 *              需要放在同步代码块中,通过锁对象调用
 * @Author Mr.Horse
 * @Date 2021/3/7
 */
public class Test02 {
    public static void main(String[] args) {
        String test = "horse";
        String another = "mr.horse";
        synchronized (test) {
            System.out.println("同步代码块");
            try {
                test.wait();    //调用wait()方法后,当前线程就会等待,释放锁对象.当前线程需要被唤醒,否则会一直等待
//                another.wait(); //java.lang.IllegalMonitorStateException
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait后面的代码");
        }
        System.out.println("main后面的代码");
    }
}
