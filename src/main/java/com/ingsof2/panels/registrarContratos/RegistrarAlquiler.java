package com.ingsof2.panels.registrarContratos;

import com.ingsof2.Main;
import com.ingsof2.Objetos.Alquiler;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;
import com.ingsof2.utils.SpringUtilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RegistrarAlquiler extends JPanel {

    private JLabel fechaDeFinLabel = new JLabel("Fecha de fin:");
    private JLabel inquilinoLabel = new JLabel("Inquilino:");
    private JLabel inmuebleLabel = new JLabel("Inmueble:");
    private JLabel garanteLabel = new JLabel("Garante:");
    private JLabel escribanoLabel = new JLabel("Escribano:");
    private JLabel inquilinoSeleccionadoLabel = new JLabel("Inquilino seleccionado:");
    private JLabel inmuebleSeleccionadoLabel = new JLabel("Inmueble seleccionado:");
    private JLabel garanteSeleccionadoLabel = new JLabel("Garante seleccionado:");
    private JLabel escribanoSeleccionadoLabel = new JLabel("Escribano seleccionado:");

    private JTextField fechaDeFinTextField = new JTextField();
    private JButton inquilinoButton = new JButton("Inquilino");
    private JButton inmuebleButton = new JButton("Inmueble");
    private JButton garanteButton = new JButton("Garante");
    private JButton escribanoButton = new JButton("Escribano");
    private JButton inquilinoSeleccionadoButton = new JButton("Inquilino");
    private JButton inmuebleSeleccionadoButton = new JButton("Inmueble");
    private JButton garanteSeleccionadoButton = new JButton("Garante");
    private JButton escribanoSeleccionadoButton = new JButton("Escribano");

    private final int rows = 5;

    private final int margin = Constants.MARGIN;

    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;

    private final double x = fechaDeFinLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH + xPad + escribanoSeleccionadoLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH;
    private final double y = Constants.TEXTFIELD_HEIGHT * rows + (rows - 1) * yPad;

    private final int initialX = (int) (Constants.WIDTH / 2 - x / 2);
    private final int initialY = (int) (Constants.CENTER_HEIGHT / 2 - y / 2);

    private BufferedImage image;

    public RegistrarAlquiler() {

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        inquilinoButton.addActionListener(e -> {
            Main.mainFrame.goSeleccionarInquilino(inquilinoSeleccionadoButton);
        });
        inmuebleButton.addActionListener(e -> {
            Main.mainFrame.goSeleccionarInmuebleAlquiler(inmuebleSeleccionadoButton);
        });
        garanteButton.addActionListener(e -> {
            Main.mainFrame.goSeleccionarGarante(garanteSeleccionadoButton);
        });
        escribanoButton.addActionListener(e -> {
            Main.mainFrame.goSeleccionarEscribano(escribanoSeleccionadoButton);
        });

        setLayout(new SpringLayout());

        setSizes();
        checkers();

        add(inquilinoLabel);
        add(inquilinoButton);
        add(inquilinoSeleccionadoLabel);
        add(inquilinoSeleccionadoButton);
        add(inmuebleLabel);
        add(inmuebleButton);
        add(inmuebleSeleccionadoLabel);
        add(inmuebleSeleccionadoButton);
        add(garanteLabel);
        add(garanteButton);
        add(garanteSeleccionadoLabel);
        add(garanteSeleccionadoButton);
        add(escribanoLabel);
        add(escribanoButton);
        add(escribanoSeleccionadoLabel);
        add(escribanoSeleccionadoButton);
        add(fechaDeFinLabel);
        add(fechaDeFinTextField);
        add(new JLabel(""));
        add(new JLabel(""));

        SpringUtilities.makeCompactGrid(this, rows, 4, initialX, initialY, xPad, yPad);
    }

    private void setSizes() {
        fechaDeFinTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeFinTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeFinTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
    }

    private void checkers() {
        fechaDeFinTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))) {
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
                    e.consume();
                }

                Constants.fechaValidator(fechaDeFinTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.fechaValidator(fechaDeFinTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.fechaValidator(fechaDeFinTextField);
            }
        });

        inquilinoSeleccionadoButton.setEnabled(false);
        inmuebleSeleccionadoButton.setEnabled(false);
        garanteSeleccionadoButton.setEnabled(false);
        escribanoSeleccionadoButton.setEnabled(false);
    }

    private boolean validateFields() {
        return Constants.fechaValidator(fechaDeFinTextField) &&
                Constants.buttonValidator(inquilinoSeleccionadoButton) &&
                Constants.buttonValidator(inmuebleSeleccionadoButton) &&
                Constants.buttonValidator(garanteSeleccionadoButton) &&
                Constants.buttonValidator(escribanoSeleccionadoButton);
    }

    public Alquiler saveFields() {
        if (validateFields()) {
            Alquiler alquiler = new Alquiler();

            alquiler.setFechaFin(fechaDeFinTextField.getText());

            return alquiler;
        } else {
            ApiException.showException(new ApiException(ErrorCode.INVALID_FIELDS));
            return null;
        }
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
