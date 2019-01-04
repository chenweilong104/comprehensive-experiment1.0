package dto;

import ui.MyJPanel;

import javax.swing.*;
import java.io.File;

public class Dto {
    /**
     * 菜单
     */
    private JMenu jMenu;

    /**
     * 文件
     */
    private File file;

    /**
     * 数据
     */
    private String[][] strings;

    /**
     * 底层画布
     */
    private MyJPanel myJPanel;

    public MyJPanel getMyJPanel() {
        return myJPanel;
    }

    public void setMyJPanel(MyJPanel myJPanel) {
        this.myJPanel = myJPanel;
    }

    private JTable jTable;

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }


    public String[][] getStrings() {
        return strings;
    }

    public void setStrings(String[][] strings) {
        this.strings = strings;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public JMenu getjMenu() {
        return jMenu;
    }

    public void setjMenu(JMenu jMenu) {
        this.jMenu = jMenu;
    }

    public Dto() {
        dtoInit();
    }

    private void dtoInit() {
        this.strings=null;
    }
}
