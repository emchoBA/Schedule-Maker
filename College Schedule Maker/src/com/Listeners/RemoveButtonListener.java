package com.Listeners;

import com.CellComponents.EditCellContent;
import com.GUI.CreateGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveButtonListener implements ActionListener {
    private final JTable table;
    private CreateGUI createGUI;

    public RemoveButtonListener(JTable table, CreateGUI createGUI){
        this.table = table;
        this.createGUI = createGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new EditCellContent(table, false, createGUI);
    }
}
