package com.ingsof2.panels.mainComponents;

import com.ingsof2.Main;

import javax.swing.*;
import java.awt.*;

public class MainButtons extends JPanel {

    private final JButton addButton = new JButton("Add");
    private final JButton showButton = new JButton("Show");
    private final JButton deleteButton = new JButton("Delete");

    public MainButtons() {

        Dimension preferredSize = deleteButton.getPreferredSize();

        addButton.setPreferredSize(preferredSize);
        showButton.setPreferredSize(preferredSize);

        addButton.addActionListener(e -> {
            Main.mainFrame.goAdd();
        });
        showButton.addActionListener(e -> {
            Main.mainFrame.goShow();
        });
        deleteButton.addActionListener(e -> {
            Main.mainFrame.goDelete();
        });

        SpringLayout springLayout = new SpringLayout();

        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, addButton, 0, SpringLayout.HORIZONTAL_CENTER, showButton);
        springLayout.putConstraint(SpringLayout.SOUTH, addButton, -50, SpringLayout.NORTH, showButton);

        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, showButton, 0, SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, showButton, 0, SpringLayout.VERTICAL_CENTER, this);

        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, deleteButton, 0, SpringLayout.HORIZONTAL_CENTER, showButton);
        springLayout.putConstraint(SpringLayout.NORTH, deleteButton, 50, SpringLayout.SOUTH, showButton);

        setLayout(springLayout);

        add(addButton);
        add(showButton);
        add(deleteButton);
    }
}