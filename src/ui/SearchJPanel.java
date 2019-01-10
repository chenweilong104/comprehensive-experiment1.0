package ui;

import dto.Dto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * 搜索面板
 */
class SearchJPanel extends JPanel {

     SearchJPanel(Dto dto) {

        this.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        //搜索框
        JTextField text =new JTextField(15);
        text.addActionListener((e)->{
            String string = e.getActionCommand();
            if(dto.getFileService().getFile()!=null){
                Object[][] objects=dto.getDateService().searchStudent(string);
                System.out.println(string);
                if(objects!=null) {
                    createSearchDialog(objects);
                }else JOptionPane.showMessageDialog(null,
                        "找不到您所搜索的信息","警告",JOptionPane.WARNING_MESSAGE);
            }else JOptionPane.showMessageDialog(null,
                    "请先打开文件","警告",JOptionPane.WARNING_MESSAGE);
        });
        this.add(text);
        JLabel jLabel = new JLabel("输入学号或姓名可以自动查询，输入回车确定");
        jLabel.setForeground(Color.red);
        this.add(jLabel);
    }
    private void createSearchDialog(Object[][] objects){
        JDialog jDialog = new JDialog();
        String[] n = {"学号", "姓名", "成绩"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(objects, n);
        JTable jTable = new JTable(defaultTableModel);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        MyJFrame.atCenter(jDialog, 400, 400);
        jDialog.add(jScrollPane);
        jDialog.setVisible(true);
    }

}
