package com.ingsof2.panels.mainComponents;

import com.ingsof2.exceptions.ApiException;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private final MainPanelButtons mainPanelButtons = new MainPanelButtons();
    private final MainPanelVisual mainPanelVisual = new MainPanelVisual();

    public MainPanel() throws ApiException {
        setLayout(new GridLayout(1, 2));

        add(mainPanelButtons);
        add(mainPanelVisual);
    }
}
