package com.horse.ch04volatilekw;

/**
 * @Description volatile的作用可以强制线程从公共内存中读取变量的值,而不是从工作内存中读取
 * @Author Mr.Horse
 * @Date 2021/3/6
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        //创建 PrintString 对象
        PrintString printString = new PrintString();

        //创建 PrintString 对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                printString.printMethod();
            }
        }).start();

        Thread.sleep(1000);

        /**
         * 程序运行,查看在 main 线程中修改了打印标志之后 ,子线程打印是否可以结束打印
         * 程序运行后, 可能会出现死循环情况
         * 分析原因: main 线程修改了 printString 对象的打印标志后, 子线程读不到
         * 解决办法: 使用 volatile 关键字修饰 printString 对象的打印标志.
         *      volatile 的作用可以强制线程从公共内存中读取变量的值,而不是从工作内存中读取
         */

        System.out.println("在main线程中打印标志");
        printString.setContinuePrint(false);
    }

    //定义类打印字符串
    static class PrintString {
        private volatile boolean continuePrint = true;

        public PrintString setContinuePrint(boolean continuePrint) {
            this.continuePrint = continuePrint;
            return this;
        }

        public void printMethod() {
            System.out.println(Thread.currentThread().getName() + "开始...");
            while(continuePrint) {

            }

            System.out.println(Thread.currentThread().getName() + "结束...");
        }

    }
}
