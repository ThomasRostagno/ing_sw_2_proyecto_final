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
    @Override
    protected void paintComponent(Graphics g) {
        Color color1 = new Color(0, 153, 153); //$0x009999
        Color color2 = new Color(0,0,0); //$0x000000
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}