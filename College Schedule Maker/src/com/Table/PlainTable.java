package com.Table;

import com.CellRenderer.HoursRenderer;
import com.Listeners.CellClickListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PlainTable extends JFrame {

    public PlainTable() {
        setTitle("College Schedule Maker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);

        CreateTable();
        AddButtons();

    }

    private void CreateTable(){
        JTable table = getjTable();

        table.addMouseListener(new CellClickListener());
        table.getColumnModel().getColumn(0).setCellRenderer(new HoursRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
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

    private void AddButtons(){
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add item");
        addButton.setSize(20,20);
        buttonPanel.add(addButton);

        add(buttonPanel, BorderLayout.WEST);
    }
}
