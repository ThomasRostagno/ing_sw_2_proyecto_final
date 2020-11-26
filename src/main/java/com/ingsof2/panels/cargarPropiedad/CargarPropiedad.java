package com.ingsof2.panels.cargarPropiedad;

import com.ingsof2.Objetos.Dueño;
import com.ingsof2.Objetos.Inmueble;
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

public class CargarPropiedad extends JPanel {

    private JLabel tipoLabel = new JLabel("Tipo:");
    private JLabel condicionLabel = new JLabel("Condición:");
    private JLabel direccionLabel = new JLabel("Dirección:");
    private JLabel superficieLabel = new JLabel("Superficie (mt2):");
    private JLabel numeroDeAmbientesLabel = new JLabel("Número de ambientes:");
    private JLabel fechaDeConstruccionLabel = new JLabel("Fecha de construcción:");
    private JLabel antiguedadLabel = new JLabel("Antigüedad:");
    private JLabel clasificacionLabel = new JLabel("Clasificación:");
    private JLabel valorLabel = new JLabel("Valor:");
    private JLabel zonaLabel = new JLabel("Zona:");

    private JComboBox<String> tipoComboBox = new JComboBox<>();
    private JComboBox<String> condicionComboBox = new JComboBox<>();
    private JTextField direccionTextField = new JTextField();
    private JTextField superficieTextField = new JTextField();
    private JTextField numeroDeAmbientesTextField = new JTextField();
    private JTextField fechaDeConstruccionTextField = new JTextField();
    private JTextField antiguedadTextField = new JTextField();
    private JComboBox<String> clasificacionComboBox = new JComboBox<>();
    private JTextField valorTextField = new JTextField();
    private JTextField zonaTextField = new JTextField();

    private final int rows = 5;

    private final int margin = Constants.MARGIN;

    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;

    private final double x = numeroDeAmbientesLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH + xPad + fechaDeConstruccionLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH;
    private final double y = Constants.TEXTFIELD_HEIGHT * rows + (rows - 1) * yPad;

    private final int initialX = (int) (Constants.WIDTH / 2 - x / 2);
    private final int initialY = (int) (Constants.CENTER_HEIGHT / 2 - y / 2);

    private BufferedImage image;


    public CargarPropiedad() {

        tipoComboBox.addItem("");
        tipoComboBox.addItem("Departamento");
        tipoComboBox.addItem("Casa");
        tipoComboBox.addItem("Terreno");
        tipoComboBox.addItem("Galpon");
        tipoComboBox.addItem("Local comercial");
        tipoComboBox.addItem("Hotel");
        tipoComboBox.addItem("Cabaña");
        tipoComboBox.addItem("Chalet");

        condicionComboBox.addItem("");
        condicionComboBox.addItem("Alquiler");
        condicionComboBox.addItem("Venta");
        condicionComboBox.addItem("Ambos");

        clasificacionComboBox.addItem("");
        clasificacionComboBox.addItem("Residencial");
        clasificacionComboBox.addItem("Familiar");
        clasificacionComboBox.addItem("Comercial");
        clasificacionComboBox.addItem("Eventos");
        clasificacionComboBox.addItem("No habitable");

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        setLayout(new SpringLayout());

        setSizes();

        add(tipoLabel);
        add(tipoComboBox);
        add(condicionLabel);
        add(condicionComboBox);
        add(direccionLabel);
        add(direccionTextField);
        add(superficieLabel);
        add(superficieTextField);
        add(numeroDeAmbientesLabel);
        add(numeroDeAmbientesTextField);
        add(fechaDeConstruccionLabel);
        add(fechaDeConstruccionTextField);
        add(antiguedadLabel);
        add(antiguedadTextField);
        add(clasificacionLabel);
        add(clasificacionComboBox);
        add(valorLabel);
        add(valorTextField);
        add(zonaLabel);
        add(zonaTextField);

        SpringUtilities.makeCompactGrid(this, rows, 4, initialX, initialY, xPad, yPad);
    }

    private void setSizes() {
        tipoComboBox.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        tipoComboBox.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        tipoComboBox.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        condicionComboBox.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        condicionComboBox.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        condicionComboBox.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        direccionTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        direccionTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        direccionTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        superficieTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        superficieTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        superficieTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        numeroDeAmbientesTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        numeroDeAmbientesTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        numeroDeAmbientesTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeConstruccionTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeConstruccionTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        fechaDeConstruccionTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        antiguedadTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        antiguedadTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        antiguedadTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        clasificacionComboBox.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        clasificacionComboBox.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        clasificacionComboBox.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        valorTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        valorTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        valorTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        zonaTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        zonaTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        zonaTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
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

        sexoComboBox.addActionListener(e -> Constants.sexoValidator(sexoComboBox));

        direccionDeTrabajoTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isLetter(c) || Character.isDigit(c) || (c == ',') || (c == '.') || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.direccionValidator(direccionDeTrabajoTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.direccionValidator(direccionDeTrabajoTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.direccionValidator(direccionDeTrabajoTextField);
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
    }

    private boolean validateFields() {
        return Constants.nombreYApellidoValidator(nombreTextField) &&
                Constants.nombreYApellidoValidator(apellidoTextField) &&
                Constants.dniValidator(dniTextField) &&
                Constants.sexoValidator(sexoComboBox) &&
                Constants.direccionValidator(direccionDeTrabajoTextField) &&
                Constants.fechaValidator(fechaDeNacimientoTextField) &&
                Constants.telefonoValidator(telefonoTextField) &&
                Constants.emailValidator(emailTextField) &&
                Constants.telefonoValidator(telefonoTextField) &&
                Constants.emailValidator(emailTextField);
    }

    public Inmueble saveFields() {
        if (validateFields()) {
            return new Inmueble(tipoComboBox.getSelectedItem().toString(),
                    condicionComboBox.getSelectedItem().toString(),
                    direccionTextField.getText(),
                    Integer.parseInt(superficieTextField.getText()),
                    Integer.parseInt(numeroDeAmbientesTextField.getText()),
                    fechaDeConstruccionTextField.getText(),
                    2,
                    Float.parseFloat(valorTextField.getText()),
                    clasificacionComboBox.getSelectedItem().toString(),

                    );
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
