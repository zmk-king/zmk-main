package com.itheima;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class ArrayFile {
    public static void main(String[] args) throws IOException {
        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                int i1 = s2.getSum() - s1.getSum();
                int i2 = i1 == 0 ? s2.getNum1() - s1.getNum1() : i1;
                int i3 = i2 == 0 ? s2.getNum2() - s1.getNum2() : i2;
                int i4 = i3 == 0 ? s1.getName().compareTo(s2.getName()) : i3;
                return i4;
            }
        });

        for (int i = 0; i < 3; i++) {

            Scanner sr = new Scanner(System.in);

            System.out.println("请输入第" + (i+1) + "个学生信息:");
            System.out.println("请输入学生姓名:");
            String name = sr.nextLine();

            System.out.println("请输入学生语文成绩:");
            int num1 = sr.nextInt();

            System.out.println("请输入学生数学成绩:");
            int num2 = sr.nextInt();

            System.out.println("请输入学生英语成绩:");
            int num3 = sr.nextInt();

            Student s = new Student();
            s.setName(name);
            s.setNum1(num1);
            s.setNum2(num2);
            s.setNum3(num3);

            ts.add(s);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("MyArrayFile\\Stuent.txt"));

        for (Student s : ts) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.getName()).append(",").append(s.getNum1()).append(",").append(s.getNum2()).append(",").append(s.getNum3()).append(",").append(s.getSum());

            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
