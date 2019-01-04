package ui;

import dto.Dto;

import javax.swing.*;
import java.awt.*;


public class MyJPanel extends JPanel {
    private Dto dto;
    public MyJPanel(Dto dto) {
        this.dto=dto;
        this.setLayout(new BorderLayout());
        //初始化组件
        initComponent();



    }

    private void initComponent() {

        add("North",new SearchJPanel());
        add("Center", new CenterJPanel(dto));
        add("South", new StatusBarJPanel());
    }

}
