package com.ingsof2.panels;

import com.ingsof2.panels.add.ButtonsInterface;

import javax.swing.*;
import java.awt.*;

public class GenericNextBackButtonPanel extends JPanel {

    private final JButton backButton = new JButton("Back");
    private final JButton nextButton = new JButton("Next");

    public GenericNextBackButtonPanel(ButtonsInterface buttonsInterface) {
        Color backgroundColor = new Color(20, 20, 20);

        backButton.addActionListener(e -> {
            buttonsInterface.back();
        });

        nextButton.addActionListener(e -> {
            buttonsInterface.next();
        });

        setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(backgroundColor);
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(backButton);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(backgroundColor);
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(nextButton);

        add(leftPanel);
        add(rightPanel);
    }
}
