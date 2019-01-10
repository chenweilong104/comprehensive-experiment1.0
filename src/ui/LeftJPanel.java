package ui;

import dto.Dto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * 成绩单
 */
class LeftJPanel extends JPanel {

    private Dto dto;

    LeftJPanel(Dto dto) {
        this.dto=dto;
        this.setLayout(new BorderLayout(5,5));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        JLabel jLabel1 = new JLabel("   成绩单");
        this.add("West",new JPanel());
        this.add("East",new JPanel());
        this.add("North",jLabel1);
        this.add("Center",this.createJTable());
        this.add("South",new JPanel());

    }

    /**
     * 创建一个空白成绩单
     * @return 返回含空白成绩单的JPanel面板
     */
    private JPanel createJTable(){
        JPanel jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        jPanel.setLayout(new BorderLayout(3,3));
        String[] n = { "学号", "姓名", "成绩"};
        String[][] s=new String[40][3];
        DefaultTableModel defaultTableModel = new DefaultTableModel(s,n);
        JTable jTable = new JTable(defaultTableModel){
            public boolean isCellEditable(int row, int column)
            {
                return false;}//表格不允许被编辑
        };
        dto.setjTable(jTable);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jPanel.add("Center",jScrollPane);
        //填充边界
        jPanel.add("West",new JPanel());
        jPanel.add("East",new JPanel());
        jPanel.add("North",new JPanel());
        jPanel.add("South",new JPanel());
        return jPanel;

    }
}
