package com.itheima;

import java.io.File;

public class File_Demo {
    public static void main(String[] args) {
        //file构造方法，不会真的创建文件
        //在f1中Aidea和itcast均为目录（即文件夹），java.text为文件
        File f1 = new File("D\\Aidea\\itcast\\java.text");
        System.out.println(f1);

        File f2 = new File("D\\Aidea\\itcast","java.text");
        System.out.println(f2);

        File f3 = new File("D\\Aidea\\itcast");
        File f4 = new File(f3,"java.text");
        System.out.println(f4);
        
    }
}
