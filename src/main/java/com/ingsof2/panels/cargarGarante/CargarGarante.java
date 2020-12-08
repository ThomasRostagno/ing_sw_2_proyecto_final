package com.ingsof2.panels.cargarGarante;

import com.ingsof2.Objetos.Garante;
import com.ingsof2.Objetos.TiposDeSexo;
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

public class CargarGarante extends JPanel {

    private JLabel nombreLabel = new JLabel("Nombre:");
    private JLabel apellidoLabel = new JLabel("Apellido:");
    private JLabel dniLabel = new JLabel("D.N.I:");
    private JLabel sexoLabel = new JLabel("Sexo:");
    private JLabel direccionLabel = new JLabel("Dirección:");
    private JLabel fechaDeNacimientoLabel = new JLabel("Fecha de nacimiento:");
    private JLabel telefonoLabel = new JLabel("Teléfono:");
    private JLabel emailLabel = new JLabel("Email:");

    private JTextField nombreTextField = new JTextField();
    private JTextField apellidoTextField = new JTextField();
    private JTextField dniTextField = new JTextField();
    private JComboBox<String> sexoComboBox = new JComboBox<>();
    private JTextField direccionTextField = new JTextField();
    private JTextField fechaDeNacimientoTextField = new JTextField();
    private JTextField telefonoTextField = new JTextField();
    private JTextField emailTextField = new JTextField();

    private final int rows = 4;

    private final int margin = Constants.MARGIN;

    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;

    private final double x = direccionLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH + xPad + fechaDeNacimientoLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH;
    private final double y = Constants.TEXTFIELD_HEIGHT * rows + (rows - 1) * yPad;

    private final int initialX = (int) (Constants.WIDTH / 2 - x / 2);
    private final int initialY = (int) (Constants.CENTER_HEIGHT / 2 - y / 2);

    private BufferedImage image;

    public CargarGarante() {

        sexoComboBox.addItem(Constants.EMPTY_COMBOBOX);
        sexoComboBox.addItem(TiposDeSexo.MASCULINO.getSexo());
        sexoComboBox.addItem(TiposDeSexo.FEMENINO.getSexo());

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
        add(direccionLabel);
        add(direccionTextField);
        add(fechaDeNacimientoLabel);
        add(fechaDeNacimientoTextField);
        add(telefonoLabel);
        add(telefonoTextField);
        add(emailLabel);
        add(emailTextField);

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
        direccionTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        direccionTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        direccionTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeNacimientoTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeNacimientoTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeNacimientoTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        telefonoTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        telefonoTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        telefonoTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        emailTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        emailTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        emailTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
    }

    private void checkers() {
        nombreTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isLetter(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
                    e.consume();
                }

                Constants.textValidator(nombreTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.textValidator(nombreTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.textValidator(nombreTextField);
            }
        });

        apellidoTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isLetter(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
                    e.consume();
                }

                Constants.textValidator(apellidoTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.textValidator(apellidoTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.textValidator(apellidoTextField);
            }
        });

        dniTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
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

        direccionTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isLetter(c) || Character.isDigit(c) || (c == ',') || (c == '.') || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
                    e.consume();
                }

                Constants.direccionValidator(direccionTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.direccionValidator(direccionTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.direccionValidator(direccionTextField);
            }
        });

        fechaDeNacimientoTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))) {
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
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
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
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
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
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
    }

    private boolean validateFields() {
        return Constants.textValidator(nombreTextField) &&
                Constants.textValidator(apellidoTextField) &&
                Constants.dniValidator(dniTextField) &&
                Constants.comboBoxValidator(sexoComboBox) &&
                Constants.direccionValidator(direccionTextField) &&
                Constants.fechaValidator(fechaDeNacimientoTextField) &&
                Constants.telefonoValidator(telefonoTextField) &&
                Constants.emailValidator(emailTextField);
    }

    public Garante saveFields() {
        if (validateFields()) {
            return new Garante(nombreTextField.getText(),
                    apellidoTextField.getText(),
                    telefonoTextField.getText(),
                    dniTextField.getText(),
                    sexoComboBox.getItemAt(sexoComboBox.getSelectedIndex()),
                    direccionTextField.getText(),
                    fechaDeNacimientoTextField.getText(),
                    emailTextField.getText(),
                    null);
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
