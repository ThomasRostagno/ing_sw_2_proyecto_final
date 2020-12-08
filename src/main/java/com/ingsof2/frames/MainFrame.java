package com.ingsof2.frames;

import com.ingsof2.DAO.*;
import com.ingsof2.Main;
import com.ingsof2.Objetos.*;
import com.ingsof2.panels.CancelButtonPanel;
import com.ingsof2.panels.GenericNextBackButtonPanel;
import com.ingsof2.panels.GenericNextBackCreateButtonPanel;
import com.ingsof2.panels.add.AddPanel;
import com.ingsof2.panels.add.ButtonsAddPanel;
import com.ingsof2.panels.add.ButtonsInterface;
import com.ingsof2.panels.cargarComprador.CargarComprador;
import com.ingsof2.panels.cargarDuenio.CargarDuenio;
import com.ingsof2.panels.cargarEscribano.CargarEscribano;
import com.ingsof2.panels.cargarGarante.CargarGarante;
import com.ingsof2.panels.cargarInquilino.CargarInquilino;
import com.ingsof2.panels.cargarPropiedad.CargarPropiedad;
import com.ingsof2.panels.cargarVendedor.CargarVendedor;
import com.ingsof2.panels.cargarZona.CargarZona;
import com.ingsof2.panels.delete.BackButtonDeletePanel;
import com.ingsof2.panels.delete.DeletePanel;
import com.ingsof2.panels.listarAlquileresAVencer.ListarAlquileresAVencer;
import com.ingsof2.panels.listarAlquileresEnVigencia.ListarAlquileresEnVigencia;
import com.ingsof2.panels.listarAlquileresVencidos.ListarAlquileresVencidos;
import com.ingsof2.panels.listarCompradores.ListarCompradores;
import com.ingsof2.panels.listarDuenios.ListarDuenios;
import com.ingsof2.panels.listarEscribanos.ListarEscribanos;
import com.ingsof2.panels.listarGarantes.ListarGarantes;
import com.ingsof2.panels.listarInquilinos.ListarInquilinos;
import com.ingsof2.panels.listarPropiedades.ListarPropiedades;
import com.ingsof2.panels.listarVendedores.ListarVendedores;
import com.ingsof2.panels.listarVentas.ListarVentas;
import com.ingsof2.panels.listarZonas.ListarZonas;
import com.ingsof2.panels.mainComponents.MainPanel;
import com.ingsof2.panels.registrarContratos.RegistrarAlquiler;
import com.ingsof2.panels.registrarContratos.RegistrarContrato;
import com.ingsof2.panels.registrarContratos.RegistrarVenta;
import com.ingsof2.panels.show.BackButtonShowPanel;
import com.ingsof2.panels.show.ShowPanel;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private MainPanel mainPanel;

    private AddPanel addPanel;
    private ButtonsAddPanel buttonsAddPanel;
    private GenericNextBackButtonPanel nextBackButtonRegistrarAlquilerPanel;
    private GenericNextBackButtonPanel nextBackButtonRegistrarVentaPanel;
    private ShowPanel showPanel;
    private BackButtonShowPanel backButtonShowPanel;
    private DeletePanel deletePanel;
    private BackButtonDeletePanel backButtonDeletePanel;

    private ListarAlquileresEnVigencia listarAlquileresEnVigencia;
    private ListarAlquileresAVencer listarAlquileresAVencer;
    private ListarAlquileresVencidos listarAlquileresVencidos;
    private ListarInquilinos listarInquilinos;
    private ListarGarantes listarGarantes;
    private ListarDuenios listarDuenios;
    private ListarEscribanos listarEscribanos;
    private ListarPropiedades listarPropiedades;
    private ListarCompradores listarCompradores;
    private ListarVendedores listarVendedores;
    private ListarVentas listarVentas;
    private ListarZonas listarZonas;
    private RegistrarContrato registrarContrato;
    private RegistrarAlquiler registrarAlquiler;
    private RegistrarVenta registrarVenta;
    private CargarInquilino cargarInquilino;
    private CargarGarante cargarGarante;
    private CargarEscribano cargarEscribano;
    private CargarPropiedad cargarPropiedad;
    private CargarZona cargarZona;
    private CargarDuenio cargarDuenio;
    private CargarComprador cargarComprador;
    private CargarVendedor cargarVendedor;

    private CancelButtonPanel cancelButtonPanel;

    private Contrato contrato;
    private Inquilino inquilino;
    private Comprador comprador;
    private Vendedor vendedor;
    private Inmueble inmueble;
    private Garante garante;
    private Escribano escribano;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setUndecorated(true);

        setSize(Constants.PANEL_DIMENSION);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        setResizable(false);
        setVisible(true);

        goMainPanel();
    }

    public void goMainPanel() {
        mainPanel = new MainPanel();
        getContentPane().removeAll();
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void goAdd() {
        addPanel = new AddPanel();
        cancelButtonPanel = new CancelButtonPanel();
        getContentPane().removeAll();
        getContentPane().add(addPanel, BorderLayout.CENTER);
        getContentPane().add(cancelButtonPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarInquilino() {
        cargarInquilino = new CargarInquilino();
        buttonsAddPanel = new ButtonsAddPanel(new ButtonsInterface() {
            @Override
            public void next() {
                Inquilino inquilino = cargarInquilino.saveFields();

                if (inquilino != null) {
                    BusinessObject<Inquilino> businessObject = new DAOInquilino();

                    if (businessObject.create(inquilino) == 1) {
                        showAltaExitosa();
                        goAdd();
                    }
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(cargarInquilino, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarGarante() {
        cargarGarante = new CargarGarante();
        buttonsAddPanel = new ButtonsAddPanel(new ButtonsInterface() {
            @Override
            public void next() {
                Garante garante = cargarGarante.saveFields();

                if (garante != null) {
                    BusinessObject<Garante> businessObject = new DAOGarante();

                    if (businessObject.create(garante) == 1) {
                        showAltaExitosa();
                        goAdd();
                    }
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(cargarGarante, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goRegistrarContrato() {
        registrarContrato = new RegistrarContrato();
        buttonsAddPanel = new ButtonsAddPanel(new ButtonsInterface() {
            @Override
            public void next() {
                contrato = registrarContrato.saveFields();

                if (contrato != null) {
                    if (TiposDeContratos.ALQUILER.getTipo() == contrato.getTipo()) {
                        goRegistrarAlquiler();
                    } else {
                        goRegistrarVenta();
                    }
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(registrarContrato, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goRegistrarAlquiler() {
        getContentPane().removeAll();
        registrarAlquiler = new RegistrarAlquiler();
        nextBackButtonRegistrarAlquilerPanel = new GenericNextBackButtonPanel(new ButtonsInterface() {
            @Override
            public void next() {
                Alquiler aux = registrarAlquiler.saveFields();

                if (aux != null && inquilino != null && inmueble != null && garante != null && escribano != null) {
                    Alquiler alquiler = new Alquiler(contrato, aux.getFechaFin(), inquilino.getDni(), inmueble.getDireccion(), garante.getDni(), escribano.getDni());

                    BusinessObject<Alquiler> businessObject = new DAOAlquiler();

                    if (businessObject.create(alquiler) == 1) {
                        showAltaExitosa();
                        goAdd();
                    }
                }
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarContrato, BorderLayout.CENTER);
                getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }
        });

        getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
        getContentPane().add(nextBackButtonRegistrarAlquilerPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goSeleccionarInquilino(JButton inquilinoSeleccionadoButton) {
        listarInquilinos = new ListarInquilinos();
        getContentPane().removeAll();
        getContentPane().add(listarInquilinos, BorderLayout.CENTER);
        getContentPane().add(new GenericNextBackCreateButtonPanel(new ButtonsInterface() {
            @Override
            public void next() {
                inquilino = listarInquilinos.getInquilino();

                if (inquilino != null) {
                    inquilinoSeleccionadoButton.setEnabled(true);
                    for (ActionListener al : inquilinoSeleccionadoButton.getActionListeners()) {
                        inquilinoSeleccionadoButton.removeActionListener(al);
                    }
                    inquilinoSeleccionadoButton.addActionListener(e -> {
                        Utils.showInformation(Main.mainFrame, inquilino);
                    });

                    getContentPane().removeAll();
                    getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
                    getContentPane().add(nextBackButtonRegistrarAlquilerPanel, BorderLayout.PAGE_END);
                    revalidate();
                    repaint();
                }
            }

            @Override
            public void create() {
                cargarInquilino = new CargarInquilino();
                getContentPane().removeAll();
                getContentPane().add(cargarInquilino, BorderLayout.CENTER);
                getContentPane().add(new GenericNextBackButtonPanel(new ButtonsInterface() {
                    @Override
                    public void next() {
                        Inquilino inquilino = cargarInquilino.saveFields();

                        if (inquilino != null) {
                            BusinessObject<Inquilino> businessObject = new DAOInquilino();

                            if (businessObject.create(inquilino) == 1) {
                                showAltaExitosa();
                                goSeleccionarEscribano(inquilinoSeleccionadoButton);
                            }
                        }
                    }

                    @Override
                    public void back() {
                        goSeleccionarInquilino(inquilinoSeleccionadoButton);
                    }
                }), BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
                getContentPane().add(nextBackButtonRegistrarAlquilerPanel, BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }
        }), BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goSeleccionarInmuebleAlquiler(JButton inmuebleSeleccionadoButton) {
        listarPropiedades = new ListarPropiedades();
        getContentPane().removeAll();
        getContentPane().add(listarPropiedades, BorderLayout.CENTER);
        getContentPane().add(new GenericNextBackCreateButtonPanel(new ButtonsInterface() {
            @Override
            public void next() {
                inmueble = listarPropiedades.getPropiedad();

                if (inmueble != null) {
                    inmuebleSeleccionadoButton.setEnabled(true);
                    for (ActionListener al : inmuebleSeleccionadoButton.getActionListeners()) {
                        inmuebleSeleccionadoButton.removeActionListener(al);
                    }
                    inmuebleSeleccionadoButton.addActionListener(e -> {
                        Utils.showInformation(Main.mainFrame, inmueble);
                    });

                    getContentPane().removeAll();
                    getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
                    getContentPane().add(nextBackButtonRegistrarAlquilerPanel, BorderLayout.PAGE_END);
                    revalidate();
                    repaint();
                }
            }

            @Override
            public void create() {
                cargarPropiedad = new CargarPropiedad();
                getContentPane().removeAll();
                getContentPane().add(cargarPropiedad, BorderLayout.CENTER);
                getContentPane().add(new GenericNextBackButtonPanel(new ButtonsInterface() {
                    @Override
                    public void next() {
                        Inmueble inmueble = cargarPropiedad.saveFields();

                        if (inmueble != null) {
                            BusinessObject<Inmueble> businessObject = new DAOInmueble();

                            if (businessObject.create(inmueble) == 1) {
                                showAltaExitosa();
                                goSeleccionarInmuebleVenta(inmuebleSeleccionadoButton);
                            }
                        }
                    }

                    @Override
                    public void back() {
                        goSeleccionarInmuebleAlquiler(inmuebleSeleccionadoButton);
                    }
                }), BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
                getContentPane().add(nextBackButtonRegistrarAlquilerPanel, BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }
        }), BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goSeleccionarGarante(JButton garanteSeleccionadoButton) {
        listarGarantes = new ListarGarantes();
        getContentPane().removeAll();
        getContentPane().add(listarGarantes, BorderLayout.CENTER);
        getContentPane().add(new GenericNextBackCreateButtonPanel(new ButtonsInterface() {
            @Override
            public void next() {
                garante = listarGarantes.getGarante();

                if (garante != null) {
                    garanteSeleccionadoButton.setEnabled(true);
                    for (ActionListener al : garanteSeleccionadoButton.getActionListeners()) {
                        garanteSeleccionadoButton.removeActionListener(al);
                    }
                    garanteSeleccionadoButton.addActionListener(e -> {
                        Utils.showInformation(Main.mainFrame, garante);
                    });

                    getContentPane().removeAll();
                    getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
                    getContentPane().add(nextBackButtonRegistrarAlquilerPanel, BorderLayout.PAGE_END);
                    revalidate();
                    repaint();
                }
            }

            @Override
            public void create() {
                cargarGarante = new CargarGarante();
                getContentPane().removeAll();
                getContentPane().add(cargarGarante, BorderLayout.CENTER);
                getContentPane().add(new GenericNextBackButtonPanel(new ButtonsInterface() {
                    @Override
                    public void next() {
                        Garante garante = cargarGarante.saveFields();

                        if (garante != null) {
                            BusinessObject<Garante> businessObject = new DAOGarante();

                            if (businessObject.create(garante) == 1) {
                                showAltaExitosa();
                                goSeleccionarEscribano(garanteSeleccionadoButton);
                            }
                        }
                    }

                    @Override
                    public void back() {
                        goSeleccionarGarante(garanteSeleccionadoButton);
                    }
                }), BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
                getContentPane().add(nextBackButtonRegistrarAlquilerPanel, BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }
        }), BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goSeleccionarEscribano(JButton escribanoSeleccionadoButton) {
        listarEscribanos = new ListarEscribanos();
        getContentPane().removeAll();
        getContentPane().add(listarEscribanos, BorderLayout.CENTER);
        getContentPane().add(new GenericNextBackCreateButtonPanel(new ButtonsInterface() {
            @Override
            public void next() {
                escribano = listarEscribanos.getEscribano();

                if (escribano != null) {
                    escribanoSeleccionadoButton.setEnabled(true);
                    for (ActionListener al : escribanoSeleccionadoButton.getActionListeners()) {
                        escribanoSeleccionadoButton.removeActionListener(al);
                    }
                    escribanoSeleccionadoButton.addActionListener(e -> {
                        Utils.showInformation(Main.mainFrame, escribano);
                    });

                    getContentPane().removeAll();
                    getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
                    getContentPane().add(nextBackButtonRegistrarAlquilerPanel, BorderLayout.PAGE_END);
                    revalidate();
                    repaint();
                }
            }

            @Override
            public void create() {
                cargarEscribano = new CargarEscribano();
                getContentPane().removeAll();
                getContentPane().add(cargarEscribano, BorderLayout.CENTER);
                getContentPane().add(new GenericNextBackButtonPanel(new ButtonsInterface() {
                    @Override
                    public void next() {
                        Escribano escribano = cargarEscribano.saveFields();

                        if (escribano != null) {
                            BusinessObject<Escribano> businessObject = new DAOEscribano();

                            if (businessObject.create(escribano) == 1) {
                                showAltaExitosa();
                                goSeleccionarEscribano(escribanoSeleccionadoButton);
                            }
                        }
                    }

                    @Override
                    public void back() {
                        goSeleccionarEscribano(escribanoSeleccionadoButton);
                    }
                }), BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
                getContentPane().add(nextBackButtonRegistrarAlquilerPanel, BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }
        }), BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goRegistrarVenta() {
        getContentPane().removeAll();
        registrarVenta = new RegistrarVenta();
        nextBackButtonRegistrarVentaPanel = new GenericNextBackButtonPanel(new ButtonsInterface() {
            @Override
            public void next() {
                Venta aux = registrarVenta.saveFields();

                if (aux != null && comprador != null && inmueble != null && vendedor != null) {
                    Venta venta = new Venta(contrato, aux.getComision(), comprador.getDni(), inmueble.getDireccion(), vendedor.getDni());

                    BusinessObject<Venta> businessObject = new DAOVenta();

                    if (businessObject.create(venta) == 1) {
                        showAltaExitosa();
                        goAdd();
                    }
                }
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarContrato, BorderLayout.CENTER);
                getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }
        });

        getContentPane().add(registrarVenta, BorderLayout.CENTER);
        getContentPane().add(nextBackButtonRegistrarVentaPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goSeleccionarComprador(JButton compradorSeleccionadoButton) {
        listarCompradores = new ListarCompradores();
        getContentPane().removeAll();
        getContentPane().add(listarCompradores, BorderLayout.CENTER);
        getContentPane().add(new GenericNextBackCreateButtonPanel(new ButtonsInterface() {
            @Override
            public void next() {
                comprador = listarCompradores.getComprador();

                if (comprador != null) {
                    compradorSeleccionadoButton.setEnabled(true);
                    for (ActionListener al : compradorSeleccionadoButton.getActionListeners()) {
                        compradorSeleccionadoButton.removeActionListener(al);
                    }
                    compradorSeleccionadoButton.addActionListener(e -> {
                        Utils.showInformation(Main.mainFrame, comprador);
                    });

                    getContentPane().removeAll();
                    getContentPane().add(registrarVenta, BorderLayout.CENTER);
                    getContentPane().add(nextBackButtonRegistrarVentaPanel, BorderLayout.PAGE_END);
                    revalidate();
                    repaint();
                }
            }

            @Override
            public void create() {
                cargarComprador = new CargarComprador();
                getContentPane().removeAll();
                getContentPane().add(cargarComprador, BorderLayout.CENTER);
                getContentPane().add(new GenericNextBackButtonPanel(new ButtonsInterface() {
                    @Override
                    public void next() {
                        Comprador comprador = cargarComprador.saveFields();

                        if (comprador != null) {
                            BusinessObject<Comprador> businessObject = new DAOComprador();

                            if (businessObject.create(comprador) == 1) {
                                showAltaExitosa();
                                goSeleccionarComprador(compradorSeleccionadoButton);
                            }
                        }
                    }

                    @Override
                    public void back() {
                        goSeleccionarComprador(compradorSeleccionadoButton);
                    }
                }), BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarVenta, BorderLayout.CENTER);
                getContentPane().add(nextBackButtonRegistrarVentaPanel, BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }
        }), BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goSeleccionarInmuebleVenta(JButton inmuebleSeleccionadoButton) {
        listarPropiedades = new ListarPropiedades();
        getContentPane().removeAll();
        getContentPane().add(listarPropiedades, BorderLayout.CENTER);
        getContentPane().add(new GenericNextBackCreateButtonPanel(new ButtonsInterface() {
            @Override
            public void next() {
                inmueble = listarPropiedades.getPropiedad();

                if (inmueble != null) {
                    inmuebleSeleccionadoButton.setEnabled(true);
                    for (ActionListener al : inmuebleSeleccionadoButton.getActionListeners()) {
                        inmuebleSeleccionadoButton.removeActionListener(al);
                    }
                    inmuebleSeleccionadoButton.addActionListener(e -> {
                        Utils.showInformation(Main.mainFrame, inmueble);
                    });

                    getContentPane().removeAll();
                    getContentPane().add(registrarVenta, BorderLayout.CENTER);
                    getContentPane().add(nextBackButtonRegistrarVentaPanel, BorderLayout.PAGE_END);
                    revalidate();
                    repaint();
                }
            }

            @Override
            public void create() {
                cargarPropiedad = new CargarPropiedad();
                getContentPane().removeAll();
                getContentPane().add(cargarPropiedad, BorderLayout.CENTER);
                getContentPane().add(new GenericNextBackButtonPanel(new ButtonsInterface() {
                    @Override
                    public void next() {
                        Inmueble inmueble = cargarPropiedad.saveFields();

                        if (inmueble != null) {
                            BusinessObject<Inmueble> businessObject = new DAOInmueble();

                            if (businessObject.create(inmueble) == 1) {
                                showAltaExitosa();
                                goSeleccionarInmuebleVenta(inmuebleSeleccionadoButton);
                            }
                        }
                    }

                    @Override
                    public void back() {
                        goSeleccionarInmuebleVenta(inmuebleSeleccionadoButton);
                    }
                }), BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarVenta, BorderLayout.CENTER);
                getContentPane().add(nextBackButtonRegistrarVentaPanel, BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }
        }), BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goSeleccionarVendedor(JButton vendedorSeleccionadoButton) {
        listarVendedores = new ListarVendedores();
        getContentPane().removeAll();
        getContentPane().add(listarVendedores, BorderLayout.CENTER);
        getContentPane().add(new GenericNextBackCreateButtonPanel(new ButtonsInterface() {
            @Override
            public void next() {
                vendedor = listarVendedores.getVendedor();

                if (vendedor != null) {
                    vendedorSeleccionadoButton.setEnabled(true);
                    for (ActionListener al : vendedorSeleccionadoButton.getActionListeners()) {
                        vendedorSeleccionadoButton.removeActionListener(al);
                    }
                    vendedorSeleccionadoButton.addActionListener(e -> {
                        Utils.showInformation(Main.mainFrame, vendedor);
                    });

                    getContentPane().removeAll();
                    getContentPane().add(registrarVenta, BorderLayout.CENTER);
                    getContentPane().add(nextBackButtonRegistrarVentaPanel, BorderLayout.PAGE_END);
                    revalidate();
                    repaint();
                }
            }

            @Override
            public void create() {
                cargarVendedor = new CargarVendedor();
                getContentPane().removeAll();
                getContentPane().add(cargarVendedor, BorderLayout.CENTER);
                getContentPane().add(new GenericNextBackButtonPanel(new ButtonsInterface() {
                    @Override
                    public void next() {
                        Vendedor vendedor = cargarVendedor.saveFields();

                        if (vendedor != null) {
                            BusinessObject<Vendedor> businessObject = new DAOVendedor();

                            if (businessObject.create(vendedor) == 1) {
                                showAltaExitosa();
                                goSeleccionarVendedor(vendedorSeleccionadoButton);
                            }
                        }
                    }

                    @Override
                    public void back() {
                        goSeleccionarVendedor(vendedorSeleccionadoButton);
                    }
                }), BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarVenta, BorderLayout.CENTER);
                getContentPane().add(nextBackButtonRegistrarVentaPanel, BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }
        }), BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarPropiedad() {
        cargarPropiedad = new CargarPropiedad();
        buttonsAddPanel = new ButtonsAddPanel(new ButtonsInterface() {
            @Override
            public void next() {
                Inmueble inmueble = cargarPropiedad.saveFields();

                if (inmueble != null) {
                    BusinessObject<Inmueble> businessObject = new DAOInmueble();

                    if (businessObject.create(inmueble) == 1) {
                        showAltaExitosa();
                        goAdd();
                    }
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(cargarPropiedad, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarEscribano() {
        cargarEscribano = new CargarEscribano();
        buttonsAddPanel = new ButtonsAddPanel(new ButtonsInterface() {
            @Override
            public void next() {
                Escribano escribano = cargarEscribano.saveFields();

                if (escribano != null) {
                    BusinessObject<Escribano> businessObject = new DAOEscribano();

                    if (businessObject.create(escribano) == 1) {
                        showAltaExitosa();
                        goAdd();
                    }
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(cargarEscribano, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarDuenio() {
        cargarDuenio = new CargarDuenio();
        buttonsAddPanel = new ButtonsAddPanel(new ButtonsInterface() {
            @Override
            public void next() {
                Duenio duenio = cargarDuenio.saveFields();

                if (duenio != null) {
                    BusinessObject<Duenio> businessObject = new DAODuenio();

                    if (businessObject.create(duenio) == 1) {
                        showAltaExitosa();
                        goAdd();
                    }
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(cargarDuenio, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarComprador() {
        cargarComprador = new CargarComprador();
        buttonsAddPanel = new ButtonsAddPanel(new ButtonsInterface() {
            @Override
            public void next() {
                Comprador comprador = cargarComprador.saveFields();

                if (comprador != null) {
                    BusinessObject<Comprador> businessObject = new DAOComprador();

                    if (businessObject.create(comprador) == 1) {
                        showAltaExitosa();
                        goAdd();
                    }
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(cargarComprador, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarVendedor() {
        cargarVendedor = new CargarVendedor();
        buttonsAddPanel = new ButtonsAddPanel(new ButtonsInterface() {
            @Override
            public void next() {
                Vendedor vendedor = cargarVendedor.saveFields();

                if (vendedor != null) {
                    BusinessObject<Vendedor> businessObject = new DAOVendedor();

                    if (businessObject.create(vendedor) == 1) {
                        showAltaExitosa();
                        goAdd();
                    }
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(cargarVendedor, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarZona() {
        cargarZona = new CargarZona();
        buttonsAddPanel = new ButtonsAddPanel(new ButtonsInterface() {
            @Override
            public void next() {
                Zona zona = cargarZona.saveFields();

                if (zona != null) {
                    BusinessObject<Zona> businessObject = new DAOZona();

                    if (businessObject.create(zona) == 1) {
                        showAltaExitosa();
                        goAdd();
                    }
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(cargarZona, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goModificarInquilino() {
    }

    public void goModificarGarante() {
    }

    public void goModificarAlquiler() {
    }

    public void goModificarVenta() {
    }

    public void goModificarPropiedad() {
    }

    public void goModificarEscribano() {
    }

    public void goModificarDuenio() {
    }

    public void goModificarComprador() {
    }

    public void goModificarVendedor() {
    }

    public void goModificarZona() {
    }

    public void goShow() {
        showPanel = new ShowPanel();
        cancelButtonPanel = new CancelButtonPanel();
        getContentPane().removeAll();
        getContentPane().add(showPanel, BorderLayout.CENTER);
        getContentPane().add(cancelButtonPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarInquilinos() {
        listarInquilinos = new ListarInquilinos();
        backButtonShowPanel = new BackButtonShowPanel();
        getContentPane().removeAll();
        getContentPane().add(listarInquilinos, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarGarantes() {
        listarGarantes = new ListarGarantes();
        backButtonShowPanel = new BackButtonShowPanel();
        getContentPane().removeAll();
        getContentPane().add(listarGarantes, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarAlquileresEnVigencia() {
        listarAlquileresEnVigencia = new ListarAlquileresEnVigencia();
        backButtonShowPanel = new BackButtonShowPanel();
        getContentPane().removeAll();
        getContentPane().add(listarAlquileresEnVigencia, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarAlquileresAVencer() {
        listarAlquileresAVencer = new ListarAlquileresAVencer();
        backButtonShowPanel = new BackButtonShowPanel();
        getContentPane().removeAll();
        getContentPane().add(listarAlquileresAVencer, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarAlquileresVencidos() {
        listarAlquileresVencidos = new ListarAlquileresVencidos();
        backButtonShowPanel = new BackButtonShowPanel();
        getContentPane().removeAll();
        getContentPane().add(listarAlquileresVencidos, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarVentas() {
        listarVentas = new ListarVentas();
        backButtonShowPanel = new BackButtonShowPanel();
        getContentPane().removeAll();
        getContentPane().add(listarVentas, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarPropiedades() {
        listarPropiedades = new ListarPropiedades();
        backButtonShowPanel = new BackButtonShowPanel();
        getContentPane().removeAll();
        getContentPane().add(listarPropiedades, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarEscribanos() {
        listarEscribanos = new ListarEscribanos();
        backButtonShowPanel = new BackButtonShowPanel();
        getContentPane().removeAll();
        getContentPane().add(listarEscribanos, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarDuenios() {
        listarDuenios = new ListarDuenios();
        backButtonShowPanel = new BackButtonShowPanel();
        getContentPane().removeAll();
        getContentPane().add(listarDuenios, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarCompradores() {
        listarCompradores = new ListarCompradores();
        backButtonShowPanel = new BackButtonShowPanel();
        getContentPane().removeAll();
        getContentPane().add(listarCompradores, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarVendedores() {
        listarVendedores = new ListarVendedores();
        backButtonShowPanel = new BackButtonShowPanel();
        getContentPane().removeAll();
        getContentPane().add(listarVendedores, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarZonas() {
        listarZonas = new ListarZonas();
        backButtonShowPanel = new BackButtonShowPanel();
        getContentPane().removeAll();
        getContentPane().add(listarZonas, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goDelete() {
        deletePanel = new DeletePanel();
        cancelButtonPanel = new CancelButtonPanel();
        getContentPane().removeAll();
        getContentPane().add(deletePanel, BorderLayout.CENTER);
        getContentPane().add(cancelButtonPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goEliminarInquilino() {
    }

    public void goEliminarGarante() {
    }

    public void goCancelarAlquiler() {
    }

    public void goEliminarVenta() {
    }

    public void goEliminarPropiedad() {
    }

    public void goEliminarEscribano() {
    }

    public void goEliminarDuenio() {
    }

    public void goEliminarComprador() {
    }

    public void goEliminarVendedor() {
    }

    public void goEliminarZona() {
    }

    private void showAltaExitosa() {
        JOptionPane.showMessageDialog(this, "Alta exitosa");
    }

    public void exit() {
        dispose();
    }
}
