package com.GUI;

import javax.swing.*;
import java.awt.*;

public class InformationPanelClass {
    public JPanel createInformationTable(){
        JPanel extraPanel = new JPanel();
        extraPanel.setBackground(Color.BLUE);

        JTextArea textArea = new JTextArea("HEY");
        textArea.setOpaque(false);
        extraPanel.add(textArea);

        return extraPanel;
    }
}