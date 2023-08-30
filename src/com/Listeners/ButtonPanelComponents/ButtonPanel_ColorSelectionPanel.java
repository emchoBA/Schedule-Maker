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

        JButton redButton = createColorButton(new Color(215,0,64));
        JButton greenButton = createColorButton(new Color(175,225,175));
        JButton cyanButton = createColorButton(new Color(70,130,180));
        JButton purpleButton = createColorButton(new Color(207,159,255));
        JButton pinkButton = createColorButton(new Color(255,192,203));
        JButton orangeButton = createColorButton(new Color(255,127,80));
        JButton yellowButton = createColorButton(new Color(252,245,95));
        JButton grayButton = createColorButton(new Color(211,211,211));

        JPanel colorPanel = new JPanel();

        colorPanel.add(redButton);
        colorPanel.add(greenButton);
        colorPanel.add(cyanButton);
        colorPanel.add(purpleButton);
        colorPanel.add(pinkButton);
        colorPanel.add(orangeButton);
        colorPanel.add(yellowButton);
        colorPanel.add(grayButton);

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