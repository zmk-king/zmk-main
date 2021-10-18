package com.game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class mygame1 {
    //创建窗口对象
    Frame frame = new Frame("弹球游戏");

    //创建panel菜单栏
    MenuBar menuBar = new MenuBar();
    Panel p = new Panel();

    Button start = new Button("开始");
    Button stop = new Button("暂停");
    Button exit = new Button("退出");
    Button agin = new Button("重新开始");

    Menu speed = new Menu("速度");

    MenuItem one = new MenuItem("一档速度");
    MenuItem two = new MenuItem("二档速度");

    //设置桌面的宽和高
    private final int TABLE_HEIGHT = 400;
    private final int TABLE_WIDTH = 300;

    //设置球拍的宽和高
    private final int RACKET_WIDTH = 40;
    private final int RACKET_HEIGHT = 20;

    //小球的大小
    private final int BALL_SIZE = 15;

    //定义小球纵向运行速度
    private int ySpeed = 10;
    //小球横向运行速度
    private int xSpeed = 5;

    //定义小球的初始坐标
    private int ballX = 120;
    private int ballY = 20;

    //定义球拍的初始坐标，x坐标会发生变化，y坐标不会发生变化
    private int rackeX = 120;
    private final int rackeY = 360;

    //声明定时器
    private Timer timer;

    //定义一个标记，判断游戏是否结束
    private boolean islose = false;
    //定义一个标记判断游戏是否暂停
    private boolean isstop = true;

    //声明一个桌面
    private MyCanvas table = new MyCanvas();


    /*
        组装区域----------------------------------
    */
    private void init() {
        //实现各按钮的功能
        //开始按钮，使程序继续运行
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isstop = false;
            }
        });
        //暂停按钮，使程序暂停
        stop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isstop = true;
            }
        });
        //退出按钮，结束整个程序
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        //重新开始按钮，使程序重新运行
        agin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                islose = false;
                isstop = true;
                timer.start();
                ballX = 120;
                ballY = 20;
                rackeX = 120;

                //生成两个随机数，重置x，y的速度
                Random r = new Random();
                float vx = r.nextFloat();
                int x = vx > 0.5 ? r.nextInt(5) + 5 : -(r.nextInt(5) + 5);
                float vy = r.nextFloat();
                int y = vy > 0.5 ? r.nextInt(5) + 5 : -(r.nextInt(5) + 5);
                xSpeed = x;
                ySpeed = y;
            }
        });


        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                Random r = new Random();
                if (command.equals("一档速度")) {
                    float v1 = r.nextFloat();
                    int x = v1 > 0.5 ? r.nextInt(5) + 5 : -(r.nextInt(5) + 5);
                    float v2 = r.nextFloat();
                    int y = v2 > 0.5 ? r.nextInt(5) + 5 : -(r.nextInt(5) + 5);
                    xSpeed = x;
                    ySpeed = y;
                } else if (command.equals("二档速度")) {
                    float v1 = r.nextFloat();
                    int x = v1 > 0.5 ? r.nextInt(10) + 10 : -(r.nextInt(10) + 10);
                    float v2 = r.nextFloat();
                    int y = v2 > 0.5 ? r.nextInt(10) + 10 : -(r.nextInt(10) + 10);
                    xSpeed = x;
                    ySpeed = y;
                }
            }
        };

        one.addActionListener(listener);
        two.addActionListener(listener);

        //设置速度调节栏
        speed.add(one);
        speed.add(two);

        //组装菜单栏
        menuBar.add(speed);

        //将菜单栏添加到frame
        frame.setMenuBar(menuBar);

        //将按钮添加到状态栏
        p.add(start);
        p.add(stop);
        p.add(exit);
        p.add(agin);

        //设置桌面区域的最佳大小
        table.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        //把桌面和panel添加到frame中
        frame.add(p, BorderLayout.NORTH);
        frame.add(table);

        //定义键盘监听器
        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //监听键盘 ←  → 按下操作，当指定的键按下时，球拍的水平坐标分别会增加或者减少
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {
                    if (rackeX > 0) {
                        rackeX -= 20;
                    }
                }

                if (keyCode == KeyEvent.VK_RIGHT) {
                    if (rackeX < TABLE_WIDTH - RACKET_WIDTH) {
                        rackeX += 20;
                    }
                }
            }
        };

        //为窗口和table分别添加键盘事件,保证能够监听到
        frame.addKeyListener(keyListener);
        table.addKeyListener(keyListener);

        //定义ActionListener，用来监听小球的变化情况
        ActionListener timerTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //判断是否为暂停状态
                if (isstop) {
                    table.repaint();
                } else {
                    //小球碰到左右边框
                    if (ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE) {
                        xSpeed = -xSpeed;
                    }

                    //小球的高度超出了球拍的位置，且横向不在球拍范围内，则游戏结束
                    if (ballY > rackeY && (ballX < rackeX || ballX > rackeX + RACKET_WIDTH)) {
                        //结束定时器
                        timer.stop();
                        //把游戏结束的标记设置为true
                        islose = true;
                        //重绘界面
                        table.repaint();
                    }

                    //如果小球横向在球拍范围内，且到达球拍位置或者到达顶端位置，则小球反弹
                    if (ballY <= 0 || (ballY >= rackeY - BALL_SIZE && ballX >= rackeX && ballX <= rackeX + RACKET_WIDTH)) {
                        ySpeed = -ySpeed;
                    }

                    //更新小球的坐标
                    ballX += xSpeed;
                    ballY += ySpeed;

                    //重绘桌面
                    table.repaint();
                }
            }
        };

        //设置定时器，定时任务就是timerTask
        timer = new Timer(100, timerTask);
        timer.start();

        //当点击窗口X的时候会退出
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //设置frame最佳大小，并可视
        frame.pack();
        frame.setVisible(true);
    }

    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //判断游戏是否结束
            if (islose) {
                g.setColor(Color.BLUE);
                g.setFont(new Font("Times", Font.BOLD, 30));
                g.drawString("游戏结束!", 50, 200);

            } else {
                //设置颜色并绘制小球
                g.setColor(Color.RED);
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

                //设置颜色并绘制球拍
                g.setColor(Color.PINK);
                g.fillRect(rackeX, rackeY, RACKET_WIDTH, RACKET_HEIGHT);
            }
        }
    }

    public static void main(String[] args) {
        new mygame1().init();
    }

}
