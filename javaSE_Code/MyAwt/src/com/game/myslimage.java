package com.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class myslimage {
    private Frame frame = new Frame("图片查看器");

    //定义一个BufferedImage对象
    private BufferedImage image;

    private Mycanvas imageComponent = new Mycanvas();

    private class Mycanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            if (image!=null){
                g.drawImage(image,0,0,image.getWidth(),image.getHeight(),null);
            }
        }
    }

    private void init(){
        //设置菜单项
        MenuBar mb = new MenuBar();
        Menu menu = new Menu("文件");
        MenuItem openItem = new MenuItem("打开");
        MenuItem saveItem = new MenuItem("另存为");

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出对话框，选择本地图片
                FileDialog fileDialog = new FileDialog(frame);
                fileDialog.setVisible(true);

                //读取用户选择的图片
                String directory = fileDialog.getDirectory();
                String file = fileDialog.getFile();

                try {
                    image = ImageIO.read(new File(directory, file));

                    //获取文件路径后，重新绘制image图片
                    imageComponent.repaint();

                } catch (IOException ioException) {
                    ioException.printStackTrace();

                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出对话框，选择保存的位置
                FileDialog sfileDialog = new FileDialog(frame,"保存图片",FileDialog.SAVE);
                sfileDialog.setVisible(true);

                //读取用户选择的图片
                String directory = sfileDialog.getDirectory();
                String file = sfileDialog.getFile();

                try {
                    ImageIO.write(image,"JPEG",new File(directory, file));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        menu.add(openItem);
        menu.add(saveItem);

        mb.add(menu);

        frame.setMenuBar(mb);
        frame.add(imageComponent);

        frame.setBounds(200,200,800,600);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new myslimage().init();
    }
}
