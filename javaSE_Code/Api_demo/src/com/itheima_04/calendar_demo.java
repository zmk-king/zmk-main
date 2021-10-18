package com.itheima_04;

import java.util.Calendar;
import java.util.Scanner;

public class calendar_demo {
    public static void main(String[] args) {
        System.out.println("请输入年份:");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        Calendar cld = Calendar.getInstance();

        cld.set(year, 2, 1);
        cld.add(Calendar.DATE, -1);

        int dd = cld.get(Calendar.DATE);
        System.out.println("该年份二月有:" + dd + "天");
    }
}
