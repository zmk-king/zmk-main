package com.event;

import java.awt.*;
import java.awt.event.*;

public class event_demo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("这里测试监听器");

        //创建一个单行文本域
        TextField tf = new TextField(30);

        Choice choice = new Choice();
        choice.add("王祖贤");
        choice.add("张曼玉");
        choice.add("柳岩");

        //给文本域添加TextListener，监听内容的变化
        tf.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                System.out.println("当前内容：" + tf.getText());
                ;
            }
        });

        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("当前选择:" + choice.getName());
            }
        });


        //给frame注册ContainerListener监听器，监听容器中组件的添加
        frame.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                Component child = e.getChild();
                System.out.println("容器中添加了新组件：" + child);
            }
        });


        //添加tf到frame
        frame.add(tf);
        frame.add(choice,BorderLayout.WEST);

        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }
}
