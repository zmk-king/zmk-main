package com.layout;

import javax.swing.*;
import java.awt.*;

public class layout_demo6_3 {
    public static void main(String[] args) {
        Frame frame = new Frame("这里测试BoxLayout3");

        Box hbox = Box.createHorizontalBox();
        hbox.add(new Button("水平按钮1"));
        hbox.add(Box.createHorizontalGlue());
        hbox.add(new Button("水平按钮2"));
        hbox.add(Box.createHorizontalStrut(10));
        hbox.add(new Button("水平按钮3"));

        Box vbox = Box.createVerticalBox();
        vbox.add(new Button("垂直按钮1"));
        vbox.add(Box.createVerticalGlue());
        vbox.add(new Button("垂直按钮2"));
        vbox.add(Box.createVerticalStrut(10));
        vbox.add(new Button("垂直按钮3"));

        frame.add(hbox,BorderLayout.NORTH);
        frame.add(vbox);

        frame.pack();
        frame.setVisible(true);
    }
}
