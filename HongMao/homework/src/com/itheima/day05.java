package com.itheima;

public class day05 {
    public static void main(String[] args) {
/*        int a, b, c = 0;
        for (int i = 100; i < 1000; i++) {
            a = i / 100;

            b = i % 100 / 10;
            c = i % 10;
            if (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) == i) {
                System.out.println(i);
            }
        }
        System.out.println("请按任意键继续...");*/

            final int HANG = 10;
            System.out.println("打印图形一:");
            char ch = 'A';
            for (int i = HANG; i > 0; i--) {
                for (int j = 0; j < i - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < HANG + 1 - i; j++) {
                    System.out.print(ch);
                }
                for (int j = 0; j < HANG - i; j++) {
                    System.out.print(ch);
                }
                System.out.println();
                ch++;
            }
    }
}
