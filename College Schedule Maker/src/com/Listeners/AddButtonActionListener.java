package com.Listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonActionListener implements ActionListener {
    private final JTable table;

    public AddButtonActionListener(JTable table){
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] Days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] Hours = {"09.00", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00"};
        JComboBox<String> hourComboBox = new JComboBox<>(Hours);
        JComboBox<String> daysComboBox = new JComboBox<>(Days);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));

        inputPanel.add(new JLabel("Hour:"));
        inputPanel.add(hourComboBox);
        inputPanel.add(new JLabel("Day:"));
        inputPanel.add(daysComboBox);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Enter hour and day", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String Hour = (String) hourComboBox.getSelectedItem();
            String Day = (String) daysComboBox.getSelectedItem();


            if (Hour != null && Day != null) {
                int rowIndex = -1;
                for (int i = 0; i < table.getRowCount(); i++) {
                    if (table.getValueAt(i, 0).equals(Hour)) {
                        rowIndex = i;
                        break;
                    }
                }
                int columnIndex = -1;
                for (int i = 0; i < table.getColumnCount(); i++) {
                    if (table.getColumnName(i).equals(Day)) {
                        columnIndex = i;
                        break;
                    }
                }
                if (rowIndex != -1 && columnIndex != -1) {
                    table.setValueAt("coursePlaceholder", rowIndex, columnIndex);
                }
            }
        }
    }

}
