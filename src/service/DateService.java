package service;

import dto.Dto;
import dto.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DateService {
    private Dto dto;
    private Student[] students;
    private int maxPoint;
    private int minPoint;
    private double averagePoint;
    /**
     * 不同分数段的人的数量
     */
    private int[] numberOfPeople;
    private double[] percent;

    public DateService(Dto dto) {
        this.dto = dto;
        this.dto.setDateService(this);
    }

    /**
     * 计算出成绩分析所需要的数据
     */
    void calculator(){
        this.maxPoint =students[0].getPoint();
        this.minPoint=students[0].getPoint();
        this.averagePoint=0.0;
        int[] numberOfPeople={0,0,0,0,0};
        this.numberOfPeople=numberOfPeople;
        double[] percent=new double[5];
        this.percent =percent;
        for (Student student : students) {
            int point=student.getPoint();
            averagePoint+=point;
            if (maxPoint < point) {
                maxPoint = point;
            }
            if (minPoint > point) {
                minPoint = point;
            }
            if(point>=90){
                this.numberOfPeople[0]++;
            }else if(point>=80){
                this.numberOfPeople[1]++;
            }else if(point>=70){
                this.numberOfPeople[2]++;
            }else if(point>=60){
                this.numberOfPeople[3]++;
            }else this.numberOfPeople[4]++;
        }
        this.averagePoint=averagePoint/students.length;
        for(int i=0;i<5;i++){
            percent[i]=numberOfPeople[i]/(double)students.length*100;
        }
    }

    /**
     * 加载成绩分析面板的数据
     */
    void reFresh(){
        JLabel[] jLabels=dto.getjPoint();
        jLabels[0].setText(String.format("%18d",this.maxPoint));
        jLabels[1].setText(String.format("%18d",this.minPoint));
        jLabels[2].setText(String.format("%16.2f",this.averagePoint));
        JLabel[] jPeople=dto.getPeople();
        JLabel[] jPercent=dto.getPrecent();
        for(int i=0;i<5;i++){
            jPeople[i].setText(String.format("                %02d",this.numberOfPeople[i]));
            if(this.percent[i]<10){
                jPercent[i].setText(String.format("%7.2f",this.percent[i]));
            }else
                jPercent[i].setText(String.format("%6.2f",this.percent[i]));

        }
    }

    /**
     * 把符合条件的学生找出，转化为二维Object数组
     * @param string 用于搜索的关键字
     * @return 返回二维Object数组
     */
    public Object[][] searchStudent(String string){
        List<Student> studentList=new ArrayList<>();
        for(Student student:this.students){
            if(student.getNumber().contains(string)||student.getName().contains(string)){
                studentList.add(student);
            }
        }
        if(!studentList.isEmpty()){
            Student[] st = studentList.toArray(new Student[0]);
            return toObjects(st);
        }
        return null;
    }

    /**
     * 把学生数组对象转化为二维数组，用于创造表格
     * @param students 学生数组对象
     * @return 二维Object数组
     */
    static Object[][] toObjects(Student[] students){
        Object[][] objects = new Object[students.length][];
        for(int i=0;i<students.length;i++) objects[i] = students[i].toObjects();
        return objects;
    }

    void setStudents(Student[] students) {
        this.students = students;
    }

    Student[] getStudents() {
        return students;
    }

}
