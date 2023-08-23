package com.GUI;

import javax.swing.*;
import java.awt.*;

public class ButtonClass {
    public JPanel createButtonPanel(){
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
        return buttonPanel;

    }
}
