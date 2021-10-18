package com.api;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class api_demo {

    Frame frame = new Frame("这里测试基本组件");

    Button ok = new Button("确定");
    TextField tf = new TextField();

    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox man = new Checkbox("男",cbg,true);
    Checkbox woman = new Checkbox("女",cbg,false);
    Checkbox marry = new Checkbox("是否已婚",false);
    Choice colorchoice = new Choice();

    TextArea ta = new TextArea(5,20);

    //列表选择框，后面的true表示可以多选
    List coloelist = new List(6,true);

    public void init(){
        MyLisetenr myLisetenr = new MyLisetenr();
        ok.addActionListener(myLisetenr);

        Box hbox = Box.createHorizontalBox();
        hbox.add(tf);
        hbox.add(ok);
        frame.add(hbox,BorderLayout.SOUTH);

        colorchoice.add("红色");
        colorchoice.add("蓝色");
        colorchoice.add("绿色");

        Box cbox = Box.createHorizontalBox();
        cbox.add(colorchoice);
        cbox.add(man);
        cbox.add(woman);
        cbox.add(marry);

        Box topleft = Box.createVerticalBox();
        topleft.add(ta);
        topleft.add(cbox);

        coloelist.add("红色");
        coloelist.add("蓝色");
        coloelist.add("绿色");
        Box top = Box.createHorizontalBox();
        top.add(topleft);
        top.add(coloelist);
        frame.add(top);

        frame.pack();
        frame.setVisible(true);
    }

    private class MyLisetenr implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = tf.getText();
            ta.append(text);
        }
    }

    public static void main(String[] args) {
        new api_demo().init();
    }
}
