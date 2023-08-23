package com.Table;


import javax.swing.*;
import java.awt.*;

public class TableCreator extends JFrame {

    public TableCreator() {
        setTitle("College Schedule Maker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000,1000));

        TableClass tableInstance = new TableClass();
        JPanel panel = tableInstance.CreateTable();

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        add(panel);
        //CreateTable();
        AddButtons();
        pack();
    }

//    private void CreateTable(){
//        JTable table = getjTable();
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//        JPanel extraPanel = new JPanel();
//        extraPanel.setPreferredSize(new Dimension(200,200));
//        extraPanel.setBackground(Color.BLUE);
//        table.addMouseListener(new CellClickListener());
//        table.getColumnModel().getColumn(0).setCellRenderer(new HoursRenderer());
//        table.setSize(500,500);
//        JScrollPane scrollPane = new JScrollPane(table);
//        mainPanel.add(scrollPane);
//        mainPanel.add(extraPanel);
//        add(mainPanel, BorderLayout.CENTER);
//    }

//    private static JTable getjTable() {
//        String[] Days = {"\n","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}; // Use \n for creating extra column for hours easy way.
//        String[] Hours = {"09.00", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00"};
//
//        Object[][] tableData = new Object[Hours.length][Days.length];
//        DefaultTableModel model = new DefaultTableModel(tableData, Days);
//        JTable table = new JTable(model);
//
//        for(int i = 0; i < Hours.length; i++){
//            table.setValueAt(Hours[i], i, 0);
//            table.setRowHeight(i, 60);
//        }
//        return table;
//    }

    private void AddButtons(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));


        JButton addButton = new JButton("Add item");
        addButton.setSize(20,20);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(addButton);

        buttonPanel.add(Box.createVerticalStrut(10));

        JButton removeButton = new JButton("Remove item");
        removeButton.setSize(20,20);
        removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(removeButton);



        Color buttonPanelColor = new Color(253,245,230);
        buttonPanel.setBackground(buttonPanelColor);

        buttonPanel.setPreferredSize(new Dimension(120, buttonPanel.getPreferredSize().height));
        add(buttonPanel, BorderLayout.WEST);

    }
}
