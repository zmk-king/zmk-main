package com.layout;

import javax.swing.*;
import java.awt.*;

public class layout_demo6_1 {
    public static void main(String[] args) {
        Frame frame = new Frame("这里测试BoxLayout");

        BoxLayout box = new BoxLayout(frame,BoxLayout.Y_AXIS);

        frame.setLayout(box);

        frame.add(new Button("按钮1"));
        frame.add(new Button("按钮2"));

        frame.pack();
        frame.setVisible(true);
    }
}
