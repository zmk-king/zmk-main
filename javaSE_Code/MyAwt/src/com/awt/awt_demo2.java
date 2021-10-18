package com.awt;

import java.awt.*;

public class awt_demo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("演示panel");

        Panel panel = new Panel();

        //-Dfile.encoding=gbk
        panel.add(new TextField("测试文本"));
        panel.add(new Button("测试按钮"));

        frame.add(panel);

        frame.setBounds(100,100,500,300);

        frame.setVisible(true);
    }
}
