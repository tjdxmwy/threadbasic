package com.horse.ch06atomic.p1atomiclong;

import java.util.Random;

/**
 * @Description 模拟服务器的请求总数, 处理成功数,处理失败数
 * @Author Mr.Horse
 * @Date 2021/3/6
 */
public class Test {
    public static void main(String[] args) {
        //通过线程模拟请求,在实际应用中可以在 ServletFilter 中调用 Indicator 计数器的相关方法

        for(int i=0; i<10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //每个线程就是一个请求,请求总数要加 1
                    Indicator.getInstance().newRequestReceive();
                    int random = new Random().nextInt();
                    if(random % 2 == 0) {
                        Indicator.getInstance().requestProcessSuccess();    //偶数,处理成功
                    }else {
                        Indicator.getInstance().requestProcessFailure();    //奇数,请求失败
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Indicator.getInstance().getRequestCount());
        System.out.println(Indicator.getInstance().getSuccessCount());
        System.out.println(Indicator.getInstance().getFailureCount());

    }
}
