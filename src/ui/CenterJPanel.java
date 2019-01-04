package ui;

import dto.Dto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CenterJPanel extends JPanel {
    private Dto dto;
    public CenterJPanel(Dto dto) {
        this.setLayout(new BorderLayout());
        this.dto=dto;
        this.setPreferredSize(new Dimension(794,610));
        JLabel jLabel1 = new JLabel("成绩单");
        JLabel jLabel2 = new JLabel("数据分析");
        add(jLabel1);
        add(jLabel2);
        jLabel1.setBounds(10, 8,90 ,25 );
        jLabel2.setBounds(400, 8,90 ,25 );
        JPanel leftJP =setJP(5, 30, 380, 570);
        JPanel rightJP =setJP(400, 30, 385, 570);
        this.setBorder(BorderFactory.createRaisedBevelBorder());




        add(leftJP);
        add(rightJP);


    }
    private JPanel setJP(int x,int y,int width,int height){
        JPanel jPanel = new JPanel();
        jPanel.setBounds(x, y, width, height);
        jPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        return jPanel;
    }




}
