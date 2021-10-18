package com.itheima;

import java.io.File;

public class FlieDgui {
    public static void main(String[] args) {
        //注意盘符后面要加:（D:）
        File f1 = new File("D:\\Aidea\\ideaProjects");
        getAllFile(f1);
    }
    public static void getAllFile(File f){
        File[] files = f.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    getAllFile(file);
                } else if (file.isFile()) {
                    String s = file.getAbsolutePath();
                    System.out.println(s);
                }
            }
        }
    }
}
