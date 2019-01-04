package ui;

import dto.Dto;

import javax.swing.*;
import java.awt.*;


public class MyJPanel extends JPanel {
    private Dto dto;
    public MyJPanel(Dto dto) {
        this.dto=dto;
        dto.setMyJPanel(this);
        this.setLayout(new BorderLayout(10,10));
        //初始化组件
        initComponent();



    }

    private void initComponent() {

        add("North",new SearchJPanel());
        add("West", new LeftJPanel(dto));
        add("South", new StatusBarJPanel());
    }

}
