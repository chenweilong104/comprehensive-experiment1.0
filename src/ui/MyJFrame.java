package ui;

import dto.Dto;

import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {


    public MyJFrame(Dto dto){
        final int WINDOW_WIDTH = 857;
        final int WINDOW_HEIGHT = 750;
        this.setTitle("成绩分析程序");
        //设置默认关闭属性（程序结束）
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置居中，窗体大小
        atCenter(this,WINDOW_WIDTH, WINDOW_HEIGHT);
        //新建菜单
        Menu menu = new Menu(dto);
        //插入菜单栏
        menu.setBounds(30,32,800,10);
        setJMenuBar(menu);
        this.setLayout(new BorderLayout());
        //设置默认Panel

        add("North",new SearchJPanel(dto));
        add("Center", new CenterJPanel(dto));
        add("South", new StatusBarJPanel(dto));
        this.setVisible(true);
    }

    /**
     *
     * @param window 窗体
     * @param width 窗体的长
     * @param height 窗体的宽
     */
    static void atCenter(Window window,int width,int height){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = screen.width- width>> 1;
        int y = screen.height-height >> 1 ;
        window.setLocation(x,y);
        window.setSize(width,height);
    }
}
