package com.itheima_01;

import java.util.Scanner;

public class Test_02 {
    public static void main(String[] args) {
        char[] arr = new char[5];
        System.out.println("请输入:");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
/*        for (int i = 0; i < line.length(); i++) {
            arr[i] = line.charAt(i);
        }*/
        //System.out.println();
        getChar(arr, line);
        System.out.print("转换后:");
        System.out.println(arr);
        System.out.print("按格式输出:");
        String s = arrayToString(arr);
        System.out.println(s);
    }

    public static String arrayToString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(",");
            }
        }
        sb.append("]");
        String s = sb.toString();
        return s;
    }

    public static String getChar(char[] arr, String line) {
        for (int i = 0; i < line.length(); i++) {
            arr[i] = line.charAt(i);
        }
        return String.valueOf(arr);
    }
}
