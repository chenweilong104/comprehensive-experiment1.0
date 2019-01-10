package ui;

import dto.Dto;

import javax.swing.*;
import java.awt.*;

/**
 * 在窗口下方显示文件路径与文件名与人数的面板
 */
class StatusBarJPanel extends JPanel {
     StatusBarJPanel(Dto dto) {
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        this.setLayout(new BorderLayout());
        add("North",new JLabel("  " ));
        add("South",new JLabel("  "));
        add("East",new JLabel("    "));
        add("West",new JLabel("    "));
        JLabel jLabel = new JLabel();
        jLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jLabel.setPreferredSize(new Dimension(780,36));
        jLabel.setBorder(BorderFactory.createEtchedBorder());
        jLabel.setFont(new Font("宋体", Font.PLAIN,12));
        dto.setPathAndNameOfFileOfJLabel(jLabel);
        add(jLabel);
    }
}
