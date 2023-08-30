package com.GUI;

import com.Listeners.AddButtonActionListener;
import com.Listeners.RemoveButtonListener;

import javax.swing.*;
import java.awt.*;

public class ButtonClass {
    private final JTable table;
    private final CreateGUI createGUI;
    public ButtonClass(JTable table, CreateGUI createGUI){
        this.table = table;
        this.createGUI = createGUI;
    }
    public JPanel createButtonPanel(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton addButton = getAddButton();
        buttonPanel.add(addButton);

        buttonPanel.add(Box.createVerticalStrut(10));

        JButton removeButton = getRemoveButton();
        buttonPanel.add(removeButton);

        Color buttonPanelColor = new Color(253,245,230);
        buttonPanel.setBackground(buttonPanelColor);

        buttonPanel.setPreferredSize(new Dimension(buttonPanel.getPreferredSize().width, buttonPanel.getPreferredSize().height));
        return buttonPanel;
    }

    private JButton getAddButton(){
        JButton addButton = new JButton("Add Course");
        addButton.setSize(20,20);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.addActionListener(new AddButtonActionListener(table, createGUI));

        return addButton;
    }
    private JButton getRemoveButton(){
        JButton removeButton = new JButton("Remove Course");
        removeButton.setSize(20,20);
        removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeButton.addActionListener(new RemoveButtonListener(table, createGUI));

        return removeButton;
    }
}