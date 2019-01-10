package dto;

import service.DateService;
import service.FileService;

import javax.swing.*;
import java.io.File;

public class Dto {

    private FileService fileService;

    private DateService dateService;

    /**
     * 下方的文件路径与文件名
     */
    private JLabel PathAndNameOfFileOfJLabel;


    private JLabel[] jPoint;
    private JLabel[] people;
    private JLabel[] precent;



    public DateService getDateService() {
        return dateService;
    }

    public void setDateService(DateService dateService) {
        this.dateService = dateService;
    }

    public JLabel getPathAndNameOfFileOfJLabel() {
        return PathAndNameOfFileOfJLabel;
    }

    public void setPathAndNameOfFileOfJLabel(JLabel pathAndNameOfFileOfJLabel) {
        PathAndNameOfFileOfJLabel = pathAndNameOfFileOfJLabel;
    }

    public JLabel[] getjPoint() {
        return jPoint;
    }

    public void setjPoint(JLabel[] jPoint) {
        this.jPoint = jPoint;
    }

    public JLabel[] getPeople() {
        return people;
    }

    public void setPeople(JLabel[] people) {
        this.people = people;
    }

    public JLabel[] getPrecent() {
        return precent;
    }

    public void setPrecent(JLabel[] precent) {
        this.precent = precent;
    }

    private JTable jTable;

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public FileService getFileService() {
        return fileService;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public Dto() {

    }

}
