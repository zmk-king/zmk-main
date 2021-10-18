package com.itheima_02;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket s;

    public ServerThread(Socket s) {
        //注意构造方法要将引用Socket指向成员变量Socket
        this.s = s;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            //BufferedWriter bw = new BufferedWriter(new FileWriter("MyNet\\copy.txt"));

            int flag = 1;
            File file = new File("MyNet\\copy" + flag + ".txt");
            while (file.exists()) {
                flag++;
                file = new File("MyNet\\copy" + flag + ".txt");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);

                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bufferedWriter.write("文件传输成功");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            s.close();
            //bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
