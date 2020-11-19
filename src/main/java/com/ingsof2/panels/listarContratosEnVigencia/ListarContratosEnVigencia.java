package com.ingsof2.panels.listarContratosEnVigencia;

import javax.swing.*;
import java.awt.*;

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
