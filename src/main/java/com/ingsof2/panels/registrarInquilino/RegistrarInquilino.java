package com.ingsof2.panels.registrarInquilino;

import com.ingsof2.exceptions.ApiException;
import com.ingsof2.panels.add.BackButtonAddPanel;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;
import com.ingsof2.utils.SpringUtilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RegistrarInquilino extends JPanel {
    /**Creacion Labels y TextFields**/
    private JLabel nombreLabel = new JLabel("caca");
    private JLabel nombreLabel1 = new JLabel("caca1");
    private JLabel nombreLabel2 = new JLabel("caca2");
    private JLabel nombreLabel3 = new JLabel("caca3");
    private JLabel nombreLabel4 = new JLabel("caca4");
    private JLabel nombreLabel5 = new JLabel("caca5");
    private JLabel nombreLabel6 = new JLabel("caca6");

    private JTextField nombreTextField = new JTextField("caca");
    private JTextField nombreTextField1 = new JTextField("caca");
    private JTextField nombreTextField2 = new JTextField("caca");
    private JTextField nombreTextField3 = new JTextField("caca");
    private JTextField nombreTextField4 = new JTextField("caca");
    private JTextField nombreTextField5 = new JTextField("caca");
    private JTextField nombreTextField6 = new JTextField("caca");




    private final int rows = 7;
    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;
    private final double x = nombreLabel5.getPreferredSize().getWidth() + xPad + nombreTextField5.getPreferredSize().getWidth();
    private final double y = nombreTextField5.getPreferredSize().getHeight() * rows + (rows - 1) * yPad;
    private final int initialX = (int) (Constants.WIDTH / 2 - x / 2);
    private final int initialY = (int) (Constants.HEIGHT /2 - y / 2);
    private final int margin = Constants.MARGIN;
    private BufferedImage image;


    public RegistrarInquilino(){
        /**intenta poner el fondo pareciera**/
        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        setLayout(new SpringLayout());



        nombreTextField.setPreferredSize(new Dimension(200,30));
        nombreTextField1.setPreferredSize(new Dimension(200,30));
        nombreTextField2.setPreferredSize(new Dimension(200,30));
        nombreTextField3.setPreferredSize(new Dimension(200,30));
        nombreTextField4.setPreferredSize(new Dimension(200,30));
        nombreTextField5.setPreferredSize(new Dimension(200,30));
        nombreTextField6.setPreferredSize(new Dimension(200,30));

        /**Agregacion Labels y TextFields**/
        add(nombreLabel);
        add(nombreTextField);
        add(nombreLabel1);
        add(nombreTextField1);
        add(nombreLabel2);
        add(nombreTextField2);
        add(nombreLabel3);
        add(nombreTextField3);
        add(nombreLabel4);
        add(nombreTextField4);
        add(nombreLabel5);
        add(nombreTextField5);
        add(nombreLabel6);
        add(nombreTextField6);

        /**Hace el grid xdxdxddd**/
        SpringUtilities.makeCompactGrid(this, rows, 2, initialX, initialY, xPad, yPad);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, Constants.WIDTH, Constants.HEIGHT, this); // see javadoc for more info on the parameters

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(212, 212, 212));
        g2d.fillRect(initialX - margin, initialY - margin, ((int) x) + margin * 2, ((int) y) + margin * 2);
    }
}
