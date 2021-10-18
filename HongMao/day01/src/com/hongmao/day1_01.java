package com.hongmao;

import java.util.ArrayList;
import java.util.Scanner;

public class day1_01 {
    public static void main(String[] args) {

        System.out.println("请输入学生人数：");
        Scanner sc = new Scanner(System.in);
        int Line = sc.nextInt();

        ArrayList<Integer> arry = new ArrayList<>();

        for (int i = 0; i < Line; i++) {
            System.out.println("请输入第" + (i + 1) + "名学生的成绩：");
            Scanner sc2 = new Scanner(System.in);
            int Line2 = sc.nextInt();

            arry.add(Line2);
        }

        System.out.println("成绩信息：" + arry);


        for (int i = 0; i < arry.size(); i++) {
            for (int j = i + 1; j < arry.size(); j++) {
                if (arry.get(i) > arry.get(j)) {
                    int temp = arry.get(i);
                    arry.set(i, arry.get(j));
                    arry.set(j, temp);
                }
            }
        }

        System.out.println("成绩排名：" + arry);

    }
}
