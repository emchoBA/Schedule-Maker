package com.Listeners;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddButtonActionListener implements ActionListener {
    private final JTable table;

    public AddButtonActionListener(JTable table){
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] Days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] Hours = {"09.00", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00"};

        JRadioButton[] daysRadioButton = new JRadioButton[Days.length];
        ButtonGroup dayButtonGroup = new ButtonGroup();
        JPanel daysPanel = new JPanel(new GridLayout(0,1));
        for(int i = 0; i < Days.length; i++){
            daysRadioButton[i] = new JRadioButton(Days[i]);
            dayButtonGroup.add(daysRadioButton[i]);
            daysRadioButton[i].setBackground(Color.WHITE);
            daysPanel.add(daysRadioButton[i]);
        }
        TitledBorder dayBorder = BorderFactory.createTitledBorder("Day:");
        daysPanel.setBorder(dayBorder);

        JCheckBox[] hoursCheckBox = new JCheckBox[Hours.length];
        JPanel hoursPanel = new JPanel(new GridLayout(0,1));
        for(int i = 0; i < Hours.length; i++){
            hoursCheckBox[i] = new JCheckBox(Hours[i]);
            hoursPanel.add(hoursCheckBox[i]);
        }
        TitledBorder hourBorder = BorderFactory.createTitledBorder("Hours:");
        hoursPanel.setBorder(hourBorder);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(daysPanel, BorderLayout.WEST);
        inputPanel.add(hoursPanel, BorderLayout.EAST);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Select", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String inputDay = null;
            for(JRadioButton radioButton : daysRadioButton){
                if(radioButton.isSelected()){
                    inputDay = radioButton.getText();
                    break;
                }
            }

            ArrayList<String> selectedHours = new ArrayList<>();
            for (JCheckBox checkBox : hoursCheckBox){
                if (checkBox.isSelected()){
                    selectedHours.add(checkBox.getText());
                }
            }

            if(inputDay != null && !selectedHours.isEmpty()){
                for (String selectedHour : selectedHours){
                    int rowIndex = -1;
                    for(int i = 0; i < table.getRowCount(); i++){
                        if (table.getValueAt(i, 0).equals(selectedHour)){
                            rowIndex = i;
                            break;
                        }
                    }

                    int columnIndex = -1;
                    for(int i = 0; i < table.getColumnCount(); i++){
                        if (table.getColumnName(i).equals(inputDay)){
                            columnIndex = i;
                            break;
                        }
                    }

                    if(rowIndex != -1 && columnIndex != -1){
                        table.setValueAt("coursePlaceHolder", rowIndex, columnIndex);
                    }
                }
            }
        }
    }
}
