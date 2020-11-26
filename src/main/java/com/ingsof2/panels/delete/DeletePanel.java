package com.ingsof2.panels.delete;

import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;
import com.ingsof2.utils.SpringUtilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DeletePanel extends JPanel {

    private final JLabel cancelarAlquilerLabel = new JLabel("Cancelar alquiler");
    private final JLabel eliminarInquilinoLabel = new JLabel("Eliminar inquilino");
    private final JLabel eliminarEscribanoLabel = new JLabel("Eliminar escribano");
    private final JLabel eliminarPropiedadLabel = new JLabel("Eliminar propiedad");
    private final JLabel eliminarDuenoLabel = new JLabel("Eliminar dueño");

    private final JButton cancelarAlquilerButton = new JButton("Button");
    private final JButton eliminarInquilinoButton = new JButton("Button");
    private final JButton eliminarEscribanoButton = new JButton("Button");
    private final JButton eliminarPropiedadButton = new JButton("Button");
    private final JButton eliminarDuenoButton = new JButton("Button");

    private final int rows = 5;

    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;

    private final double x = eliminarPropiedadLabel.getPreferredSize().getWidth() + xPad + eliminarPropiedadButton.getPreferredSize().getWidth();
    private final double y = eliminarPropiedadButton.getPreferredSize().getHeight() * rows + (rows - 1) * yPad;

    private final int initialX = (int) (Constants.WIDTH / 2 - x / 2);
    private final int initialY = (int) (Constants.CENTER_HEIGHT / 2 - y / 2);

    private final int margin = Constants.MARGIN;

    private BufferedImage image;

    public DeletePanel() {

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        cancelarAlquilerButton.addActionListener(e -> {
        });
        eliminarInquilinoButton.addActionListener(e -> {
        });
        eliminarEscribanoButton.addActionListener(e -> {
        });
        eliminarPropiedadButton.addActionListener(e -> {
        });
        eliminarDuenoButton.addActionListener(e -> {
        });

        setLayout(new SpringLayout());

        add(cancelarAlquilerLabel);
        add(cancelarAlquilerButton);

        add(eliminarInquilinoLabel);
        add(eliminarInquilinoButton);

        add(eliminarEscribanoLabel);
        add(eliminarEscribanoButton);

        add(eliminarPropiedadLabel);
        add(eliminarPropiedadButton);

        add(eliminarDuenoLabel);
        add(eliminarDuenoButton);

        SpringUtilities.makeCompactGrid(this, rows, 2, initialX, initialY, xPad, yPad);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, Constants.WIDTH, Constants.CENTER_HEIGHT, this); // see javadoc for more info on the parameters

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(212, 212, 212, 200));
        g2d.fillRect(initialX - margin, initialY - margin, ((int) x) + margin * 2, ((int) y) + margin * 2);
    }
}
