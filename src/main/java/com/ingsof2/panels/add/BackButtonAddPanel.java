package com.ingsof2.panels.add;

import com.ingsof2.Main;

import javax.swing.*;
import java.awt.*;

public class BackButtonAddPanel extends JPanel {

    private final JButton backButton = new JButton("Back");

    public BackButtonAddPanel() {
        setBackground(new Color(20, 20, 20));

        backButton.addActionListener(e -> {
            Main.mainFrame.goAdd();
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(backButton);
    }
}
