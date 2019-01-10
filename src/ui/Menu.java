package ui;


import dto.Dto;
import service.MenuAction;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * 菜单栏
 */
class Menu extends JMenuBar{
    Menu(Dto dto) {

        JMenu jMenu = new JMenu("文件");
        String[] n;
        n = new String[]{"打开文本文件成绩单","另存为文本文件成绩单","打开二进制对象文件成绩单","另存为二进制对象文件成绩单","退出"};
        JMenuItem[] jMenuItems= new JMenuItem[n.length];
        ActionListener actionListener=new MenuAction(dto);
        for(int i =0; i< n.length;i++) {
            jMenuItems[i] = new JMenuItem(n[i]);
            if(i==2||i==4) jMenu.addSeparator();
            jMenu.add(jMenuItems[i]);

            jMenuItems[i].addActionListener(actionListener);
        }
        this.add(jMenu);
    }
}
