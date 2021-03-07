package com.horse.ch02threadmethod.p7interrupt;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/3/1
 */
public class SubThread extends Thread {
    @Override
    public void run() {
        for(int i=0; i<10000; i++) {
            //判断线程的中断标志,线程有 isInterrupted()方法,该 方法返回线程的中断标志
            if(this.isInterrupted()) {
//                break;
                return; //结束当前循环
            }

            System.out.println("sub-->" + i);
        }
    }
}
