package com.itheima_01;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String s = arrayTest(line);
        System.out.println(s);
    }

    public static String arrayTest(String s) {

//        StringBuilder sb = new StringBuilder(s);
//        sb.reverse();
//        String ss = sb.toString();
//        return ss;

        return new StringBuilder(s).reverse().toString();
    }
}
