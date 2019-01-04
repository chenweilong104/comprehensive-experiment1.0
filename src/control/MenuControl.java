package control;

import dto.Dto;
import service.MenuAction;

import javax.swing.*;

public class MenuControl {
    private JMenu jMenu;
    public MenuControl(Dto dto) {

        this.jMenu=dto.getjMenu();
        for(int i=0; i< jMenu.getItemCount();i++){
            JMenuItem jMenuItem =jMenu.getItem(i);
            if(jMenuItem==null) continue;
            jMenuItem.addActionListener(new MenuAction(dto));
        }
    }

}
