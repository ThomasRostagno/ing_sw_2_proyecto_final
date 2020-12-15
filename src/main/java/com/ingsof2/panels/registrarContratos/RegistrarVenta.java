package com.ingsof2.panels.registrarContratos;

import com.ingsof2.Main;
import com.ingsof2.Objetos.Venta;
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

public class RegistrarVenta extends JPanel {

    private JLabel comisionLabel = new JLabel("Comisión:");
    private JLabel compradorLabel = new JLabel("Comprador:");
    private JLabel inmuebleLabel = new JLabel("Inmueble:");
    private JLabel vendedorLabel = new JLabel("Vendedor:");
    private JLabel compradorSeleccionadoLabel = new JLabel("Comprador seleccionado:");
    private JLabel inmuebleSeleccionadoLabel = new JLabel("Inmueble seleccionado:");
    private JLabel vendedorSeleccionadoLabel = new JLabel("Vendedor seleccionado:");

    private JTextField comisionTextField = new JTextField();
    private JButton compradorButton = new JButton("Comprador");
    private JButton inmuebleButton = new JButton("Inmueble");
    private JButton vendedorButton = new JButton("Vendedor");
    private JButton compradorSeleccionadoButton = new JButton("comprador");
    private JButton inmuebleSeleccionadoButton = new JButton("inmueble");
    private JButton vendedorSeleccionadoButton = new JButton("vendedor");

    private final int rows = 4;

    private final int margin = Constants.MARGIN;

    private final int xPad = Constants.X_PAD;
    private final int yPad = Constants.Y_PAD;

    private final double x = compradorLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH + xPad + compradorSeleccionadoLabel.getPreferredSize().getWidth() + xPad + Constants.TEXTFIELD_WIDTH;
    private final double y = Constants.TEXTFIELD_HEIGHT * rows + (rows - 1) * yPad;

    private final int initialX = (int) (Constants.WIDTH / 2 - x / 2);
    private final int initialY = (int) (Constants.CENTER_HEIGHT / 2 - y / 2);

    private BufferedImage image;

    public RegistrarVenta() {

        try {
            image = ImageIO.read(new File(Constants.BACKGROUND));
        } catch (IOException ex) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_GETTING_IMAGE));
        }

        compradorButton.addActionListener(e -> {
            Main.mainFrame.goSeleccionarComprador(compradorSeleccionadoButton);
        });
        inmuebleButton.addActionListener(e -> {
            Main.mainFrame.goSeleccionarInmuebleVenta(inmuebleSeleccionadoButton);
        });
        vendedorButton.addActionListener(e -> {
            Main.mainFrame.goSeleccionarVendedor(vendedorSeleccionadoButton);
        });

        setLayout(new SpringLayout());

        setSizes();
        checkers();

        add(compradorLabel);
        add(compradorButton);
        add(compradorSeleccionadoLabel);
        add(compradorSeleccionadoButton);
        add(inmuebleLabel);
        add(inmuebleButton);
        add(inmuebleSeleccionadoLabel);
        add(inmuebleSeleccionadoButton);
        add(vendedorLabel);
        add(vendedorButton);
        add(vendedorSeleccionadoLabel);
        add(vendedorSeleccionadoButton);
        add(comisionLabel);
        add(comisionTextField);
        add(new JLabel(""));
        add(new JLabel(""));

        SpringUtilities.makeCompactGrid(this, rows, 4, initialX, initialY, xPad, yPad);
    }

    private void setSizes() {
        comisionTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        comisionTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        comisionTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
    }

    private void checkers() {
        comisionTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    ApiException.showException(new ApiException(ErrorCode.INVALID_CHARACTER));
                    e.consume();
                }

                Constants.percentageValidator(comisionTextField);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Constants.percentageValidator(comisionTextField);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                Constants.percentageValidator(comisionTextField);
            }
        });

        compradorSeleccionadoButton.setEnabled(false);
        inmuebleSeleccionadoButton.setEnabled(false);
        vendedorSeleccionadoButton.setEnabled(false);
    }

    private boolean validateFields() {
        return Constants.percentageValidator(comisionTextField) && Constants.buttonValidator(compradorSeleccionadoButton) && Constants.buttonValidator(inmuebleSeleccionadoButton) && Constants.buttonValidator(vendedorSeleccionadoButton);
    }

    public Venta saveFields() {
        if (validateFields()) {
            Venta venta = new Venta();

            venta.setComision(Integer.parseInt(comisionTextField.getText()));

            return venta;
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
