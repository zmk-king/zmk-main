package com.awt;

import java.awt.*;

public class awt_demo3 {
    public static void main(String[] args) {
        Frame frame = new Frame("演示Scrollpane");

        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);

        sp.add(new TextField("测试文本"));
        sp.add(new Button("测试按钮"));

        frame.add(sp);

        frame.setBounds(100,100,500,300);
        frame.setVisible(true);
    }
}
