package com.hongmao;

import java.util.ArrayList;
import java.util.Scanner;

public class day1_01 {
    public static void main(String[] args) {
/*        System.out.println("请输入学生人数：");
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

        System.out.println("成绩排名：" + arry);*/
/*        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        sc.nextLine();
        System.out.println("请输入你的年龄");
        sc.nextLine();
        System.out.println("请输入你的性别");
        sc.nextLine();
        System.out.println("请输入你的学历");
        sc.nextLine();
        System.out.println("请输入你的性格");
        sc.nextLine();*/
/*        int  a=1;
        int  b=2;
        int c=--a;
        int  d=b++;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);*/
        /*int x=1,y=1,z=1;
        boolean flag=x--==0&&y++==1||z++==1;
        System.out.println(flag);
        System.out.println("x="+x);
        System.out.println("y="+y);
        System.out.println("z="+z);*/
/*        int x = 1, y = 1, z = 1;
        boolean flag = x--==1||y++ == 1 && z++ == 2;
        System.out.println(flag);
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println("z=" + z);*/
/*        int a=1;
        int b=2;
        char ch='a';
        String str="abc";
        str=a+b+str;//结果是多少
        System.out.println(str);
        str=str+a+b;//结果是多少
        System.out.println(str);
        str=ch+a+str;//结果是多少
        System.out.println(str);
        str=str+a+ch;////结果是多少
        System.out.println(str);*/
        /*Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + 1);
            System.out.println(substring);
        }*/
/*        Scanner sc = new Scanner(System.in);
        System.out.println("请输入页数：");
        int i = sc.nextInt();
        i = i % 10 == 0 ? i / 10 : (i % 10) + 1;
        System.out.println(i);*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的工资：");
        int money = scanner.nextInt();
        if (money<=2000){
            System.out.println("工资太低仅能养活自己");
        }else if (money<=3000){
            System.out.println("每月还能留几百元");
        }else {
            System.out.println("你可以去尝试谈恋爱了");
        }
    }
}
