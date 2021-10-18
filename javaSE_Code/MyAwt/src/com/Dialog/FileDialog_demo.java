package com.Dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileDialog_demo {
    public static void main(String[] args) {
        Frame frame = new Frame("这里测试FileDialog");

        FileDialog f1 = new FileDialog(frame, "选择要打开的文件:", FileDialog.LOAD);
        FileDialog f2 = new FileDialog(frame, "选择要保存的文件:", FileDialog.SAVE);

        Button b1 = new Button("打开文件");
        Button b2 = new Button("保存文件");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);

                String directory = f1.getDirectory();
                String file = f1.getFile();

                System.out.println("用户打开的文件路径为:" + directory);
                System.out.println("用户打开的文件名为:" + file);
                System.out.println("-------------------");
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(true);

                String directory = f2.getDirectory();
                String file = f2.getFile();

                System.out.println("用户保存的文件路径为:" + directory);
                System.out.println("用户保存的文件名为:" + file);
            }
        });

        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2);

        frame.pack();
        frame.setVisible(true);
    }
}
