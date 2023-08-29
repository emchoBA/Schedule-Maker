package com.Listeners.ButtonPanelComponents;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ButtonPanel_Days {
    private final JRadioButton[] daysRadioButton;
    private final JPanel daysPanel;
    public ButtonPanel_Days(){
        String[] Days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        daysRadioButton = new JRadioButton[Days.length];
        ButtonGroup daysButtonGroup = new ButtonGroup();
        daysPanel = new JPanel(new GridLayout(0,1));
        for(int i = 0; i < Days.length; i++){
            daysRadioButton[i] = new JRadioButton(Days[i]);
            daysButtonGroup.add(daysRadioButton[i]);
            daysRadioButton[i].setBackground(Color.WHITE);
            daysPanel.add(daysRadioButton[i]);
        }

        TitledBorder dayBorder = BorderFactory.createTitledBorder("Day:");
        daysPanel.setBorder(dayBorder);
    }

    public JRadioButton[] getDaysRadioButton() {
        return daysRadioButton;
    }

    public JPanel getDaysPanel() {
        return daysPanel;
    }
}