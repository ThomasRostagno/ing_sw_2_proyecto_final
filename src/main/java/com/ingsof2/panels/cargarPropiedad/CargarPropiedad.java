package com.ingsof2.panels.cargarPropiedad;

import com.ingsof2.DAO.BusinessObject;
import com.ingsof2.DAO.DAOZona;
import com.ingsof2.Main;
import com.ingsof2.Objetos.*;
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
import java.time.LocalDate;
import java.util.List;

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
    private JLabel duenioLabel = new JLabel("Dueño:");
    private JLabel duenioSeleccionadoLabel = new JLabel("Dueño seleccionado:");

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
    private JButton duenioButton = new JButton("Dueño");
    private JButton duenioSeleccionadoButton = new JButton("Dueño");

    private final int rows = 6;

    private final int margin = Constants.MARGIN;

    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;

    private final double x = numeroDeAmbientesLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH + xPad + fechaDeConstruccionLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH;
    private final double y = Constants.TEXTFIELD_HEIGHT * rows + (rows - 1) * yPad;

    private final int initialX = (int) (Constants.WIDTH / 2 - x / 2);
    private final int initialY = (int) (Constants.CENTER_HEIGHT / 2 - y / 2);

    private BufferedImage image;


    public CargarPropiedad() {

        tipoComboBox.addItem(Constants.EMPTY_COMBOBOX);
        tipoComboBox.addItem(TiposDePropiedad.DEPARTAMENTO.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.CASA.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.TERRENO.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.GALPON.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.LOCAL_COMERCIAL.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.HOTEL.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.CABANIA.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.CHALET.getTipo());

        condicionComboBox.addItem(Constants.EMPTY_COMBOBOX);
        condicionComboBox.addItem(TiposDeContratos.ALQUILER.getDescripcion());
        condicionComboBox.addItem(TiposDeContratos.VENTA.getDescripcion());
        condicionComboBox.addItem(TiposDeContratos.AMBOS.getDescripcion());

        clasificacionComboBox.addItem(Constants.EMPTY_COMBOBOX);
        clasificacionComboBox.addItem(CondicionesDePropiedad.RESIDENCIAL.getCondicion());
        clasificacionComboBox.addItem(CondicionesDePropiedad.FAMILIAR.getCondicion());
        clasificacionComboBox.addItem(CondicionesDePropiedad.COMERCIAL.getCondicion());
        clasificacionComboBox.addItem(CondicionesDePropiedad.EVENTOS.getCondicion());
        clasificacionComboBox.addItem(CondicionesDePropiedad.NO_HABITABLE.getCondicion());

        duenioButton.addActionListener(e -> {
            Main.mainFrame.goSeleccionarDuenio(duenioSeleccionadoButton);
        });

        BusinessObject<Zona> businessObject = new DAOZona();

        List<Zona> zonas = businessObject.readAll();

        for (Zona zona : zonas) {
            zonaComboBox.addItem(zona);
        }

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
        add(duenioLabel);
        add(duenioButton);
        add(duenioSeleccionadoLabel);
        add(duenioSeleccionadoButton);

        SpringUtilities.makeCompactGrid(this, rows, 4, initialX, initialY, xPad, yPad);
    }

    public CargarPropiedad(Inmueble inmueble) {

        tipoComboBox.addItem(Constants.EMPTY_COMBOBOX);
        tipoComboBox.addItem(TiposDePropiedad.DEPARTAMENTO.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.CASA.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.TERRENO.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.GALPON.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.LOCAL_COMERCIAL.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.HOTEL.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.CABANIA.getTipo());
        tipoComboBox.addItem(TiposDePropiedad.CHALET.getTipo());

        condicionComboBox.addItem(Constants.EMPTY_COMBOBOX);
        condicionComboBox.addItem(TiposDeContratos.ALQUILER.getDescripcion());
        condicionComboBox.addItem(TiposDeContratos.VENTA.getDescripcion());
        condicionComboBox.addItem(TiposDeContratos.AMBOS.getDescripcion());

        clasificacionComboBox.addItem(Constants.EMPTY_COMBOBOX);
        clasificacionComboBox.addItem(CondicionesDePropiedad.RESIDENCIAL.getCondicion());
        clasificacionComboBox.addItem(CondicionesDePropiedad.FAMILIAR.getCondicion());
        clasificacionComboBox.addItem(CondicionesDePropiedad.COMERCIAL.getCondicion());
        clasificacionComboBox.addItem(CondicionesDePropiedad.EVENTOS.getCondicion());
        clasificacionComboBox.addItem(CondicionesDePropiedad.NO_HABITABLE.getCondicion());

        BusinessObject<Zona> businessObject = new DAOZona();

        List<Zona> zonas = businessObject.readAll();

        for (Zona zona : zonas) {
            zonaComboBox.addItem(zona);
        }

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        setLayout(new SpringLayout());

        setSizes();
        checkers();
        setData(inmueble);

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

    private void setData(Inmueble inmueble) {
        tipoComboBox.setSelectedItem(inmueble.getTipo());
        condicionComboBox.setSelectedItem(inmueble.getCondicion());
        direccionTextField.setText(inmueble.getDireccion());
        direccionTextField.setEnabled(false);
        superficieTextField.setText(String.valueOf(inmueble.getSuperficie()));
        numeroDeAmbientesTextField.setText(String.valueOf(inmueble.getNumAmbientes()));
        fechaDeConstruccionTextField.setText(inmueble.getFechaConstruccion());
        antiguedadTextField.setText(String.valueOf(inmueble.getAntiguedad()));
        clasificacionComboBox.setSelectedItem(inmueble.getClasificacion());
        valorTextField.setText(String.valueOf(inmueble.getValor()));

        BusinessObject<Zona> businessObject = new DAOZona();
        Zona zona = businessObject.readOne(inmueble.getCodigoZona());

        zonaComboBox.setSelectedItem(zona.getNombre());
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

        superficieTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
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
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
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
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
                    e.consume();
                }

                if (Constants.fechaValidator(fechaDeConstruccionTextField)) {
                    LocalDate fechaConstruccion = Utils.stringToLocalDate(fechaDeConstruccionTextField.getText());
                    ;
                    antiguedadTextField.setText(String.format("%s", Utils.calculateAntiguedad(fechaConstruccion)));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (Constants.fechaValidator(fechaDeConstruccionTextField)) {
                    LocalDate fechaConstruccion = Utils.stringToLocalDate(fechaDeConstruccionTextField.getText());
                    antiguedadTextField.setText(String.format("%s", Utils.calculateAntiguedad(fechaConstruccion)));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if (Constants.fechaValidator(fechaDeConstruccionTextField)) {
                    LocalDate fechaConstruccion = Utils.stringToLocalDate(fechaDeConstruccionTextField.getText());
                    antiguedadTextField.setText(String.format("%s", Utils.calculateAntiguedad(fechaConstruccion)));
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
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
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
        duenioSeleccionadoButton.setEnabled(false);
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
                Constants.comboBoxValidator(zonaComboBox) &&
                Constants.buttonValidator(duenioSeleccionadoButton);
    }

    public Inmueble saveFields() {
        if (validateFields()) {
            LocalDate fechaConstruccion = Utils.stringToLocalDate(fechaDeConstruccionTextField.getText());
            int antiguedad = Utils.calculateAntiguedad(fechaConstruccion);

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
