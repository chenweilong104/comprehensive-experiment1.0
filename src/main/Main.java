package main;

import dto.Dto;
import service.DateService;
import service.FileService;
import ui.MyJFrame;

public class Main {
    public static void main(String[] args) {

        Dto dto = new Dto();
        new FileService(dto);
        new DateService(dto);
        new MyJFrame(dto);
    }
}
