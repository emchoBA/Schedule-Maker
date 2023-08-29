package com.Listeners.ButtonPanelComponents;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ButtonPanel_Hours {
    private final JCheckBox[] hoursCheckBox;
    private final JPanel hoursPanel;
    public ButtonPanel_Hours(){
        String[] Hours = {"09.00", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00"};

        hoursCheckBox = new JCheckBox[Hours.length];
        hoursPanel = new JPanel(new GridLayout(0,1));
        for(int i = 0; i < Hours.length; i++){
            hoursCheckBox[i] = new JCheckBox(Hours[i]);
            hoursPanel.add(hoursCheckBox[i]);
        }

        TitledBorder hourBorder = BorderFactory.createTitledBorder("Hours:");
        hoursPanel.setBorder(hourBorder);
    }

    public JCheckBox[] getHoursCheckBox(){
        return hoursCheckBox;
    }

    public JPanel getHoursPanel(){
        return hoursPanel;
    }

}