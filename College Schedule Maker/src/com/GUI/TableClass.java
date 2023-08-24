package com.GUI;

import com.CellRenderer.*;
import com.Listeners.CellClickListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableClass {
    public JTable CreateTable(){
        JTable table = getjTable();

        table.addMouseListener(new CellClickListener());
        table.getColumnModel().getColumn(0).setCellRenderer(new HoursRenderer());

        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setHeaderRenderer(new DaysRenderer());
        }
        //table.setSize(500,500);

        ////for the cells; trying this for now
        int targetColumn = -1;
        int targetRow = -1;

        for(int row = 0; row < table.getRowCount(); row++){
            if(table.getValueAt(row, 0).equals("09.00")){
                targetRow = row;
                break;
            }
        }

        for(int col = 0; col < table.getColumnCount(); col++){
            if(table.getColumnName(col).equals("Monday")){
                targetColumn = col;
                break;
            }
        }

        if(targetRow != -1 && targetColumn != -1){
            table.setValueAt("Vay", targetRow, targetColumn);
        }
        ////
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
