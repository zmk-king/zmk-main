package com.itheima_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Net_Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);

        Socket s = ss.accept();

        InputStream is = s.getInputStream();
        byte bys[] = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("服务端:收到客户端数据");
        System.out.println("数据是:" + data);

        OutputStream os = s.getOutputStream();
        os.write("服务端已经收到数据".getBytes());

        ss.close();
    }
}
