package com.itheima;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class GameProperties {
    public static void main(String[] args) throws IOException {
        //NumberGame.Start();

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("MyProperties\\game.txt");
        prop.load(fis);
        fis.close();

        String number = prop.getProperty("Number");
        int i = Integer.parseInt(number);

        if (i <= 0) {
            System.out.println("游戏次数已用完，请充值!");
            System.out.println("请输入要充值的金额:(元/次)");

            Scanner sr = new Scanner(System.in);
            int nextInt = sr.nextInt();
            i = nextInt;

            prop.setProperty("Number", String.valueOf(i));

            FileOutputStream fos = new FileOutputStream("MyProperties\\game.txt");
            prop.store(fos, null);
            fos.close();
        } else {
            System.out.println("剩余游戏次数:" + i + "次");
            System.out.println("是否继续游戏:");
            System.out.println("1.是"+"  "+"2.否");

            Scanner sr = new Scanner(System.in);
            int nextInt = sr.nextInt();
            if (nextInt == 1) {
                NumberGame.Start();
                i--;
                prop.setProperty("Number", String.valueOf(i));

                FileOutputStream fos = new FileOutputStream("MyProperties\\game.txt");
                prop.store(fos, null);
                fos.close();
            }else if (nextInt == 2){
                System.exit(0);
            }
        }
    }
}
