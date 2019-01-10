package ui;

import dto.Dto;
import javax.swing.*;
import java.awt.*;

/**
 * 程序的主要显示部分，内含成绩单和数据分析
 */
class CenterJPanel extends JPanel {
    CenterJPanel(Dto dto) {
        this.setLayout(new GridLayout(1,2));
        this.add(new LeftJPanel(dto));
        this.add(new RightJPanel(dto));
    }

}
