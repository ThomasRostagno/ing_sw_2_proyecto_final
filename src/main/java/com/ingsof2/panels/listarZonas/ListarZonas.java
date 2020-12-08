package com.ingsof2.panels.listarZonas;

import com.ingsof2.Objetos.Inquilino;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ListarZonas extends JPanel {

    private final ZonaPanel zonaPanel;
    private BufferedImage image;

    public ListarZonas() {

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        setLayout(new GridBagLayout());

        zonaPanel = new ZonaPanel();

        add(zonaPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, Constants.WIDTH, Constants.CENTER_HEIGHT, this); // see javadoc for more info on the parameters
    }

    public Inquilino getInquilino() {
        return zonaPanel.getInquilino();
    }
}
