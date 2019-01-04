package service;

import dto.Dto;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private Dto dto;
    /**
     * 成绩单
     */
    private static String[][] strings;
    public FileService(Dto dto) {
        this.dto = dto;
    }

    public static void opentxtFile(Dto dto){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "文本文件", "txt");
        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        dto.setFile(file);
    }

    public static void importFile(Dto dto) {
        File file=dto.getFile();
        FileReader in;
        List<String[]> a =new ArrayList<String[]>();

        try{

            in = new FileReader(file);
            BufferedReader b = new BufferedReader(in);

            String s =null;
            String[] s1=null;
            while((s=b.readLine())!=null){
                s1=s.split(",");
                a.add(s1);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        strings=initString(a);
        dto.setStrings(strings);
        String[] n = { "学号", "姓名", "成绩"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(strings,n);

        dto.getjTable().setModel(defaultTableModel);
    }

    /**
     * 把集合转化为二维数组
     * @param list
     * @return
     */
    public static String[][] initString(List list){
        Object[] s = (Object[])list.toArray();
        String[][] aa = new String[s.length][];
        int j=0;
        for(int i=0;i<s.length;i++){
            aa[i] = (String[])s[i];
        }
        return aa;
    }

}
