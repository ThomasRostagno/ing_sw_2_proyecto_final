package com.ingsof2.panels.cargarEscribano;

import com.ingsof2.Objetos.Escribano;
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

public class CargarEscribano extends JPanel {

    private JLabel nombreLabel = new JLabel("Nombre:");
    private JLabel apellidoLabel = new JLabel("Apellido:");
    private JLabel dniLabel = new JLabel("D.N.I:");
    private JLabel sexoLabel = new JLabel("Sexo:");
    private JLabel direccionDelEstudioLabel = new JLabel("Dirección del estudio:");
    private JLabel fechaDeNacimientoLabel = new JLabel("Fecha de nacimiento:");
    private JLabel telefonoLabel = new JLabel("Teléfono:");
    private JLabel emailLabel = new JLabel("Email:");
    private JLabel matriculaLabel = new JLabel("Matrícula:");

    private JTextField nombreTextField = new JTextField();
    private JTextField apellidoTextField = new JTextField();
    private JTextField dniTextField = new JTextField();
    private JComboBox<String> sexoComboBox = new JComboBox<>();
    private JTextField direccionDelEstudioTextField = new JTextField();
    private JTextField fechaDeNacimientoTextField = new JTextField();
    private JTextField telefonoTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JTextField matriculaTextField = new JTextField();

    private final int rows = 5;

    private final int margin = Constants.MARGIN;

    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;

    private final double x = direccionDelEstudioLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH + xPad + fechaDeNacimientoLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH;
    private final double y = Constants.TEXTFIELD_HEIGHT * rows + (rows - 1) * yPad;

    private final int initialX = (int) (Constants.WIDTH / 2 - x / 2);
    private final int initialY = (int) (Constants.CENTER_HEIGHT / 2 - y / 2);

    private BufferedImage image;


    public CargarEscribano() {

        sexoComboBox.addItem("");
        sexoComboBox.addItem("Masculino");
        sexoComboBox.addItem("Femenino");

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        setLayout(new SpringLayout());

        setSizes();
        checkers();

        add(nombreLabel);
        add(nombreTextField);
        add(apellidoLabel);
        add(apellidoTextField);
        add(dniLabel);
        add(dniTextField);
        add(sexoLabel);
        add(sexoComboBox);
        add(direccionDelEstudioLabel);
        add(direccionDelEstudioTextField);
        add(fechaDeNacimientoLabel);
        add(fechaDeNacimientoTextField);
        add(telefonoLabel);
        add(telefonoTextField);
        add(emailLabel);
        add(emailTextField);
        add(matriculaLabel);
        add(matriculaTextField);
        add(new JLabel(""));
        add(new JLabel(""));

        SpringUtilities.makeCompactGrid(this, rows, 4, initialX, initialY, xPad, yPad);
    }

    private void setSizes() {
        nombreTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        nombreTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        nombreTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        apellidoTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        apellidoTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        apellidoTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        dniTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        dniTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        dniTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        sexoComboBox.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        sexoComboBox.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        sexoComboBox.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        direccionDelEstudioTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        direccionDelEstudioTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        direccionDelEstudioTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeNacimientoTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeNacimientoTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeNacimientoTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        telefonoTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        telefonoTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        telefonoTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        emailTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        emailTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        emailTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        matriculaTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        matriculaTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        matriculaTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
    }

    private void checkers() {
        nombreTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isLetter(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.nombreYApellidoValidator(nombreTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.nombreYApellidoValidator(nombreTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.nombreYApellidoValidator(nombreTextField);
            }
        });

        apellidoTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isLetter(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.nombreYApellidoValidator(apellidoTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.nombreYApellidoValidator(apellidoTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.nombreYApellidoValidator(apellidoTextField);
            }
        });

        dniTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.dniValidator(dniTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.dniValidator(dniTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.dniValidator(dniTextField);
            }
        });

        sexoComboBox.addActionListener(e -> Constants.comboBoxValidator(sexoComboBox));

        direccionDelEstudioTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isLetter(c) || Character.isDigit(c) || (c == ',') || (c == '.') || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.direccionValidator(direccionDelEstudioTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.direccionValidator(direccionDelEstudioTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.direccionValidator(direccionDelEstudioTextField);
            }
        });

        fechaDeNacimientoTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.fechaValidator(fechaDeNacimientoTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.fechaValidator(fechaDeNacimientoTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.fechaValidator(fechaDeNacimientoTextField);
            }
        });

        telefonoTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == '+') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.telefonoValidator(telefonoTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.telefonoValidator(telefonoTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.telefonoValidator(telefonoTextField);
            }
        });

        emailTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || Character.isLetter(c) || (c == '.') || (c == '-') || (c == '_') || (c == '@') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.emailValidator(emailTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.emailValidator(emailTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.emailValidator(emailTextField);
            }
        });

        matriculaTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.matriculaValidator(matriculaTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.matriculaValidator(matriculaTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.matriculaValidator(matriculaTextField);
            }
        });
    }

    private boolean validateFields() {
        return Constants.nombreYApellidoValidator(nombreTextField) &&
                Constants.nombreYApellidoValidator(apellidoTextField) &&
                Constants.dniValidator(dniTextField) &&
                Constants.comboBoxValidator(sexoComboBox) &&
                Constants.direccionValidator(direccionDelEstudioTextField) &&
                Constants.fechaValidator(fechaDeNacimientoTextField) &&
                Constants.telefonoValidator(telefonoTextField) &&
                Constants.emailValidator(emailTextField) &&
                Constants.matriculaValidator(matriculaTextField);
    }

    public Escribano saveFields() {
        if (validateFields()) {
            return new Escribano(nombreTextField.getText(),
                    apellidoTextField.getText(),
                    telefonoTextField.getText(),
                    dniTextField.getText(),
                    sexoComboBox.getItemAt(sexoComboBox.getSelectedIndex()),
                    direccionDelEstudioTextField.getText(),
                    fechaDeNacimientoTextField.getText(),
                    emailTextField.getText(),
                    matriculaTextField.getText());
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
