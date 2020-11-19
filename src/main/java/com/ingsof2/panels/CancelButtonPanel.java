package com.ingsof2.panels;

import com.ingsof2.Main;

import javax.swing.*;
import java.awt.*;

public class CancelButtonPanel extends JPanel {

    private final JButton cancelButton = new JButton("Cancel");

    public CancelButtonPanel() {
        setBackground(new Color(20, 20, 20));

        cancelButton.addActionListener(e -> {
            Main.mainFrame.goMainPanel();
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(cancelButton);
    }
}
