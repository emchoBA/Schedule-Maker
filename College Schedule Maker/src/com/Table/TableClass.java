package com.Table;

import com.CellRenderer.HoursRenderer;
import com.Listeners.CellClickListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableClass {
    public JPanel CreateTable(){
        JTable table = getjTable();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel extraPanel = new JPanel();
        extraPanel.setPreferredSize(new Dimension(200,200));
        extraPanel.setBackground(Color.BLUE);
        table.addMouseListener(new CellClickListener());
        table.getColumnModel().getColumn(0).setCellRenderer(new HoursRenderer());
        table.setSize(500,500);
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane);
        mainPanel.add(extraPanel);

        return mainPanel;
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
