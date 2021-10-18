package com.itheima_02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Net_Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);
        //监听客户端连接，返回一个对应的socket对象
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //将数据写入文本文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("MyNet\\copy.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            //直接读取一行数据,并在控制台输出
            System.out.println(line);

            //将数据写入文本文件中
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //服务端接收完数据后给出反馈
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bufferedWriter.write("文件上传成功");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        ss.close();
        bw.close();
    }
}
