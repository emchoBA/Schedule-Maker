package com.GUI;

import javax.swing.*;
import java.awt.*;

public class InformationPanelClass {
    public JPanel createInformationTable(){
        JPanel extraPanel = new JPanel();
        extraPanel.setPreferredSize(new Dimension(200,200));
        extraPanel.setBackground(Color.BLUE);

//        mainPanel.add(extraPanel); add information panel like this to snap

        return extraPanel;
    }
}
