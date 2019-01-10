package service;

import dto.Dto;
import ui.OpenFileJD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 菜单条的监听器
 */
public class MenuAction implements ActionListener {

    private Dto dto;
    public MenuAction(Dto dto) {
        this.dto =dto;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command= actionEvent.getActionCommand();
        switch (command){
            case "打开文本文件成绩单":
                new OpenFileJD(dto,FileService.TXT_FILE);
                break;
            case "另存为文本文件成绩单":
                dto.getFileService().saveAsTxt();
                break;
            case "打开二进制对象文件成绩单":
                new OpenFileJD(dto, FileService.OBJECT_FILE);
                break;
            case "另存为二进制对象文件成绩单":
                dto.getFileService().saveAsObject();
                break;
            case "退出":System.exit(0);

        }
    }
}
