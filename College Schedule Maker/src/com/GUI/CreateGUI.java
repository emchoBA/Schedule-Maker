package com.GUI;

import javax.swing.*;
import java.awt.*;

public class CreateGUI extends JFrame {

    public CreateGUI() {
        setTitle("College Schedule Maker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000,1000));

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        addMainPanel();
        addButtonPanel();
        pack();
    }

    private void addMainPanel(){
        InformationPanelClass informationPanelInstance = new InformationPanelClass();
        JPanel informationPanel = informationPanelInstance.createInformationTable();

        TableClass tableInstance = new TableClass();
        JPanel tablePanel = tableInstance.CreateTable();

        tablePanel.add(informationPanel);
        add(tablePanel, BorderLayout.CENTER);


    }

    private void addButtonPanel(){
        ButtonClass buttons = new ButtonClass();
        JPanel buttonPanel = buttons.createButtonPanel();
        add(buttonPanel, BorderLayout.WEST);
    }
}
