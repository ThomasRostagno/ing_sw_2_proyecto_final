package com.ingsof2.panels.add;

import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.Constants;
import com.ingsof2.Main;
import com.ingsof2.utils.ErrorCode;
import com.ingsof2.utils.SpringUtilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AddPanel extends JPanel {

    private final JLabel registrarAlquilerLabel = new JLabel("Registrar alquiler");
    private final JLabel cargarClienteLabel = new JLabel("Cargar cliente");
    private final JLabel cargarEscribanoLabel = new JLabel("Cargar escribano");
    private final JLabel cargarPropiedadesLabel = new JLabel("Cargar propiedades");
    private final JLabel cargarDueñoLabel = new JLabel("Cargar dueño");

    private final JButton registrarAlquilerButton = new JButton("Button");
    private final JButton cargarClienteButton = new JButton("Button");
    private final JButton cargarEscribanoButton = new JButton("Button");
    private final JButton cargarPropiedadesButton = new JButton("Button");
    private final JButton cargarDueñoButton = new JButton("Button");

    private final int rows = 5;

    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;

    private final double x = cargarPropiedadesLabel.getPreferredSize().getWidth() + xPad + cargarPropiedadesButton.getPreferredSize().getWidth();
    private final double y = cargarPropiedadesButton.getPreferredSize().getHeight() * rows + (rows - 1) * yPad;

    private final int initialX = (int) (Constants.WIDTH / 2 - x / 2);
    private final int initialY = (int) (Constants.HEIGHT / 2 - y / 2);

    private final int margin = Constants.MARGIN;

    private BufferedImage image;

    public AddPanel() {

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        registrarAlquilerButton.addActionListener(e -> {
            Main.mainFrame.goRegistrarAlquiler();
        });
        cargarClienteButton.addActionListener(e -> {
        });
        cargarEscribanoButton.addActionListener(e -> {
        });
        cargarPropiedadesButton.addActionListener(e -> {
        });
        cargarDueñoButton.addActionListener(e -> {
        });

        setLayout(new SpringLayout());

        add(registrarAlquilerLabel);
        add(registrarAlquilerButton);

        add(cargarClienteLabel);
        add(cargarClienteButton);

        add(cargarEscribanoLabel);
        add(cargarEscribanoButton);

        add(cargarPropiedadesLabel);
        add(cargarPropiedadesButton);

        add(cargarDueñoLabel);
        add(cargarDueñoButton);

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
