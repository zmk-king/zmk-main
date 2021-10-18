package com.itheima_07;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Student_Demo {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //int i = (o2.getNum1() + o2.getNum2()) - (o1.getNum1() + o1.getNum2());
                //return i;
                int i1 = o2.getSum() - o1.getSum();
                int i2 = i1 == 0 ? o2.getNum1() - o1.getNum1() : i1;
                int i3 = i2 == 0 ? o1.getName().compareTo(o2.getName()) : i2;
                return i3;
            }
        });

        Student s1 = new Student("a", 10, 10);
        Student s2 = new Student("b", 10, 10);
        Student s3 = new Student("c", 10, 10);
        Student s4 = new Student("d", 30, 30);
        Student s5 = new Student("e", 20, 20);
        Student s6 = new Student("f", 40, 20);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        for (Student s : ts) {
            //System.out.println(s.getName() + "," + s.getNum1() + "," + s.getNum2() + ",总成绩:" + (s.getNum1() + s.getNum2()));
            System.out.println(s.getName() + "," + s.getNum1() + "," + s.getNum2() + ",总成绩:" + s.getSum());
        }

        System.out.println("----------------");

        Iterator<Student> iterator = ts.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            //System.out.println(s.getName() + "," + s.getNum1() + "," + s.getNum2() + ",总成绩:" + (s.getNum1() + s.getNum2()));
            System.out.println(s.getName() + "," + s.getNum1() + "," + s.getNum2() + ",总成绩:" + s.getSum());
        }
    }
}
