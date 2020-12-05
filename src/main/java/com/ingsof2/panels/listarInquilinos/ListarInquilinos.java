package com.ingsof2.panels.listarInquilinos;

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

public class ListarInquilinos extends JPanel {

    private final InquilinoPanel inquilinoPanel;
    private BufferedImage image;

    public ListarInquilinos() {

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        setLayout(new GridBagLayout());

        inquilinoPanel = new InquilinoPanel();
        inquilinoPanel.setPreferredSize(new Dimension(600, 450));

        add(inquilinoPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, Constants.WIDTH, Constants.CENTER_HEIGHT, this); // see javadoc for more info on the parameters
    }

    public Inquilino getInquilino() {
        return inquilinoPanel.getInquilino();
    }
}
