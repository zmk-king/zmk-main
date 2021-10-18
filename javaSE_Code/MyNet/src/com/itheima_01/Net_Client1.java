package com.itheima_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Net_Client1 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.168.1", 12345);

        OutputStream os = s.getOutputStream();
        os.write("hallo,Tcp,我来了!".getBytes());

        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("客户端:" + data);

        s.close();
    }
}
