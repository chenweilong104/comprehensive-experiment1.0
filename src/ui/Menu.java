package ui;

import control.MenuControl;
import dto.Dto;
import service.MenuAction;

import javax.swing.*;
import java.util.jar.JarEntry;

public class Menu extends JMenuBar{
    public Menu(Dto dto) {

        JMenu jMenu = new JMenu("文件");
        dto.setjMenu(jMenu);
        String n[] = {"打开文本文件成绩单","另存为文本文件成绩单","打开二进制对象文件成绩单","另存为二进制对象文件成绩单","清除数据"};
        JMenuItem[] jMenuItems= new JMenuItem[n.length];
        for(int i =0; i< n.length;i++) {
            jMenuItems[i] = new JMenuItem(n[i]);
            if(i==2||i==4) jMenu.addSeparator();
            jMenu.add(jMenuItems[i]);
            //jMenuItems[i].addActionListener(new MenuAction());
        }new MenuControl(dto);

        this.add(jMenu);
    }
}
