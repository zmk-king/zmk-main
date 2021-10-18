package com.itheima;

public class Class_Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Student> c1 = Student.class;
        System.out.println(c1);

        Student student = new Student();
        Class<? extends Student> c2 = student.getClass();
        System.out.println(c2 == c1);

        Class<?> c3 = Class.forName("com.itheima.Student");
        System.out.println(c3 == c1);
    }
}
