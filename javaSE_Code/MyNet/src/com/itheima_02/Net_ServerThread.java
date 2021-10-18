package com.itheima_02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Net_ServerThread {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);

        //多线程，为每一个客户端开启一个线程
        while (true) {
            Socket s = ss.accept();
            new Thread(new ServerThread(s)).start();
        }
    }
}
