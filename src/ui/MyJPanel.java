package ui;

import dto.Dto;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MyJPanel extends JPanel {
    public MyJPanel(Dto dto) {
        this.setLayout(null);
        //初始化组件
        initComponent();



    }

    private void initComponent() {
        JTextField text =new JTextField(15);
        this.add(text);
        JLabel jLabel = new JLabel("输入学号或姓名或成绩可以自动查询，输入回车确定");
        jLabel.setForeground(Color.red);
        this.add(jLabel);
        //text.setBounds();

    }
}
