package com.ingsof2.panels.delete;

import com.ingsof2.Main;
import com.ingsof2.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class BackButtonDeletePanel extends JPanel {

    private final JButton backButton = new JButton("Back");

    public BackButtonDeletePanel() {
        setBackground(Constants.BUTTONS_BACKGROUND);

        backButton.addActionListener(e -> {
            Main.mainFrame.goDelete();
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(backButton);
    }
}
