package com.itheima_06;

import java.util.Comparator;
import java.util.TreeSet;

public class Comparator_Demo {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int i = s1.getAge() - s2.getAge();
                int i2 = i == 0 ? s1.getName().compareTo(s2.getName()) : i;
                return i2;

            }
        });

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
