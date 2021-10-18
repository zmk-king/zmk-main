package com.layout;

import java.awt.*;

public class layout_demo2_2 {
    public static void main(String[] args) {
        Frame frame = new Frame("演示borderlayout2");

        frame.setLayout(new BorderLayout(30,10));
        frame.add(new Button("北边按钮"),BorderLayout.NORTH);
        frame.add(new Button("南边按钮"),BorderLayout.SOUTH);

        Panel p = new Panel();
        p.add(new TextField("中间文本"));
        p.add(new Button("中间按钮"));

        frame.add(p);

        frame.pack();
        frame.setVisible(true);
    }
}
