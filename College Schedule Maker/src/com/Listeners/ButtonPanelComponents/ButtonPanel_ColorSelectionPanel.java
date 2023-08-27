package com.Listeners.ButtonPanelComponents;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel_ColorSelectionPanel extends JPanel {
    private Color cellColor;

    public ButtonPanel_ColorSelectionPanel(){
        setLayout(new BorderLayout());

        JButton redButton = createColorButton(Color.RED);
        JButton greenButton = createColorButton(Color.GREEN);
        JButton cyanButton = createColorButton(Color.CYAN);

        JPanel colorPanel = new JPanel();
        colorPanel.add(redButton);
        colorPanel.add(greenButton);
        colorPanel.add(cyanButton);

        TitledBorder colorBorder = BorderFactory.createTitledBorder("Select Cell Color:");
        setBorder(colorBorder);

        add(colorPanel, BorderLayout.CENTER);
    }

    public Color getCellColor() {
        return cellColor;
    }

    private JButton createColorButton(Color color){
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(10,10));
        button.setBackground(color);
        button.addActionListener(new ColorButtonActionListener(color));

        return button;
    }
    private class ColorButtonActionListener implements ActionListener{
        private final Color color;

        public ColorButtonActionListener(Color color){
            this.color = color;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            cellColor = color;
        }
    }
}
