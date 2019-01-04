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
        new MyJPanel(dto);

        //创建窗口
        MyJFrame myJFrame=new MyJFrame(dto);
//        System.out.println("gao"+myJPanel.size().getHeight());
//        System.out.println("long"+myJPanel.size().getWidth());
    }
}
