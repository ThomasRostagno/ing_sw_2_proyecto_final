package com.ingsof2.panels;

import com.ingsof2.Main;
import com.ingsof2.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class CancelButtonPanel extends JPanel {

    private final JButton cancelButton = new JButton("Cancelar");

    public CancelButtonPanel() {
        setBackground(Constants.BUTTONS_BACKGROUND);

        cancelButton.addActionListener(e -> {
            Main.mainFrame.goMainPanel();
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(cancelButton);
    }
}
