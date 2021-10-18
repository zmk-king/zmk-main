package com.itheima_02;

public class SellTicket_Demo {
    public static void main(String[] args) {
        SellTicket st = new SellTicket();

        Thread tr1 = new Thread(st,"窗口1");
        Thread tr2 = new Thread(st,"窗口2");
        Thread tr3 = new Thread(st,"窗口3");

        tr1.start();
        tr2.start();
        tr3.start();
    }
}
