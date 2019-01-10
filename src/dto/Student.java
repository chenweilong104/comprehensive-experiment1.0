package dto;

import java.io.Serializable;

public class Student implements Serializable {

    private String number;
    private String name;
    private int point;

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public Student(String number, String name, int point) {
        this.number = number;
        this.name = name;
        this.point=point;
    }

    public Object[] toObjects(){
        Object[] s=new Object[3];
        s[0]=this.number;
        s[1]=this.name;
        s[2]=this.point;
        return s;
    }
    public String toString(){
        return number+","+name+","+point+"\n";
    }
}
