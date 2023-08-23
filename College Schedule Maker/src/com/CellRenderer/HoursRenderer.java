package com.CellRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class HoursRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        Font hoursFont = new Font("Arial", Font.BOLD, 14);
        rendererComponent.setFont(hoursFont);

        ((JLabel) rendererComponent).setHorizontalAlignment(JLabel.CENTER);

        return rendererComponent;
    }
}
