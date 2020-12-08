package com.ingsof2.panels.listarVendedores;

import com.ingsof2.Objetos.Vendedor;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ListarVendedores extends JPanel {

    private final VendedorPanel vendedorPanel;
    private BufferedImage image;

    public ListarVendedores() {

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        setLayout(new GridBagLayout());

        vendedorPanel = new VendedorPanel();

        add(vendedorPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, Constants.WIDTH, Constants.CENTER_HEIGHT, this); // see javadoc for more info on the parameters
    }

    public Vendedor getVendedor() {
        return vendedorPanel.getVendedor();
    }
}
