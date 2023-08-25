package com.CellEditors;

import com.Listeners.ButtonPanelComponents.ButtonPanel_Days;
import com.Listeners.ButtonPanelComponents.ButtonPanel_Hours;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EditCellContent {
    public EditCellContent(JTable table,String text){
        ButtonPanel_Days daysClass = new ButtonPanel_Days();
        JPanel daysPanel = daysClass.getDaysPanel();
        JRadioButton[] daysRadioButton = daysClass.getDaysRadioButton();

        ButtonPanel_Hours hourClass = new ButtonPanel_Hours();
        JPanel hoursPanel = hourClass.getHoursPanel();
        JCheckBox[] hoursCheckBox = hourClass.getHoursCheckBox();

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
                        table.setValueAt(text, rowIndex, columnIndex);
                    }
                }
            }
        }
    }
}
