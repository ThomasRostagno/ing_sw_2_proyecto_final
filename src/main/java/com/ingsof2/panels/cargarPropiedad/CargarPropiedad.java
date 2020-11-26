package com.ingsof2.panels.cargarPropiedad;

import com.ingsof2.Objetos.Inmueble;
import com.ingsof2.Objetos.Zona;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;
import com.ingsof2.utils.SpringUtilities;
import com.ingsof2.utils.Utils;

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
    private JComboBox<Zona> zonaComboBox = new JComboBox<>();

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

        zonaComboBox.addItem(new Zona("1", "Centrica", "Zona centrica"));
        zonaComboBox.addItem(new Zona("2", "Residencial", "Zona residencial"));
        zonaComboBox.addItem(new Zona("3", "Escolar", "Zona escolar"));
        zonaComboBox.addItem(new Zona("4", "Industrial", "Zona industrial"));
        zonaComboBox.addItem(new Zona("5", "Rural", "Zona rural"));

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        setLayout(new SpringLayout());

        setSizes();
        checkers();

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
        add(zonaComboBox);

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
        zonaComboBox.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        zonaComboBox.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        zonaComboBox.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
    }

    private void checkers() {
        tipoComboBox.addActionListener(e -> Constants.comboBoxValidator(tipoComboBox));

        condicionComboBox.addActionListener(e -> Constants.comboBoxValidator(condicionComboBox));

        direccionTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isLetter(c) || Character.isDigit(c) || (c == ',') || (c == '.') || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
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

        superficieTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.numberValidator(superficieTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.numberValidator(superficieTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.numberValidator(superficieTextField);
            }
        });

        numeroDeAmbientesTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.numberValidator(numeroDeAmbientesTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.numberValidator(numeroDeAmbientesTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.numberValidator(numeroDeAmbientesTextField);
            }
        });

        fechaDeConstruccionTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                if (Constants.fechaValidator(fechaDeConstruccionTextField)) {
                    String fechaConstruccionString = fechaDeConstruccionTextField.getText();
                    String[] fechaConstruccion = fechaConstruccionString.split("/");

                    int dd = Integer.parseInt(fechaConstruccion[0]);
                    int mm = Integer.parseInt(fechaConstruccion[1]);
                    int yy = Integer.parseInt(fechaConstruccion[2]);

                    antiguedadTextField.setText(String.format("%s", Utils.calculateAntiguedad(dd, mm, yy)));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (Constants.fechaValidator(fechaDeConstruccionTextField)) {
                    String fechaConstruccionString = fechaDeConstruccionTextField.getText();
                    String[] fechaConstruccion = fechaConstruccionString.split("/");

                    int dd = Integer.parseInt(fechaConstruccion[0]);
                    int mm = Integer.parseInt(fechaConstruccion[1]);
                    int yy = Integer.parseInt(fechaConstruccion[2]);

                    antiguedadTextField.setText(String.format("%s", Utils.calculateAntiguedad(dd, mm, yy)));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if (Constants.fechaValidator(fechaDeConstruccionTextField)) {
                    String fechaConstruccionString = fechaDeConstruccionTextField.getText();
                    String[] fechaConstruccion = fechaConstruccionString.split("/");

                    int dd = Integer.parseInt(fechaConstruccion[0]);
                    int mm = Integer.parseInt(fechaConstruccion[1]);
                    int yy = Integer.parseInt(fechaConstruccion[2]);

                    antiguedadTextField.setText(String.format("%s", Utils.calculateAntiguedad(dd, mm, yy)));
                }
            }
        });

        antiguedadTextField.setFocusable(false);

        clasificacionComboBox.addActionListener(e -> Constants.comboBoxValidator(clasificacionComboBox));

        valorTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == '.') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter válido");
                    e.consume();
                }

                Constants.floatValidator(valorTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.floatValidator(valorTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.floatValidator(valorTextField);
            }
        });

        zonaComboBox.addActionListener(e -> Constants.comboBoxValidator(zonaComboBox));
    }

    private boolean validateFields() {
        return Constants.comboBoxValidator(tipoComboBox) &&
                Constants.comboBoxValidator(condicionComboBox) &&
                Constants.direccionValidator(direccionTextField) &&
                Constants.numberValidator(superficieTextField) &&
                Constants.numberValidator(numeroDeAmbientesTextField) &&
                Constants.fechaValidator(fechaDeConstruccionTextField) &&
                Constants.floatValidator(valorTextField) &&
                Constants.comboBoxValidator(clasificacionComboBox) &&
                Constants.comboBoxValidator(zonaComboBox);
    }

    public Inmueble saveFields() {
        if (validateFields()) {
            String fechaConstruccionString = fechaDeConstruccionTextField.getText();
            String[] fechaConstruccion = fechaConstruccionString.split("/");

            int dd = Integer.parseInt(fechaConstruccion[0]);
            int mm = Integer.parseInt(fechaConstruccion[1]);
            int yy = Integer.parseInt(fechaConstruccion[2]);

            int antiguedad = Utils.calculateAntiguedad(dd, mm, yy);

            return new Inmueble(tipoComboBox.getItemAt(tipoComboBox.getSelectedIndex()),
                    condicionComboBox.getItemAt(condicionComboBox.getSelectedIndex()),
                    direccionTextField.getText(),
                    Integer.parseInt(superficieTextField.getText()),
                    Integer.parseInt(numeroDeAmbientesTextField.getText()),
                    fechaDeConstruccionTextField.getText(),
                    antiguedad,
                    Float.parseFloat(valorTextField.getText()),
                    clasificacionComboBox.getItemAt(clasificacionComboBox.getSelectedIndex()),
                    null,
                    null,
                    null,
                    zonaComboBox.getItemAt(zonaComboBox.getSelectedIndex()).getCodigo());
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
