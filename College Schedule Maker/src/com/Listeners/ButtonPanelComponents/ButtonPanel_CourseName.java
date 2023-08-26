package com.Listeners.ButtonPanelComponents;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel_CourseName extends JPanel{
    private final JTextField courseName;
    public ButtonPanel_CourseName(){
        setLayout(new BorderLayout());
        add(new JLabel("Course Name:"), BorderLayout.NORTH);
        courseName = new JTextField(20);
        add(courseName, BorderLayout.CENTER);
    }

    public String getCourseName() {
        return courseName.getText();
    }
}
