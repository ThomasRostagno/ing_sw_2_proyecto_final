package com.ingsof2.panels.show;

import com.ingsof2.Main;

import javax.swing.*;
import java.awt.*;

public class BackButtonShowPanel extends JPanel {

    private final JButton backButton = new JButton("Back");

    public BackButtonShowPanel() {
        setBackground(new Color(20, 20, 20));

        backButton.addActionListener(e -> {
            Main.mainFrame.goShow();
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(backButton);
    }
}
