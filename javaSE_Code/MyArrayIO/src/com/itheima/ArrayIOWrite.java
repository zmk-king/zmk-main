package com.itheima;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayIOWrite {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> array = new ArrayList<Student>();

        Student s1 = new Student("001","周淼柯","20","湖南");
        Student s2 = new Student("002","刘祎民","19","湖南");
        Student s3 = new Student("003","曾阳涛","21","广东");
        Student s4 = new Student("004","谢吉苹","22","广东");

        array.add(s1);
        array.add(s2);
        array.add(s3);
        array.add(s4);

        //BufferedWriter bw = new BufferedWriter(new FileWriter("MyArrayIO\\student.txt",true));
        BufferedWriter bw = new BufferedWriter(new FileWriter("MyArrayIO\\student.txt"));

        for (Student s : array){
            StringBuilder sb = new StringBuilder();
            sb.append(s.getAvg()).append(",").append(s.getName()).append(",").append(s.getAge()).append(",").append(s.getAddress());
            String ss = sb.toString();
            bw.write(ss);
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
