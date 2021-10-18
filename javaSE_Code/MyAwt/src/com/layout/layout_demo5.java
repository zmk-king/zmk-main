package com.layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class layout_demo5 {
    public static void main(String[] args) {
        Frame frame = new Frame("这里是GridBagLayout测试");

        CardLayout card = new CardLayout();
        Panel p1 = new Panel();
        p1.setLayout(card);
        
        String[] name = {"第一张","第二张","第三张","第四张","第五张"};
        for (int i = 0; i < name.length; i++) {
            p1.add(name[i],new Button(name[i]));
        }

        //默认是放在frame的中间区域
        frame.add(p1);

        Panel p2 = new Panel();

        //创建5个按钮，并给按钮设置监听器
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                switch (command){
                    case "上一张":
                        card.previous(p1);
                        break;
                    case "下一张":
                        card.next(p1);
                        break;
                    case "第一张":
                        card.first(p1);
                        break;
                    case "最后一张":
                        card.last(p1);
                        break;
                    case "第三张":
                        card.show(p1,"第三张");
                        break;
                }
            }
        };

        Button b1 = new Button("上一张");
        Button b2 = new Button("下一张");
        Button b3 = new Button("第一张");
        Button b4 = new Button("最后一张");
        Button b5 = new Button("第三张");

        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);

        //注意把p2放在底部，否则会覆盖p1
        frame.add(p2,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
