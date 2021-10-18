package com.Dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog_demo1 {
    Frame frame = new Frame("这里测试Dialog");

    Dialog d1 = new Dialog(frame,"模式对话框",true);
    Dialog d2 = new Dialog(frame,"非模式对话框",false);

    Button b1 = new Button("打开模式对话框");
    Button b2 = new Button("打开非模式对话框");

    Box vBox1 = Box.createVerticalBox();
    Box vBox2 = Box.createVerticalBox();

    public void init(){

        vBox1.add(new TextField(15));
        vBox1.add(new Button("确认"));

        vBox2.add(new TextField(15));
        vBox2.add(new Button("确认"));

        d1.add(vBox1);
        d2.add(vBox2);
        d1.setBounds(20,30,200,100);
        d2.setBounds(20,30,200,100);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d2.setVisible(true);
            }
        });

        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Dialog_demo1().init();
    }
}
