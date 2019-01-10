package service;

import dto.Dto;
import dto.Student;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public static final int TXT_FILE=4;
    public static final int OBJECT_FILE=6;
    private Dto dto;
    /**
     * 文件
     */
    private File file;
    /**
     * 文件类型
     */
    private int flag;


    public FileService(Dto dto) {
        this.dto = dto;
        dto.setFileService(this);
    }

    /**
     * 从字符串中获取文件对象
     * @param classAndLessonName 成绩单的名字
     * @return 是否存在文件
     */
    public boolean parseFile(String classAndLessonName){
        if(flag==TXT_FILE){
            String fileName="Date/"+classAndLessonName+".txt";
            File file=new File(fileName);
            if(file.exists()){
                this.file=file;
                return true;
            }
        }
        else if(flag == OBJECT_FILE){
            String fileName="Date/"+classAndLessonName+".score";
            File file=new File(fileName);
            if(file.exists()){
                this.file=file;
                return true;
            }
        }
        return false;
    }

    /**
     * 打开txt文件
     */
    public void openTxtFile(){
        if(file!=null){
            readTxtFileToStudent();
            initStudents();
        }
    }
    /**
     * 打开二进制对象文件
     */
    public void openObjectFile(){
        if(file!=null) {
            ObjectInputStream ois = null;
            Student[] students = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
                students = (Student[]) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    assert ois != null;
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            dto.getDateService().setStudents(students);
            initStudents();
        }
    }

    /**
     * 把学生的成绩信息显示在窗口上
     */
    private void initStudents() {
        DateService dateService=dto.getDateService();
        Object[][] objects=DateService.toObjects(dateService.getStudents());
        String[] n = { "学号", "姓名", "成绩"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(objects,n);
        dto.getjTable().setModel(defaultTableModel);
        String string=file.getAbsolutePath();
        dto.getPathAndNameOfFileOfJLabel().setText(string+"_共"+ objects.length+"人");
        DateService date=dto.getDateService();
        if(date.getStudents().length!=0){
            date.calculator();
            date.reFresh();
        }
    }

    /**
     * 从txt文件中读取学生成绩信息，加载成绩信息到DateService
     */
    private void readTxtFileToStudent(){
        FileReader in;
        List<Student> a = new ArrayList<>();
        try{
            in = new FileReader(file);
            BufferedReader b = new BufferedReader(in);
            String s ;
            String[] s1;
            while((s=b.readLine())!=null){
                s1=s.split(",");
                Student student=new Student(s1[0],s1[1],Integer.valueOf(s1[2]));
                a.add(student);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        a.sort((o1, o2) -> {
            if (o1.getPoint() > o2.getPoint()) return -1;
            else if (o1.getPoint() < o2.getPoint()) return 1;
            else return o1.getNumber().compareTo(o2.getNumber());
        });
        Student[] students =a.toArray(new Student[0]);
        dto.getDateService().setStudents(students);
    }

    /**
     * 把学生成绩信息保存为二进制对象文件
     */
    void saveAsObject(){
        ObjectOutputStream oos=null;
        Student[] students = dto.getDateService().getStudents();
        File s=save(".score");
        if(isSave(s)) return;
        if(students!=null) try {
            oos = new ObjectOutputStream(new FileOutputStream(s));
            oos.writeObject(students);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert oos != null;
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        createMessage(s);
    }
    /**
     * 把学生成绩信息保存为txt文件
     */
    void saveAsTxt(){
        FileWriter out=null;
        Student[] students = dto.getDateService().getStudents();
        File s=save(".txt");
        if(isSave(s)) return;
        try {
            out = new FileWriter(s);
            for (Student student : students) {
                out.write(student.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        createMessage(s);
    }

    /**
     * 创建文件名
     * @param fileEndWith 要创建的文件类型
     * @return 文件
     */
    private File save(String fileEndWith){
        new File("Date").mkdir();
        String fileName = this.file.getName();
        fileName = fileName.substring(0, fileName.length() - flag);
        return new File("Date/" + fileName + fileEndWith);
    }

    /**
     * 弹出含有文件保存路径的提示框
     * @param f 要保存的文件
     */
    private void createMessage(File f){
        String message="保存路径："+f.getAbsolutePath();
        JOptionPane.showMessageDialog(null,
                message,"保存成功",JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 当发现存在同名文件弹出确认对话框
     * @param s 要保存的文件
     * @return 是否保存
     */
    private boolean isSave(File s){
        if(s.exists()){
            String message= "文件已存在，是否覆盖？";
            int yesOrNo=JOptionPane.showConfirmDialog(null, message);
            return yesOrNo != JOptionPane.YES_OPTION;
        }return false;
    }

    /**
     * 点击“通过路径打开”按钮时弹出文件选择框
     */
    public void openFileOfJFileChooser(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "文本文件", "txt");
        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        if(file!=null){
            this.file =file;
            if(file.toString().endsWith(".txt")){
                this.flag=TXT_FILE;
                openTxtFile();
            }
            else {
                this.flag=OBJECT_FILE;
                openObjectFile();
            }
        }
    }
    public File getFile() {
        return file;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
