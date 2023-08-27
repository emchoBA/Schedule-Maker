package com.CellComponents;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Hours_CellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        Component hoursRendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        Font hoursFont = new Font("Arial", Font.BOLD, 14);
        hoursRendererComponent.setFont(hoursFont);

        ((JLabel) hoursRendererComponent).setHorizontalAlignment(JLabel.CENTER);

        return hoursRendererComponent;
    }
}
