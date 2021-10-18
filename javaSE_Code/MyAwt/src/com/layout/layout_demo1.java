package com.layout;

import java.awt.*;

public class layout_demo1 {
    public static void main(String[] args) {
        Frame frame =new Frame("演示flowlayout");

        frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        for (int i = 1; i <= 100; i++) {
            frame.add(new Button("按钮"+i));
        }

        frame.pack();

        frame.setVisible(true);
    }
}
