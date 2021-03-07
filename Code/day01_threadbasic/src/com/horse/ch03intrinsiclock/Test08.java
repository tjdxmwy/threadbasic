package com.horse.ch03intrinsiclock;

/**
 * @Description 脏读:
 *                 出现读取属性值出现了一些意外, 读取的是中间值,而不是修改之后的值
 *                 出现脏读的原因是: 对共享数据的修改与对共享数据的读取不同步
 *                 解决方法:不仅对修改数据的代码块进行同步,还要对读取数据的代码块同步
 * @Author Mr.Horse
 * @Date 2021/3/6
 */

public class Test08 {
    public static void main(String[] args) throws InterruptedException {
        //开启子线程设置用户名和密码
        PublicValue publicValue = new PublicValue();
        SubThread thread = new SubThread(publicValue);

        thread.start();

        //为了确定设置成功
        Thread.sleep(100);
        //在 main 线程中读取用户名,密码
        publicValue.getValue();

    }

    //定义线程,设置用户名和密码
    public static class SubThread extends Thread {
        private PublicValue publicValue;

        public SubThread(PublicValue publicValue) {
            this.publicValue = publicValue;
        }

        @Override
        public void run() {
            publicValue.setValue("wangwu", "wangwu");
        }
    }

    static class PublicValue {
        private String name = "Horse";
        private String pwd = "Horse";

        public /*synchronized*/ void getValue() {
            System.out.println(Thread.currentThread().getName() + ",getter--name:" + name + ",getter--pwd:" + pwd);
        }

        public synchronized void setValue(String name, String pwd) {
            this.name = name;
            try {
                Thread.sleep(1000); // 模拟操作name属性需要一段时间

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.pwd = pwd;
            System.out.println(Thread.currentThread().getName() + ",getter--name:" + name + ",getter--pwd:" + pwd);
        }
    }
}
