package com.horse.threadmethod.p3sleep;

/**
 * @Description
 * @Author Mr.Horse
 * @Date 2021/2/26
 */
public class Test {
    public static void main(String[] args) {
        SubThread thread = new SubThread();
        System.out.println("main__begin: " + System.currentTimeMillis());

        thread.start();
        /**
         * 返回结果:
         *      main__begin: 1614325531094
         *      main__end: 1614325531095
         *      run, threadname=Thread-0,begin=1614325531095
         *      run, threadname=Thread-0,end=1614325533098
         */

//        thread.run();   //在 main 线程中调用实例方法 run(),没有开启新的线程
        /**
         * 返回结果:
         *      main__begin: 1614325467212
         *      run, threadname=main,begin=1614325467212
         *      run, threadname=main,end=1614325469217
         *      main__end: 1614325469217
         */

        System.out.println("main__end: " + System.currentTimeMillis());
    }
}
