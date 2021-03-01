package com.horse.threadmethod.p3sleep;

/**
 * @Description 使用线程休眠 Thread.sleep 完成一个简易的计时器
 * @Author Mr.Horse
 * @Date 2021/2/26
 */
public class SimpleTimer {
    public static void main(String[] args) {
        int remaining = 10;

        if(args.length == 1) {
            remaining = Integer.parseInt(args[0]);
        }

        while (true) {
            System.out.println("remaining:" + remaining);
            remaining --;
            if(remaining < 0) {
                break;
            }

            try {
                Thread.sleep(1000); //线程休眠
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done");
    }
}
