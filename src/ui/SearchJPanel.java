package ui;

import javax.swing.*;
import java.awt.*;

public class SearchJPanel extends JPanel {

    public SearchJPanel() {

        this.setPreferredSize(new Dimension(794,36));
        this.setLayout(new FlowLayout(0));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        //搜索框
        JTextField text =new JTextField(15);
        this.add(text);

        JLabel jLabel = new JLabel("输入学号或姓名或成绩可以自动查询，输入回车确定");
        jLabel.setForeground(Color.red);
        this.add(jLabel);

    }


}
