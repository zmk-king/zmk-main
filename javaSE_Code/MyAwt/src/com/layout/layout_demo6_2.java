package com.layout;

import javax.swing.*;
import java.awt.*;

public class layout_demo6_2 {
    public static void main(String[] args) {
        Frame frame = new Frame("这里测试BoxLayout2");

        Box hbox = Box.createHorizontalBox();
        hbox.add(new Button("水平按钮1"));
        hbox.add(new Button("水平按钮2"));

        Box vbox = Box.createVerticalBox();
        vbox.add(new Button("垂直按钮1"));
        vbox.add(new Button("垂直按钮2"));

        frame.add(hbox,BorderLayout.NORTH);
        frame.add(vbox);

        frame.pack();
        frame.setVisible(true);
    }
}
