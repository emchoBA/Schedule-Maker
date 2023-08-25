package com.Listeners;

import com.CellEditors.EditCellContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveButtonListener implements ActionListener {
    private final JTable table;

    public RemoveButtonListener(JTable table){
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String clearCell = "";

        new EditCellContent(table, clearCell);
    }
}
