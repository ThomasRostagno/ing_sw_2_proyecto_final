package com.ingsof2.panels.show;

import com.ingsof2.Main;
import com.ingsof2.panels.GenericNextBackButtonPanel;
import com.ingsof2.panels.add.ButtonsInterface;
import com.ingsof2.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class BackButtonShowPanel extends JPanel {

    private final JButton backButton = new JButton("Atrás");
    private final JButton nextButton = new JButton("Siguiente");

    public BackButtonShowPanel() {
        setBackground(Constants.BUTTONS_BACKGROUND);

        backButton.addActionListener(e -> {
            Main.mainFrame.goShow();
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(backButton);
    }

    public BackButtonShowPanel(ButtonsInterface buttonsInterface) {
        Color backgroundColor = Constants.BUTTONS_BACKGROUND;

        backButton.addActionListener(e -> {
            Main.mainFrame.goShow();
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
