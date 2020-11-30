package com.ingsof2.panels.listarEscribanos;

import com.ingsof2.Objetos.Escribano;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.panels.listarDuenios.DuenioPanel;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ListarEscribanos extends JPanel {

    private BufferedImage image;

    public ListarEscribanos() {

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        setLayout(new GridBagLayout());

        JPanel escribanosPanel = new EscribanoPanel();
        escribanosPanel.setPreferredSize(new Dimension(600, 450));

        add(escribanosPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, Constants.WIDTH, Constants.CENTER_HEIGHT, this); // see javadoc for more info on the parameters
    }

    public Escribano getEscribano() {
        return new Escribano("Daniel", "Kwist", "2664406601", "39662252", "Masculino", "Rivadavia 1305", "30/12/1996", "kwistdaniel@gmail.com", "6969");
    }
}
