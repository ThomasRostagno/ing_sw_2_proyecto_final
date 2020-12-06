package com.ingsof2.panels.listarPropiedades;

import com.ingsof2.Objetos.Inmueble;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ListarPropiedades extends JPanel {

    private final PropiedadPanel propiedadPanel;
    private BufferedImage image;

    public ListarPropiedades() {

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        setLayout(new GridBagLayout());

        propiedadPanel = new PropiedadPanel();

        add(propiedadPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, Constants.WIDTH, Constants.CENTER_HEIGHT, this); // see javadoc for more info on the parameters
    }

    public Inmueble getPropiedad() {
        return propiedadPanel.getPropiedad();
    }
}
