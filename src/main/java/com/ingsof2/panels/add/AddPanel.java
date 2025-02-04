package com.ingsof2.panels.add;

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

public class AddPanel extends JPanel {

    private final JLabel registrarContratoLabel = new JLabel("Registrar contrato");
    private final JLabel cargarInquilinoLabel = new JLabel("Cargar inquilino");
    private final JLabel cargarGaranteLabel = new JLabel("Cargar garante");
    private final JLabel cargarEscribanoLabel = new JLabel("Cargar escribano");
    private final JLabel cargarPropiedadLabel = new JLabel("Cargar propiedad");
    private final JLabel cargarDuenioLabel = new JLabel("Cargar dueño");
    private final JLabel cargarCompradorLabel = new JLabel("Cargar comprador");
    private final JLabel cargarVendedorLabel = new JLabel("Cargar vendedor");
    private final JLabel cargarZonaLabel = new JLabel("Cargar zona");

    private final JButton registrarContratoButton = new JButton("Registrar contrato");
    private final JButton cargarInquilinoButton = new JButton("Cargar inquilino");
    private final JButton cargarGaranteButton = new JButton("Cargar garante");
    private final JButton cargarEscribanoButton = new JButton("Cargar escribano");
    private final JButton cargarPropiedadButton = new JButton("Cargar propiedad");
    private final JButton cargarDuenioButton = new JButton("Cargar dueño");
    private final JButton cargarCompradorButton = new JButton("Cargar comprador");
    private final JButton cargarVendedorButton = new JButton("Cargar vendedor");
    private final JButton cargarZonaButton = new JButton("Cargar zona");

    private final int rows = 9;

    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;

    private final double x = registrarContratoLabel.getPreferredSize().getWidth() + xPad + registrarContratoButton.getPreferredSize().getWidth();
    private final double y = registrarContratoButton.getPreferredSize().getHeight() * rows + (rows - 1) * yPad;

    private final int initialX = (int) (Constants.WIDTH / 2 - x / 2);
    private final int initialY = (int) (Constants.CENTER_HEIGHT / 2 - y / 2);

    private final int margin = Constants.MARGIN;

    private BufferedImage image;

    public AddPanel() {

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        registrarContratoButton.addActionListener(e -> {
            Main.mainFrame.goRegistrarContrato();
        });
        cargarInquilinoButton.addActionListener(e -> {
            Main.mainFrame.goCargarInquilino();
        });
        cargarGaranteButton.addActionListener(e -> {
            Main.mainFrame.goCargarGarante();
        });
        cargarEscribanoButton.addActionListener(e -> {
            Main.mainFrame.goCargarEscribano();
        });
        cargarPropiedadButton.addActionListener(e -> {
            Main.mainFrame.goCargarPropiedad();
        });
        cargarDuenioButton.addActionListener(e -> {
            Main.mainFrame.goCargarDuenio();
        });
        cargarCompradorButton.addActionListener(e -> {
            Main.mainFrame.goCargarComprador();
        });
        cargarVendedorButton.addActionListener(e -> {
            Main.mainFrame.goCargarVendedor();
        });
        cargarZonaButton.addActionListener(e -> {
            Main.mainFrame.goCargarZona();
        });

        setLayout(new SpringLayout());

        add(registrarContratoLabel);
        add(registrarContratoButton);

        add(cargarInquilinoLabel);
        add(cargarInquilinoButton);

        add(cargarGaranteLabel);
        add(cargarGaranteButton);

        add(cargarEscribanoLabel);
        add(cargarEscribanoButton);

        add(cargarPropiedadLabel);
        add(cargarPropiedadButton);

        add(cargarDuenioLabel);
        add(cargarDuenioButton);

        add(cargarCompradorLabel);
        add(cargarCompradorButton);

        add(cargarVendedorLabel);
        add(cargarVendedorButton);

        add(cargarZonaLabel);
        add(cargarZonaButton);

        SpringUtilities.makeCompactGrid(this, rows, 2, initialX, initialY, xPad, yPad);
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
