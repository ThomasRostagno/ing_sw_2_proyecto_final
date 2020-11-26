package com.ingsof2.panels.mainComponents;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private final MainPanelButtons mainPanelButtons = new MainPanelButtons();
    private final MainPanelVisual mainPanelVisual = new MainPanelVisual();

    public MainPanel() {
        setLayout(new GridLayout(1, 2));

        add(mainPanelButtons);
        add(mainPanelVisual);
    }
}
