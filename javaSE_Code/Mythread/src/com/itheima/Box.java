package com.itheima;

public class Box {
    private int milk;
    private boolean state = false;


    public synchronized void put(int milk) {
        if (state) {
            try {
                //wait要配合锁来使用(线程执行wait方法时会释放当前锁，然后让出cpu进入等待状态)
                //wait方法使用时是要被try catch包围，以保证即使放生异常中断也能使wait等待的进程被唤醒
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.milk = milk;
        System.out.println("生产者送来了第" + milk + "瓶牛奶");

        state = true;

        notifyAll();
    }

    public synchronized void get() {
        if (!state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("消费者拿到了第" + milk + "瓶牛奶");

        state = false;

        notifyAll();
    }
}
