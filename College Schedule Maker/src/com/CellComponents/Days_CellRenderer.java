package com.CellComponents;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Days_CellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component daysRendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        setHorizontalAlignment(SwingConstants.CENTER);

        JTableHeader header = table.getTableHeader();
        if(header != null){
            Font originalFont = header.getFont();
            Font boldFont = new Font(originalFont.getName(), Font.BOLD, originalFont.getSize());
            daysRendererComponent.setFont(boldFont);
        }

        return daysRendererComponent;
    }
}
