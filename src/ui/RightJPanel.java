package ui;

import dto.Dto;

import javax.swing.*;
import java.awt.*;

/**
 * 成绩分析面板
 */
class RightJPanel extends JPanel {
    private Dto dto;
    private Font font = new Font("宋体", Font.PLAIN, 16);
    private JLabel[] jPoint =new JLabel[]{
            new JLabel("   最高分"),
            new JLabel("   最低分"),
            new JLabel("   平均分"),
    };
    private JLabel[] jPointPeople =new JLabel[]{
            new JLabel(" 优秀(100-90)   "),
            new JLabel(" 良好(90-80)    "),
            new JLabel(" 中等(80-70)    "),
            new JLabel(" 及格(70-60)    "),
            new JLabel(" 不及格(60以下)")

    };
    //最高分,最低分,平均分后面的空白标签
    private String blank="                    ";
    private JLabel[] jLabel =new JLabel[]{
            new JLabel(blank),
            new JLabel(blank),
            new JLabel(blank)
    };
    //统计人数的标签
    private JLabel[] people=new JLabel[]{
            new JLabel(blank),
            new JLabel(blank),
            new JLabel(blank),
            new JLabel(blank),
            new JLabel(blank)
    };
    //百分比的标签
    private JLabel[] percent =new JLabel[]{
            new JLabel("         "),
            new JLabel("         "),
            new JLabel("         "),
            new JLabel("         "),
            new JLabel("         ")
    };
    RightJPanel(Dto dto) {
        this.dto=dto;
        this.setLayout(new BorderLayout(5,5));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        JLabel jLabel1 = new JLabel("   数据分析");
        this.add("West",new JPanel());
        this.add("East",new JPanel());
        this.add("South",new JPanel());
        this.add("North",jLabel1);
        this.add("Center",dateAnalysis());
    }
    private Box dateAnalysis(){
        this.dto.setjPoint(jLabel);
        this.dto.setPeople(people);
        this.dto.setPrecent(percent);

        //显示最高分,最低分,平均分的三个小箱子
        Box[] smallBoxesOf1 = new Box[3];
        for (int i =0;i<3;i++) {
            Component strut=Box.createHorizontalStrut(112);
            smallBoxesOf1[i] = createSmallBox(jPoint[i], jLabel[i], strut);
        }

        //显示不同分数段人数的五个小箱子
        Box[] smallBoxesOf2 = new Box[5];
        for(int i=0;i<5;i++){
            JLabel j1=new JLabel(" 人,占 ");j1.setFont(font);
            JLabel j2=setBlankJLabel(percent[i]);
            JLabel j3=new JLabel(" %");j3.setFont(font);
            smallBoxesOf2[i]= createSmallBox(jPointPeople[i],people[i],j1,j2,j3);
        }

        Box mediumBox1 =createMediumBox(smallBoxesOf1);
        Box mediumBox2 =createMediumBox(smallBoxesOf2);
        Box bigBox=createBigBox(mediumBox1,mediumBox2);

       return bigBox;
    }
    private Box createBigBox(Box... mediumBoxes){
        Box bigBox = Box.createVerticalBox();
        bigBox.setBorder(BorderFactory.createLoweredBevelBorder());
        for(Box mBox:mediumBoxes) bigBox.add(mBox);
        return bigBox;
    }
    private Box createMediumBox(Box... smallBoxes){
        Box box =Box.createVerticalBox();
        for(Box b :smallBoxes){
            box.add(Box.createVerticalGlue());
            box.add(b);
        }
        box.add(Box.createVerticalGlue());
        return box;
    }

    private Box createSmallBox(JLabel jL,JLabel jL1,Component... xs){
        Box box;
        box=Box.createHorizontalBox();
        box.add(jL);
        jL.setFont(font);
        box.add(Box.createHorizontalGlue());
        JLabel jLabel=setBlankJLabel(jL1);
        box.add(jLabel);
        for(Component x:xs){
            box.add(x);
        }
        return box;
    }

    //设置空白标签
    private JLabel setBlankJLabel(JLabel jL){
        jL.setBorder(BorderFactory.createEtchedBorder());
        jL.setOpaque(true);
        jL.setBackground(Color.WHITE);
        return jL;
    }
}

