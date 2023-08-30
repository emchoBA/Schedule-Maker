package com.CellComponents;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.HashMap;


public class NormalCell_CellRenderer extends DefaultTableCellRenderer {
    private HashMap<Point, Color> cellColors = new HashMap<>();
    private Color cellColor;
    private int rowIndex;
    private int columnIndex;

    public void setCellColor(int rowIndex,int columnIndex, Color color){
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.cellColor = color;
    }

    public void setRendererHashMap(HashMap<Point, Color> createdCells){
        cellColors = createdCells;
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        Component component = super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);

        Font cellFont = new Font("Arial", Font.BOLD, 14);
        component.setFont(cellFont);

        ((JLabel) component).setHorizontalAlignment(JLabel.CENTER);

        if(table.getValueAt(row, column) != null) {
            if (row == rowIndex && column == columnIndex) {
                component.setBackground(cellColor);
            }
        }

        if(table.getValueAt(row, column) != null){
            Point cellPoint = new Point(row, column);
            Color storedColor = cellColors.get(cellPoint);
            component.setBackground(storedColor);
            System.out.println(row +" "+ column + storedColor);
            System.out.println("**********");
        }

        else{
            component.setBackground(table.getBackground());
        }

        return component;
    }
}