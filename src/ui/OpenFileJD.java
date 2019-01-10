package ui;

import dto.Dto;

import service.FileService;
import javax.swing.*;
import java.awt.*;

/**
 * 打开文件时所显示的窗体
 */
public class OpenFileJD extends JDialog{
    private Dto dto;
    private Font font = new Font("宋体", Font.PLAIN, 16);
    private JTextField jtOfClassName,jtOfLessonName;
    private int flag;
    public OpenFileJD(Dto dto,int flag) {
        this.flag=flag;
        this.dto=dto;
        initBase();
        JPanel centerJPanel = createCenterJPanel();
        JPanel southJPanel=createSouthJPanel();
        add("Center",centerJPanel);
        add("South",southJPanel);
        add("North",new JLabel("  " ));
        add("East",new JLabel("          "));
        add("West",new JLabel("          "));
        this.setVisible(true);

    }
    private void initBase(){
        setModal(true);
        this.setTitle("打开文件");
        setLocationRelativeTo(null);
        //设置默认关闭属性
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //不允许用户改变窗口大小
        this.setResizable(false);
        //居中
        final int WINDOW_WIDTH = 400;
        final int WINDOW_HEIGHT = 300;
        MyJFrame.atCenter(this, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
    private JPanel createCenterJPanel(){
        JPanel jp = new JPanel(new GridLayout(0,2,30,30));
        JLabel jl1 = new JLabel("班级名称:");
        jl1.setFont(font);
        JTextField jtOfClassName = new JTextField(8);
        this.jtOfClassName =jtOfClassName;
        JLabel jl2 = new JLabel("课程名称:");
        jl2.setFont(font);
        JTextField jtOfLessonName = new JTextField(8);
        this.jtOfLessonName=jtOfLessonName;
        jp.add(jl1);
        jp.add(jtOfClassName);
        jp.add(jl2);
        jp.add(jtOfLessonName);
        JButton jbY = new JButton("确认");
        jbY.setFont(font);
        jbY.addActionListener((v)->jbYAction());
        JButton jbN = new JButton("取消");
        jbN.setFont(font);
        jbN.addActionListener((v)->this.dispose());
        jp.add(jbY);
        jp.add(jbN);
        return jp;
    }
    private JPanel createSouthJPanel(){
        JPanel southJPanel = new JPanel();
        southJPanel.setPreferredSize(new Dimension(400,80));
        JButton jbPath=new JButton("通过路径打开");jbPath.setFont(new Font("宋体",Font.PLAIN,12));
        southJPanel.setLayout(null);
        southJPanel.add(jbPath);
        jbPath.setBounds(280, 40, 115, 35);
        jbPath.addActionListener((l)-> dto.getFileService().openFileOfJFileChooser());
        return southJPanel;
    }

    /**
     * “确定”按钮的事件监听
     */
    private void jbYAction(){
        String className = this.jtOfClassName.getText();
        String lessonName = this.jtOfLessonName.getText();
        FileService fileService = dto.getFileService();
        fileService.setFlag(flag);
        if(!fileService.parseFile(className+"-"+lessonName)){
            JOptionPane.showMessageDialog(null,
                    "文件不存在","警告",JOptionPane.WARNING_MESSAGE);
        }
        else if(flag==FileService.TXT_FILE) {
            fileService.openTxtFile();
            JOptionPane.showMessageDialog(null,
                    "读取成功",null,JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }else if(flag==FileService.OBJECT_FILE){
            fileService.openObjectFile();
            JOptionPane.showMessageDialog(null,
                    "读取成功",null,JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }
}
