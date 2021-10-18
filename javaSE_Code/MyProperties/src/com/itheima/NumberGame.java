package com.itheima;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private NumberGame() {
    }

    public static void Start() {
        Random r = new Random();
        int number = r.nextInt(100) + 1;

        while (true) {
            Scanner sr = new Scanner(System.in);
            System.out.println("请输入你猜的数:");
            int i = sr.nextInt();
            if (i > number) {
                System.out.println("你猜的数大了!");
            } else if (i < number) {
                System.out.println("你猜的数小了!");
            } else if (i == number) {
                System.out.println("恭喜你!你猜对了");
                break;
            }
        }
    }
}


