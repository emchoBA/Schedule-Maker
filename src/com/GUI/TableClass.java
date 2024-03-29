package com.GUI;

import com.CellComponents.*;
import com.Listeners.CellClickListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableClass {
    public JTable CreateTable(){
        JTable table = getjTable();

        table.addMouseListener(new CellClickListener());
        table.getColumnModel().getColumn(0).setCellRenderer(new Hours_CellRenderer());

        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setHeaderRenderer(new Days_CellRenderer());
        }
        //table.setSize(500,500);

        return table;
    }

    private static JTable getjTable() {
        String[] Days = {"\n","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}; // Use \n for creating extra column for hours easy way.
        String[] Hours = {"09.00", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00"};

        Object[][] tableData = new Object[Hours.length][Days.length];
        DefaultTableModel model = new DefaultTableModel(tableData, Days);
        JTable table = new JTable(model);

        for(int i = 0; i < Hours.length; i++){
            table.setValueAt(Hours[i], i, 0);
            table.setRowHeight(i, 60);
        }
        return table;
    }
}