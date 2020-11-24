package com.ingsof2.panels.mainComponents;

import com.ingsof2.panels.ExitButtonPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanelButtons extends JPanel {

    private final MainButtons mainButtons = new MainButtons();

    private final ExitButtonPanel exitButtonPanel = new ExitButtonPanel();

    public MainPanelButtons() {
        setLayout(new BorderLayout());

        add(mainButtons, BorderLayout.CENTER);
        add(exitButtonPanel, BorderLayout.PAGE_END);
    }
}
