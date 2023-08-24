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

        JPanel mainPanel = createTablePanel();

        mainPanel.add(informationPanel);
        add(mainPanel, BorderLayout.CENTER);
    }

    private void addButtonPanel(){
        ButtonClass buttons = new ButtonClass();
        JPanel buttonPanel = buttons.createButtonPanel();
        add(buttonPanel, BorderLayout.WEST);
    }

    private JPanel createTablePanel(){
        JPanel tablePanel = new JPanel();
        TableClass tableInstance = new TableClass();

        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));

        JTable table = tableInstance.CreateTable();
        JScrollPane scrollPane = new JScrollPane(table);

        tablePanel.add(scrollPane);

        return tablePanel;
    }
}
