package ui;

import dto.Dto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LeftJPanel extends JPanel {

    private Dto dto;
    public LeftJPanel(Dto dto) {
        this.dto=dto;
        this.setLayout(new BorderLayout(10,10));
        JLabel jLabel1 = new JLabel("成绩单");
        this.add("North",jLabel1);
        JScrollPane jScrollPane= this.setJT();
        this.add(jScrollPane);

    }
    private  JScrollPane setJT(){
        String[] n = { "学号", "姓名", "成绩"};
        String[][] s;
        s=new String[40][3];


        DefaultTableModel defaultTableModel = new DefaultTableModel(s,n);

        JTable jTable = new JTable(defaultTableModel){
            public boolean isCellEditable(int row, int column)
            {
                return false;}//表格不允许被编辑
        };
        dto.setjTable(jTable);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setPreferredSize(new Dimension(350,540));
        return jScrollPane;

    }
}
