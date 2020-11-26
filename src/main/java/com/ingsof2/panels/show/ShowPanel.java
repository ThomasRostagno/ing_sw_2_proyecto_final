package com.ingsof2.panels.show;

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

public class ShowPanel extends JPanel {

    private final JLabel listarInquilinosLabel = new JLabel("Listar inquilinos");
    private final JLabel listarAlquileresEnVigenciaLabel = new JLabel("Listar alquileres en vigencia");
    private final JLabel listarAlquileresVencidosLabel = new JLabel("Listar alquileres vencidos");
    private final JLabel listarAlquileresAVencerLabel = new JLabel("Listar alquileres a vencer");
    private final JLabel listarPropiedadesLabel = new JLabel("Listar propiedades");
    private final JLabel listarEscribanosLabel = new JLabel("Listar escribanos");
    private final JLabel listarDueniosLabel = new JLabel("Listar dueños");

    private final JButton listarInquilinosButton = new JButton("Button");
    private final JButton listarAlquileresEnVigenciaButton = new JButton("Button");
    private final JButton listarAlquileresVencidosButton = new JButton("Button");
    private final JButton listarAlquileresAVencerButton = new JButton("Button");
    private final JButton listarPropiedadesButton = new JButton("Button");
    private final JButton listarEscribanosButton = new JButton("Button");
    private final JButton listarDueniosButton = new JButton("Button");

    private final int rows = 7;

    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;

    private final double x = listarAlquileresEnVigenciaLabel.getPreferredSize().getWidth() + xPad + listarAlquileresEnVigenciaButton.getPreferredSize().getWidth();
    private final double y = listarAlquileresEnVigenciaButton.getPreferredSize().getHeight() * rows + (rows - 1) * yPad;

    private final int initialX = (int) (Constants.WIDTH / 2 - x / 2);
    private final int initialY = (int) (Constants.CENTER_HEIGHT / 2 - y / 2);

    private final int margin = Constants.MARGIN;

    private BufferedImage image;

    public ShowPanel() {

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        listarInquilinosButton.addActionListener(e -> {
            Main.mainFrame.goListarInquilinos();
        });
        listarAlquileresEnVigenciaButton.addActionListener(e -> {
            Main.mainFrame.goListarAlquileresEnVigencia();
        });
        listarAlquileresVencidosButton.addActionListener(e -> {
        });
        listarAlquileresAVencerButton.addActionListener(e -> {
        });
        listarPropiedadesButton.addActionListener(e -> {
            Main.mainFrame.goListarPropiedades();
        });
        listarEscribanosButton.addActionListener(e -> {
            Main.mainFrame.goListarEscribanos();
        });
        listarDueniosButton.addActionListener(e -> {
            Main.mainFrame.goListarDuenios();
        });

        setLayout(new SpringLayout());

        add(listarInquilinosLabel);
        add(listarInquilinosButton);

        add(listarAlquileresEnVigenciaLabel);
        add(listarAlquileresEnVigenciaButton);

        add(listarAlquileresVencidosLabel);
        add(listarAlquileresVencidosButton);

        add(listarAlquileresAVencerLabel);
        add(listarAlquileresAVencerButton);

        add(listarPropiedadesLabel);
        add(listarPropiedadesButton);

        add(listarEscribanosLabel);
        add(listarEscribanosButton);

        add(listarDueniosLabel);
        add(listarDueniosButton);

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
