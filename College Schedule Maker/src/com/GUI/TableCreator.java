package com.GUI;


import javax.swing.*;
import java.awt.*;

public class TableCreator extends JFrame {

    public TableCreator() {
        setTitle("College Schedule Maker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000,1000));

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        addTablePanel();
        addButtonPanel();
        pack();
    }

    private void addTablePanel(){
        TableClass tableInstance = new TableClass();
        JPanel tablePanel = tableInstance.CreateTable();
        add(tablePanel, BorderLayout.CENTER);
    }

    private void addButtonPanel(){
        ButtonClass buttons = new ButtonClass();
        JPanel buttonPanel = buttons.createButtonPanel();
        add(buttonPanel, BorderLayout.WEST);
    }

}
