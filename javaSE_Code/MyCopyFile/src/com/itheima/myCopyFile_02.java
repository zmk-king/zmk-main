package com.itheima;

import java.io.*;

public class myCopyFile_02 {
    public static void main(String[] args) throws IOException {

        File srcFile = new File("D:\\itcast");
        File destFile = new File("E:\\");

        copyFileDg(srcFile, destFile);
    }

    private static void copyFileDg(File srcFile, File destFile) throws IOException {

        //if循坏写外面，否则会导致文件无法访问，即没次递归都要新的newdestFile
        if (srcFile.isDirectory()) {
            String srcFileName = srcFile.getName();

            //注意new File("destFile","srcFileName")会报错
            //报错原因是destFile是一个File对象，不需要用“”，而srcFileName本身就是String类型，也不需要“”
            //File(File parent, String child)从父抽象路径名和子路径名字符串创建新的 File实例。
            //File(String pathname)通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
            //File(String parent, String child)从父路径名字符串和子路径名字符串创建新的 File实例。
            File newdestFile = new File(destFile, srcFileName);//这里用的是第一种

            if (!newdestFile.exists()) {
                newdestFile.mkdir();
            }

            File[] files = srcFile.listFiles();

            for (File file : files) {
                copyFileDg(file, newdestFile);
            }
        } else {
            File newdestFile = new File(destFile, srcFile.getName());
            copyFile(srcFile, newdestFile);
        }
    }

/*        String srcFileName = srcFile.getName();

        //注意new File("destFile","srcFileName")会报错
        File newdestFile = new File(destFile, srcFileName);

        if (!newdestFile.exists()) {
            newdestFile.mkdir();
        }

        File[] files = srcFile.listFiles();

        for(File file : files){
            if (file.isDirectory()) {
                copyFileDg(file, newdestFile);
            }else
                copyFile(srcFile,newdestFile);
        }
}*/

        private static void copyFile (File srcFile, File destFile) throws IOException {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

            byte[] bys = new byte[1024];
            int len;
            while ((len = bis.read(bys)) != -1) {
                bos.write(bys, 0, len);
            }
            bis.close();
            bos.close();
        }

    }