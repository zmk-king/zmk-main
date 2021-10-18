package com.itheima_02;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


import static java.lang.System.in;

public class Net_Client2 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.168.1", 12345);

        /*InetAddress address = InetAddress.getByName("DESKTOP-BA8UO1H");
        String hostName = address.getHostName();
        String hostAddress = address.getHostAddress();
        System.out.println(hostName + "," + hostAddress);*/

        //数据来源于键盘录入
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //数据来源于文本文件
        BufferedReader br = new BufferedReader(new FileReader("MyNet\\net.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line = br.readLine()) != null) {

/*            if (line.equals("886")) {
                break;
            }*/

//            OutputStream os = s.getOutputStream();
//            os.write(line.getBytes());
            //BufferedWriter特有方法
            bw.write(line);
            bw.newLine();
            bw.flush();

        }

        //结束标记，当服务器读到这时知道数据传输已经完成，服务器可以继续执行之后的代码
        s.shutdownOutput();

        //客户端接收服务端给出的反馈
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        /* byte[] bys = new byte[1024];
        int len = bufferedReader.read();
        String data = new String(bys, 0, len);
        System.out.println("客户端:"+data);*/
        String data = bufferedReader.readLine();
        System.out.println("服务器的反馈:" + data);

        br.close();
        s.close();
    }
}
