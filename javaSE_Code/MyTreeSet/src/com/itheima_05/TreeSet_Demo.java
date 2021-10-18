package com.itheima_05;

import java.util.TreeSet;

public class TreeSet_Demo {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<Student>();

        Student s1 = new Student("abc", 20);
        Student s2 = new Student("bbc", 19);
        Student s3 = new Student("cbc", 22);
        Student s4 = new Student("dbc", 21);

        Student s5 = new Student("abd", 19);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);

        for (Student s : ts) {
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}
