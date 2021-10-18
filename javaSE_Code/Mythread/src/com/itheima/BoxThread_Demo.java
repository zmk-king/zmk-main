package com.itheima;

public class BoxThread_Demo {
    public static void main(String[] args) {
        Box b = new Box();

        //注意在生产者类和消费者类中定义一个带Box类参数的构造方法
        //并在生产者类和消费者类中添加成员变量Box b
        //然后就可以调用Box的成员方法了
        Producer p = new Producer(b);
        Customer c = new Customer(b);

        Thread tr1 = new Thread(p);
        Thread tr2 = new Thread(c);

        tr1.start();
        tr2.start();
    }
}
