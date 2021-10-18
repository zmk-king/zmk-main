package com.game;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class mydarw {
    //定义画图区的宽高
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 400;

    //定义变量，保存上一次鼠标拖动时，鼠标的坐标
    private int prex = -1;
    private int prey = -1;

    //定义一个右键菜单，用于设置画笔的颜色
    private PopupMenu colorMenu = new PopupMenu();
    private MenuItem redItem = new MenuItem("红色");
    private MenuItem greenItem = new MenuItem("绿色");
    private MenuItem blueItem = new MenuItem("蓝色");

    //定义一个BufferedImage对象
    private BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_BGR);

    //获取BufferedImage对象关联的画笔
    private Graphics g = image.getGraphics();

    //定义窗口对象
    //JFrame为swing中的窗口类
    //自动实现了当点击窗口X的时候退出(windowClosing)
    private JFrame frame = new JFrame("简单手绘程序");

    //定义画布对象
    private JPanel drawarea = new JPanel() {
        @Override
        public void paint(Graphics g) {
            //把位图image绘制到0,0坐标点
            //从（0,0）开始参数
            //img - 要绘制的指定图像。 如果img为null，则此方法不执行任何img 。
            //x - x坐标。
            //y - y坐标。
            //observer - 要转换更多图像时要通知的对象。
            g.drawImage(image, 0,0 , null);
        }
    };


    private Color forceColor = Color.BLACK;

    private void init() {
        //定义颜色菜单项单击监听器
        ActionListener colorlistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                switch (command) {
                    case "红色":
                        forceColor = Color.RED;
                        break;
                    case "绿色":
                        forceColor = Color.GREEN;
                        break;
                    case "蓝色":
                        forceColor = Color.BLUE;
                        break;
                }
            }
        };

        //为三个菜单项添加点击事件
        redItem.addActionListener(colorlistener);
        blueItem.addActionListener(colorlistener);
        greenItem.addActionListener(colorlistener);

        //把菜单项添加到右键菜单中
        colorMenu.add(redItem);
        colorMenu.add(blueItem);
        colorMenu.add(greenItem);

        //把右键菜单添加到绘图区域drawArea
        drawarea.add(colorMenu);

        //将iamge图片背景设置为白色
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);

        //绘图区域drawArea设置鼠标移动监听器
        drawarea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            //按下鼠标键并拖动会触发
            public void mouseDragged(MouseEvent e) {
                if (prex > 0 && prey > 0) {
                    g.setColor(forceColor);
                    g.drawLine(prex, prey, e.getX(), e.getY());
                }

                System.out.println("开始绘画");
                //更新preX和preY
                prex = e.getX();
                prey = e.getY();

                //重新绘制drawArea组件
                drawarea.repaint();
            }
        });

        //设置绘图区域drawArea的大小
        drawarea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));

        drawarea.addMouseListener(new MouseAdapter() {
            @Override
            //松开鼠标键会触发
            public void mouseReleased(MouseEvent e) {
                boolean trigger = e.isPopupTrigger();
                if (trigger) {
                    //把colorMenu显示到drawArea画图区域，并跟随鼠标显示
                    colorMenu.show(drawarea, e.getX(), e.getY());
                }

                //当鼠标松开时，把preX和preY重置为-1
                prex = -1;
                prey = -1;
            }
        });

        //把drawArea添加到frame中
        frame.add(drawarea);

        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new mydarw().init();
    }
}
