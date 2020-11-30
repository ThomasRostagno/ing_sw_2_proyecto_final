package com.ingsof2.panels.registrarAlquiler;

import com.ingsof2.Objetos.Contrato;
import com.ingsof2.Objetos.Escribano;
import com.ingsof2.Objetos.TiposDeContratos;
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

public class RegistrarContrato extends JPanel {

    private JLabel codigoLabel = new JLabel("Código:");
    private JLabel fechaDeContratoLabel = new JLabel("Fecha de contrato:");
    private JLabel tipoLabel = new JLabel("Tipo:");
    private JLabel precioLabel = new JLabel("Precio:");

    private JTextField codigoTextField = new JTextField();
    private JTextField fechaDeContratoTextField = new JTextField();
    private JComboBox<String> tipoComboBox = new JComboBox<>();
    private JTextField precioTextField = new JTextField();

    private final int rows = 4;

    private final int margin = Constants.MARGIN;

    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;

    private final double x = fechaDeContratoLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH;
    private final double y = Constants.TEXTFIELD_HEIGHT * rows + (rows - 1) * yPad;

    private final int initialX = (int) (Constants.WIDTH / 2 - x / 2);
    private final int initialY = (int) (Constants.CENTER_HEIGHT / 2 - y / 2);

    private BufferedImage image;

    public RegistrarContrato() {

        tipoComboBox.addItem("");
        tipoComboBox.addItem(TiposDeContratos.ALQUILER.getDescripcion());
        tipoComboBox.addItem(TiposDeContratos.VENTA.getDescripcion());
        tipoComboBox.addItem(TiposDeContratos.AMBOS.getDescripcion());

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        setLayout(new SpringLayout());

        setSizes();
        checkers();

        add(codigoLabel);
        add(codigoTextField);
        add(fechaDeContratoLabel);
        add(fechaDeContratoTextField);
        add(tipoLabel);
        add(tipoComboBox);
        add(precioLabel);
        add(precioTextField);

        SpringUtilities.makeCompactGrid(this, rows, 2, initialX, initialY, xPad, yPad);
    }

    private void setSizes() {
        codigoTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        codigoTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        codigoTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeContratoTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeContratoTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeContratoTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        tipoComboBox.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        tipoComboBox.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        tipoComboBox.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        precioTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        precioTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        precioTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
    }

    private void checkers() {
        codigoTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.numberValidator(codigoTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.numberValidator(codigoTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.numberValidator(codigoTextField);
            }
        });

        fechaDeContratoTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.fechaValidator(fechaDeContratoTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.fechaValidator(fechaDeContratoTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.fechaValidator(fechaDeContratoTextField);
            }
        });

        tipoComboBox.addActionListener(e -> Constants.comboBoxValidator(tipoComboBox));

        precioTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == '.') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.floatValidator(precioTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.floatValidator(precioTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.floatValidator(precioTextField);
            }
        });
    }

    private boolean validateFields() {
        return Constants.numberValidator(codigoTextField) &&
                Constants.fechaValidator(fechaDeContratoTextField) &&
                Constants.comboBoxValidator(tipoComboBox) &&
                Constants.floatValidator(precioTextField);
    }

    public Contrato saveFields() {
        if (validateFields()) {
            return new Contrato(codigoTextField.getText(),
                    fechaDeContratoTextField.getText(),
                    Float.parseFloat(precioTextField.getText()),
                    TiposDeContratos.getTipo(tipoComboBox.getItemAt(tipoComboBox.getSelectedIndex())));
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
