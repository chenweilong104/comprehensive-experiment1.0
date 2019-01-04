package ui;

import cfg.Cfg;
import dto.Dto;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {

    private int WINDOW_WIDTH = Cfg.getWindowWidth();
    private int WINDOW_HEIGHT = Cfg.getWindowHeight();
    public MyJFrame(Dto dto){
        this.setTitle("成绩分析程序");
        //设置默认关闭属性（程序结束）
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //居中
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //不允许用户改变窗口大小
        //this.setResizable(false);
        Dimension screen = toolkit.getScreenSize();
        int x = screen.width- WINDOW_WIDTH>> 1;
        int y = screen.height-WINDOW_HEIGHT >> 1 ;
        this.setLocation(x,y);
        //设置窗口大小
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        //新建菜单
        Menu menu = new Menu(dto);
        //插入菜单栏
        menu.setBounds(30,32,800,10);
        setJMenuBar(menu);
        this.setLayout(new BorderLayout());
        //设置默认Panel
        this.setContentPane(dto.getMyJPanel());
        this.setVisible(true);
        add("North",new SearchJPanel());
        add("West", new LeftJPanel(dto));
        add("South", new StatusBarJPanel());
    }
}
