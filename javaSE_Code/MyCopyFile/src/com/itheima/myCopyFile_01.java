package com.itheima;

import java.io.*;

public class myCopyFile_01 {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("D:\\itcasttwo");

        String srcFileName = srcFile.getName();

        //File(File parent, String child)从父抽象路径名和子路径名字符串创建新的 File实例。
        //File(String pathname)通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
        //File(String parent, String child)从父路径名字符串和子路径名字符串创建新的 File实例。
        File destFile = new File("MyCopyFile", srcFileName);//这里用的是第三种

        if (!destFile.exists()) {
            destFile.mkdir();
        }

        File[] files = srcFile.listFiles();

        for (File file : files) {
            String fileName = file.getName();
            File newFile = new File(destFile, fileName);
            //注意这里的file相当于srcFile下的次级目录或文件，而且考虑到循坏，用file是最好的方法
            copyFile(file, newFile);
        }
    }

    public static void copyFile(File destFile, File newFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(destFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));

        byte[] bys = new byte[1024];
        int len;
        //字节流缓冲流复制文件用while循坏好一点
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }

        bis.close();
        bos.close();
    }
}
