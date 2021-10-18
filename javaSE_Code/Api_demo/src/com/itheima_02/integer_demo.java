package com.itheima_02;

public class integer_demo {
    public static void main(String[] args) {
        int i1 = new Integer(100);
        System.out.println(i1);
        int i2 = new Integer("100");
        System.out.println(i2);
        int i3 = Integer.valueOf(100);
        System.out.println(i3);
        int i4 = Integer.valueOf("100");
        System.out.println(i4);
        int i5 = Integer.valueOf("1000",4);
        System.out.println(i5);
    }
}
