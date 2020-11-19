package com.ingsof2.panels.listarContratosEnVigencia;

import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ListarContratosEnVigencia extends JPanel {

    //BufferedImage image;

    public ListarContratosEnVigencia() {

        /*try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }*/

        BorderLayout borderLayout = new BorderLayout();

        setLayout(borderLayout);

        add(new ContratoEnVigenciaPanel(), BorderLayout.CENTER);
    }

    /*@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, Constants.WIDTH, Constants.HEIGHT, this); // see javadoc for more info on the parameters
    }*/
}
