package service;

import dto.Dto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAction implements ActionListener {

    Dto dto;
    public MenuAction(Dto dto) {
        this.dto =dto;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command= actionEvent.getActionCommand();
        switch (command){
            case "打开文本文件成绩单":
                FileService.opentxtFile(dto);
                FileService.importFile(dto);
                break;
            case "另存为文本文件成绩单":
                System.out.println(1111111111);
                break;
            case "打开二进制对象文件成绩单":
                break;
            case "另存为二进制对象文件成绩单":
                break;


        }
    }
}
