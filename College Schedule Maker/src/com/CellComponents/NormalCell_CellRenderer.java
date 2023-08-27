package com.CellComponents;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;


public class NormalCell_CellRenderer extends DefaultTableCellRenderer {
    private Color cellColor;
    private int rowIndex;
    private int columnIndex;

    public void setCellColor(int rowIndex,int columnIndex, Color color){
        this.cellColor = color;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        Component component = super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);
// < rowIndex and != null try for all possible
        if(row == rowIndex && column == columnIndex){
            component.setBackground(cellColor);
        }
        else{
            if(table.getValueAt(row, column) != null){
                component.setBackground(cellColor);
            }
            else{
                component.setBackground(table.getBackground());
            }

        }

        return component;
    }
}