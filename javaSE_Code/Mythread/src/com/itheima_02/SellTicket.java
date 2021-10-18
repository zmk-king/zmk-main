package com.itheima_02;

public class SellTicket implements Runnable {

    private int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //锁synchronized不能直接写到run方法上，这样会导致一直执行线程一而其他线程进不来
            //synchronized线程锁给同步代码块加锁，这个锁就相当于obj，多个线程使用同一共享资源，应该使用同一个锁
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":正在出售第" + ticket + "张票");
                    ticket--;
                } else {
                    System.out.println(Thread.currentThread().getName() + "的票卖完了");
                    break;
                }
            }
        }
    }
}
