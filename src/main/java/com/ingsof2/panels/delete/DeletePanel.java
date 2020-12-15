package com.ingsof2.panels.delete;

import com.ingsof2.Main;
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
    private final JLabel eliminarVentaLabel = new JLabel("Eliminar venta");
    private final JLabel eliminarInquilinoLabel = new JLabel("Eliminar inquilino");
    private final JLabel eliminarGaranteLabel = new JLabel("Eliminar garante");
    private final JLabel eliminarPropiedadLabel = new JLabel("Eliminar propiedad");
    private final JLabel eliminarEscribanoLabel = new JLabel("Eliminar escribano");
    private final JLabel eliminarDuenioLabel = new JLabel("Eliminar dueño");
    private final JLabel eliminarCompradorLabel = new JLabel("Eliminar comprador");
    private final JLabel eliminarVendedorLabel = new JLabel("Eliminar vendedor");
    private final JLabel eliminarZonaLabel = new JLabel("Eliminar zona");

    private final JButton cancelarAlquilerButton = new JButton("Cancelar alquiler");
    private final JButton eliminarVentaButton = new JButton("Eliminar venta");
    private final JButton eliminarInquilinoButton = new JButton("Eliminar inquilino");
    private final JButton eliminarGaranteButton = new JButton("Eliminar garante");
    private final JButton eliminarPropiedadButton = new JButton("Eliminar propiedad");
    private final JButton eliminarEscribanoButton = new JButton("Eliminar escribano");
    private final JButton eliminarDuenioButton = new JButton("Eliminar dueño");
    private final JButton eliminarCompradorButton = new JButton("Eliminar comprador");
    private final JButton eliminarVendedorButton = new JButton("Eliminar vendedor");
    private final JButton eliminarZonaButton = new JButton("Eliminar zona");

    private final int rows = 5;

    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;

    private final double x = eliminarPropiedadLabel.getPreferredSize().getWidth() + xPad + eliminarPropiedadButton.getPreferredSize().getWidth() + xPad + eliminarCompradorLabel.getPreferredSize().getWidth() + xPad + eliminarCompradorButton.getPreferredSize().getWidth();
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
            Main.mainFrame.goCancelarAlquiler();
        });
        eliminarVentaButton.addActionListener(e -> {
            Main.mainFrame.goEliminarVenta();
        });
        eliminarInquilinoButton.addActionListener(e -> {
            Main.mainFrame.goEliminarInquilino();
        });
        eliminarGaranteButton.addActionListener(e -> {
            Main.mainFrame.goEliminarGarante();
        });
        eliminarPropiedadButton.addActionListener(e -> {
            Main.mainFrame.goEliminarPropiedad();
        });
        eliminarEscribanoButton.addActionListener(e -> {
            Main.mainFrame.goEliminarEscribano();
        });
        eliminarDuenioButton.addActionListener(e -> {
            Main.mainFrame.goEliminarDuenio();
        });
        eliminarCompradorButton.addActionListener(e -> {
            Main.mainFrame.goEliminarComprador();
        });
        eliminarVendedorButton.addActionListener(e -> {
            Main.mainFrame.goEliminarVendedor();
        });
        eliminarZonaButton.addActionListener(e -> {
            Main.mainFrame.goEliminarZona();
        });

        setLayout(new SpringLayout());

        add(cancelarAlquilerLabel);
        add(cancelarAlquilerButton);

        add(eliminarVentaLabel);
        add(eliminarVentaButton);

        add(eliminarInquilinoLabel);
        add(eliminarInquilinoButton);

        add(eliminarGaranteLabel);
        add(eliminarGaranteButton);

        add(eliminarPropiedadLabel);
        add(eliminarPropiedadButton);

        add(eliminarEscribanoLabel);
        add(eliminarEscribanoButton);

        add(eliminarDuenioLabel);
        add(eliminarDuenioButton);

        add(eliminarCompradorLabel);
        add(eliminarCompradorButton);

        add(eliminarVendedorLabel);
        add(eliminarVendedorButton);

        add(eliminarZonaLabel);
        add(eliminarZonaButton);

        SpringUtilities.makeCompactGrid(this, rows, 4, initialX, initialY, xPad, yPad);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, Constants.WIDTH, Constants.CENTER_HEIGHT, this); // see javadoc for more info on the parameters

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Constants.RECT_COLOR);
        g2d.fillRect(initialX - margin, initialY - margin, ((int) x) + margin * 2, ((int) y) + margin * 2);
    }
}
