package com.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class event_demo1 {
    Frame frame = new Frame("这里测试事件处理");

    TextField tf = new TextField(20);
    Button button = new Button("确认");

    public void init(){
        button.addActionListener(new MyActionListener());

        frame.add(tf,BorderLayout.NORTH);
        frame.add(button);

        frame.pack();
        frame.setVisible(true);
    }
    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            tf.setText("HalloWord");
        }
    }
    public static void main(String[] args) {
        new event_demo1().init();
    }
}
