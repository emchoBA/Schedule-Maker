package com.CellComponents;

import com.Listeners.ButtonPanelComponents.ButtonPanel_ColorSelectionPanel;
import com.Listeners.ButtonPanelComponents.ButtonPanel_CourseName;
import com.Listeners.ButtonPanelComponents.ButtonPanel_Days;
import com.Listeners.ButtonPanelComponents.ButtonPanel_Hours;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class EditCellContent {
    private JRadioButton[] daysRadioButton;
    private JCheckBox[] hoursCheckBox;
    private final ButtonPanel_CourseName courseNamePanel = new ButtonPanel_CourseName();
    private final ButtonPanel_ColorSelectionPanel colorSelectionPanel = new ButtonPanel_ColorSelectionPanel();
    private final Boolean add;


    public EditCellContent(JTable table, Boolean add){// use something like int?
        this.add = add;

        JPanel inputPanel = createInputPanel(getDaysPanel(),getHoursPanel());
        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Select", JOptionPane.OK_CANCEL_OPTION);

        doOperation(result, table);
    }

    private JPanel getHoursPanel(){
        ButtonPanel_Hours hourClass = new ButtonPanel_Hours();
        JPanel hoursPanel = hourClass.getHoursPanel();
        this.hoursCheckBox = hourClass.getHoursCheckBox();

        return hoursPanel;
    }

    private JPanel getDaysPanel(){
        ButtonPanel_Days daysClass = new ButtonPanel_Days();
        JPanel daysPanel = daysClass.getDaysPanel();
        this.daysRadioButton = daysClass.getDaysRadioButton();

        return daysPanel;
    }

    private JPanel createInputPanel(JPanel daysPanel, JPanel hoursPanel){
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(daysPanel, BorderLayout.WEST);
        inputPanel.add(hoursPanel, BorderLayout.EAST);
        if(add) {
            inputPanel.add(courseNamePanel, BorderLayout.NORTH);
            inputPanel.add(colorSelectionPanel, BorderLayout.SOUTH);
        }

        return inputPanel;
    }

    private void doOperation(int result, JTable table){
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

                    if(add) {
                        String text = courseNamePanel.getCourseName();
                        Color cellColor = colorSelectionPanel.getCellColor();
                        if (rowIndex != -1 && columnIndex != -1) {
                            table.setValueAt(text, rowIndex, columnIndex);
                            NormalCell_CellRenderer cellRenderer = new NormalCell_CellRenderer();
                            cellRenderer.setCellColor(rowIndex, columnIndex, cellColor);
                            table.getColumnModel().getColumn(columnIndex).setCellRenderer(cellRenderer);
                        }
                    }
                    else{
                        if (rowIndex != -1 && columnIndex != -1) {
                            table.setValueAt("", rowIndex, columnIndex);
//                            NormalCell_CellRenderer removeRenderer = new NormalCell_CellRenderer();
//                            removeRenderer.setCellColor(table.getGridColor());
//                            table.getColumnModel().getColumn(columnIndex);
                        }
                    }
                }
            }
        }
    }

}