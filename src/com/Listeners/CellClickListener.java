package com.Listeners;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CellClickListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e){
        JTable table = (JTable) e.getSource();
        int row = table.rowAtPoint(e.getPoint());
        int column = table.columnAtPoint(e.getPoint());

        if(row >= 0 && column >= 0){
            Object value = table.getValueAt(row, column);
            System.out.println("Clicked: " + value);
        }
    }
}