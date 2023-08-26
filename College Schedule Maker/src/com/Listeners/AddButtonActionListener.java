package com.Listeners;

import com.CellEditors.EditCellContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonActionListener implements ActionListener {
    private final JTable table;

    public AddButtonActionListener(JTable table){
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new EditCellContent(table, true);
    }
}
