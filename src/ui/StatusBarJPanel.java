package ui;

import javax.swing.*;
import java.awt.*;

public class StatusBarJPanel extends JPanel {
    public StatusBarJPanel() {

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel.setPreferredSize(new Dimension(780,36));
        jPanel.setBorder(BorderFactory.createEtchedBorder());
        add(jPanel);
    }
}
