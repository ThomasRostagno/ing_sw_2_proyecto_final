package com.ingsof2.panels.mainComponents;

import com.ingsof2.Main;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPanelVisual extends JPanel {

    private BufferedImage image;

    public MainPanelVisual() throws ApiException {
        try {
            image = ImageIO.read(new File(Constants.BANNER_MAIN_PANEL));
        } catch (IOException ex) {

            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, Constants.WIDTH / 2, Constants.HEIGHT, this); // see javadoc for more info on the parameters
    }
}
