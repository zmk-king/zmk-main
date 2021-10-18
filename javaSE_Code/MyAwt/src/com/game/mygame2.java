package com.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class mygame2 {
    //定义五子棋游戏窗口
    JFrame frame = new JFrame("五子棋小游戏");

    //定义三个BufferedImage，分别代表棋盘图、黑子图、白子图
    private BufferedImage table;
    private BufferedImage black;
    private BufferedImage white;

    //定义一个BufferedImage，代表当鼠标移动时将要下子的选择框
    private BufferedImage selected;

    //定义棋盘的宽高，这里的定义尺寸和给定的board.jpg图片的尺寸一致因为棋盘背景是通过图片加载的
    private final int TABLE_WIDTH = 535;
    private final int TABLE_HEIGHT = 536;

    //定义棋盘中，每行和每列可下子的数目，这个数目跟给定的board.jpg中的数目是一致的，都为15
    private final int BOARD_SIZE = 15;

    //定义每个棋子所占棋盘总宽度的大小比率；每个棋子所占宽度 535/15=35
    private final int RATE = TABLE_WIDTH / BOARD_SIZE;

    //定义棋盘有效区域与背景图坐标之间的偏移值，x坐标右移5个像素，y坐标下移6个像素
    private final int X_OFFSET = 5;
    private final int Y_OFFSET = 6;

    /*
        定义一个二维数组充当棋盘上每个位置处的棋子；
        该数组的索引与该棋子在棋盘上的坐标需要有一个对应关系：
            例如： 索引[2][3]处的棋子，对一个的真实绘制坐标应该是：

                xpos = 2*RATE+X_OFFSET=75;
                ypos = 3*RATE+Y_OFFSET=111;
     */
    //如果存储0，代表没有棋子，如果存储1，代表黑棋，如果存储2，代表白棋
    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    //定义一个变量，记录当前用户选择下的是白棋还是黑棋还是清除，清除：0，黑棋：1，白棋：2；
    private int chess = 1;

    //定义一个变量判断是否开启自动下棋
    private boolean isauto = true;
    //定义一个变量记录是否为黑棋
    private boolean isblack = true;
    //定义一个变量判断游戏是否结束
    public String iswin = null;

    //定义变量，记录当前选中的坐标点对应的boad数组中对应的棋子索引；
    private int selectX = -1;
    private int selectY = -1;

    //定义Panel,放置点击按钮
    Panel p = new Panel();
    private Button autoBtn = new Button("自动");
    private Button whiteBtn = new Button("白棋");
    private Button blackBtn = new Button("黑棋");
    private Button clearBtn = new Button("悔棋");

    //定义五子棋游戏棋盘对应的Canvas组件
    //这里用JPanel代替，可以解决频闪的问题
    private class ChessBroad extends JPanel {
        @Override
        public void paint(Graphics g) {
            //绘制五子棋棋盘
            g.drawImage(table, 0, 0, null);

            //绘制选中点的红框
            if (selectX >= 0 && selectY >= 0) {
                g.drawImage(selected, selectX * RATE + X_OFFSET, selectY * RATE + Y_OFFSET, null);
            }

            //遍历数组，绘制棋子
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    //绘制黑棋
                    if (board[i][j] == 1) {
                        g.drawImage(black, i * RATE + X_OFFSET, j * RATE + Y_OFFSET, null);
                        //chess = 2;
                    }
                    //绘制白棋
                    if (board[i][j] == 2) {
                        g.drawImage(white, i * RATE + X_OFFSET, j * RATE + Y_OFFSET, null);
                        //chess = 1;
                    }
                }
            }

            //如果棋局已经分出胜负，弹出胜负结果
            if (iswin != null) {
                g.setColor(Color.BLUE);
                g.setFont(new Font("Times", Font.BOLD, 30));
                g.drawString("游戏结束，" + iswin, 50, 200);
            }
        }
    }

    //创建画布对象
    ChessBroad chessBroad = new ChessBroad();


    /*
    组装区域，主要操作实现部分
     */
    private void init() throws IOException {
        //初始化按钮的颜色
        updataColor(Color.GREEN, Color.lightGray, Color.LIGHT_GRAY);
        clearBtn.setBackground(Color.LIGHT_GRAY);

        //自动功能，黑棋先手，然后自动切换白棋，然后循坏
        autoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updataColor(Color.GREEN, Color.LIGHT_GRAY, Color.LIGHT_GRAY);
                isauto = true;
            }
        });

        //当三个按钮被点击时,按钮颜色改变，并改变棋子的状态
        whiteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //改变棋子状态
                chess = 2;
                //改变按钮颜色
                updataColor(Color.lightGray, Color.LIGHT_GRAY, Color.GREEN);
                //取消自动
                isauto = false;
            }
        });

        blackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chess = 1;
                updataColor(Color.lightGray, Color.GREEN, Color.LIGHT_GRAY);
                isauto = false;
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*chess = 0;
                updataColor(Color.lightGray, Color.LIGHT_GRAY, Color.GREEN);*/

               /* if (ui.counti>0){
                    int x = ui.ps[ui.counti-1].listx;
                    int y = ui.ps[ui.counti-1].listy;
                    board[x][y] = 0;
                    ui.counti--;
                    chessBroad.repaint();
                }*/
                clearBtn.setBackground(Color.GREEN);

                if (ui.chesslist.size() > 0) {
                    chessPosition cp = new chessPosition();
                    cp = ui.chesslist.remove(ui.chesslist.size() - 1);
                    board[cp.listx][cp.listy] = 0;
                    isblack = !isblack;
                    chessBroad.repaint();
                }
            }
        });

        //将按钮放入panel容器中，然后将panel放入Frame中
        p.add(autoBtn);
        p.add(blackBtn);
        p.add(whiteBtn);
        p.add(clearBtn);
        frame.add(p, BorderLayout.SOUTH);

        //初始化黑棋，白棋，棋盘,选中框
        table = ImageIO.read(new File("MyAwt\\board.jpg"));
        black = ImageIO.read(new File("MyAwt\\black.gif"));
        white = ImageIO.read(new File("MyAwt\\white.gif"));
        selected = ImageIO.read(new File("MyAwt\\selected.gif"));

        //初始化board数组，默认情况下，所有位置处都没有棋子
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = 0;
            }
        }

        //设置chessBoard的最佳大小
        chessBroad.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));

        //给chessBoard注册鼠标监听器
        chessBroad.addMouseListener(new MouseAdapter() {
            //鼠标单击会触发,获取鼠标当前位置对应的棋子的坐标，并绘制当前选择的棋子
            @Override
            public void mouseClicked(MouseEvent e) {
                //当开启自动下棋后，自动切换黑白棋

                if (isauto) {

                    int x_port = (e.getX() - X_OFFSET) / RATE;
                    int y_port = (e.getY() - Y_OFFSET) / RATE;

                    //自动切换棋子，一人下一棋
                    if (board[x_port][y_port] == 0) {
                        chess = isblack ? 1 : 2;
                        isblack = !isblack;
                        board[x_port][y_port] = chess;

                        //调用判断胜负的方法
                        iswin = chessWin(x_port, y_port);
                        //System.out.println(iswin);

                        chessBroad.repaint();

                       /* String win = chessWin(x_port, y_port);
                        if (win!=null){
                            chessBroad.repaint();
                        }*/

                       /* chessPosition p = new chessPosition();
                        ui.ps[ui.counti] = p;
                        ui.ps[ui.counti].listx = x_port;
                        ui.ps[ui.counti].listy = y_port;
                        ui.counti++;*/

                        ui.chesslist.add(new chessPosition(x_port, y_port));
                    }
                } else {
                        //将用户鼠标的坐标，转换成棋子的坐标
                        int x_port = (e.getX() - X_OFFSET) / RATE;
                        int y_port = (e.getY() - Y_OFFSET) / RATE;

                    if (board[x_port][y_port] == 0) {

                        board[x_port][y_port] = chess;

                        //在画布上重新绘制
                        chessBroad.repaint();

                        //调用判断胜负的方法
                        iswin = chessWin(x_port, y_port);

                    /*chessPosition p = new chessPosition();
                    ui.ps[ui.counti] = p;
                    ui.ps[ui.counti].listx = x_port;
                    ui.ps[ui.counti].listy = y_port;
                    ui.counti++;*/

                        ui.chesslist.add(new chessPosition(x_port, y_port));
                    }
                }
            }

            //当鼠标退出棋盘区域后，复位选中坐标,重绘chessBoard，要保证红色选中框显示正确
            @Override
            public void mouseExited(MouseEvent e) {
                //将选择框的坐标复位
                selectX = -1;
                selectY = -1;

                //重新绘制
                chessBroad.repaint();
            }
        });

        //注册鼠标移动监听器，当鼠标移动时，选择框随之变化
        chessBroad.addMouseMotionListener(new MouseMotionAdapter() {
            //当鼠标移动时，修正selectX和selectY，重绘chessBoard，要保证红色选中框显示正确
            @Override
            public void mouseMoved(MouseEvent e) {
                //将鼠标的坐标，转换成棋子的索引
                selectX = (e.getX() - X_OFFSET) / RATE;
                selectY = (e.getY() - Y_OFFSET) / RATE;

                //重新绘制
                chessBroad.repaint();
            }
        });


        //把chessBoard添加到Frame中
        frame.add(chessBroad);

        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }

    /*
        判定棋局胜负
     */
    public String chessWin(int x, int y) {
        StringBuilder sb = new StringBuilder();

        //判断水平方向
        for (int i = -4; i <= 4; i++) {
            int xx = x + i ;
            if (xx < 0 || xx > BOARD_SIZE)
                continue;
            sb.append(board[xx][y]);

            if (sb.indexOf("11111") != -1) {
                iswin = "黑棋胜!";
                return iswin;
            } else if (sb.indexOf("22222") != -1) {
                iswin = "白棋胜!";
                return iswin;
            }
        }

        //判断垂直方向
        sb.delete(0, sb.length());
        for (int i = -4; i <= 4; i++) {
            int yy = y + i;
            if (yy < 0 || yy > BOARD_SIZE)
                continue;
            sb.append(board[x][yy]);

            if (sb.indexOf("11111") != -1) {
                iswin = "黑棋胜!";
                return iswin;
            } else if (sb.indexOf("22222") != -1) {
                iswin = "白棋胜!";
                return iswin;
            }
        }

        //判断45°方向
        sb.delete(0, sb.length());
        for (int i = -4; i <= 4; i++) {
            int xx = x + i;
            int yy = y - i;
            if (xx < 0 || xx > BOARD_SIZE || yy < 0 || yy > BOARD_SIZE)
                continue;
            sb.append(board[xx][yy]);

            if (sb.indexOf("11111") != -1) {
                iswin = "黑棋胜!";
                return iswin;
            } else if (sb.indexOf("22222") != -1) {
                iswin = "白棋胜!";
                return iswin;
            }
        }

        //判断135°方向
        sb.delete(0, sb.length());
        for (int i = -4; i <= 4; i++) {
            int xx = x + i;
            int yy = y + i;
            if (xx < 0 || xx > BOARD_SIZE || yy < 0 || yy > BOARD_SIZE)
                continue;
            sb.append(board[xx][yy]);

            if (sb.indexOf("11111") != -1) {
                iswin = "黑棋胜!";
                return iswin;
            } else if (sb.indexOf("22222") != -1) {
                iswin = "白棋胜!";
                return iswin;
            }
        }

        //胜负未分
        return null;
    }

    /*
        1.对象数组方法
     *//*
    //定义一个坐标类，里面有x，y轴属性
    public class chessPosition {
        public int listx;
        public int listy;
    }
    //主页面获取一个对象数组，存储位置信息
    public class chessUI extends JPanel {
        public chessPosition[] ps = new chessPosition[500];
        //计数
        int counti;
    }*/

    /*
        2.集合方法,利用集合保存每次落子的坐标信息
     */
    public class chessPosition {
        public int listx;
        public int listy;

        public chessPosition() {
        }

        public chessPosition(int listx, int listy) {
            this.listx = listx;
            this.listy = listy;
        }
    }

    public class chessUI extends JPanel {
        public ArrayList<chessPosition> chesslist = new ArrayList<chessPosition>();
    }

    chessUI ui = new chessUI();

    //按钮颜色变化函数
    private void updataColor(Color autobtnColor, Color blackbtnColor, Color whitebtnColor) {
        autoBtn.setBackground(autobtnColor);
        blackBtn.setBackground(blackbtnColor);
        whiteBtn.setBackground(whitebtnColor);
    }

    /*
        主函数
     */
    public static void main(String[] args) throws IOException {
        new mygame2().init();
        System.out.println(535%15);
        System.out.println(535/15);
    }
}
