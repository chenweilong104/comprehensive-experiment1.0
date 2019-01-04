package main;

import dto.Dto;
import ui.Menu;
import ui.MyJFrame;
import ui.MyJPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Dto dto = new Dto();

        //创建面板
        MyJPanel myJPanel = new MyJPanel(dto);
        Menu menu = new Menu(dto);
        //插入菜单栏
        menu.setBounds(30,32,800,10);
        MyJFrame myJFrame=new MyJFrame(myJPanel);
        myJFrame.setJMenuBar(menu);
        //创建窗口


//        System.out.println("gao"+myJPanel.size().getHeight());
//        System.out.println("long"+myJPanel.size().getWidth());
    }
}
