package com.ingsof2.panels;

import com.ingsof2.Main;

import javax.swing.*;
import java.awt.*;

public class ExitButtonPanel extends JPanel {

    private final JButton exitButton = new JButton("Exit");

    public ExitButtonPanel() {
        exitButton.addActionListener(e -> {
            Main.mainFrame.exit();
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(exitButton);
    }
}
