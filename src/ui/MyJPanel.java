package ui;

import dto.Dto;

import javax.swing.*;
import java.awt.*;


public class MyJPanel extends JPanel {
    private Dto dto;
    public MyJPanel(Dto dto) {
        this.dto=dto;
        this.setLayout(new FlowLayout(0,1,1));
        //初始化组件
        initComponent();



    }

    private void initComponent() {

        add(new SearchJPanel());
        add(new CenterJPanel(dto));
        add(new StatusBarJPanel());
    }

}
