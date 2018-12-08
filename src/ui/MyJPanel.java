package ui;

import dto.Dto;

import javax.swing.*;
import java.awt.*;


public class MyJPanel extends JPanel {
    public MyJPanel(Dto dto) {
        this.setLayout(new FlowLayout(0,1,0));
        //初始化组件
        initComponent();



    }

    private void initComponent() {

        add(new SearchJPanel());
        add(new CenterJP());
    }

}
