package com.ingsof2.frames;

import com.ingsof2.DAO.*;
import com.ingsof2.Main;
import com.ingsof2.Objetos.*;
import com.ingsof2.panels.CancelButtonPanel;
import com.ingsof2.panels.GenericNextBackButtonPanel;
import com.ingsof2.panels.add.AddPanel;
import com.ingsof2.panels.add.ButtonsAddPanel;
import com.ingsof2.panels.add.NextBackButtonsInterface;
import com.ingsof2.panels.cargarDuenio.CargarDuenio;
import com.ingsof2.panels.cargarEscribano.CargarEscribano;
import com.ingsof2.panels.cargarInquilino.CargarInquilino;
import com.ingsof2.panels.cargarPropiedad.CargarPropiedad;
import com.ingsof2.panels.delete.BackButtonDeletePanel;
import com.ingsof2.panels.delete.DeletePanel;
import com.ingsof2.panels.listarContratosEnVigencia.ListarContratosEnVigencia;
import com.ingsof2.panels.listarDuenios.ListarDuenios;
import com.ingsof2.panels.listarEscribanos.ListarEscribanos;
import com.ingsof2.panels.listarInquilinos.ListarInquilinos;
import com.ingsof2.panels.listarPropiedades.ListarPropiedades;
import com.ingsof2.panels.mainComponents.MainPanel;
import com.ingsof2.panels.registrarAlquiler.RegistrarAlquiler;
import com.ingsof2.panels.registrarAlquiler.RegistrarContrato;
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
    private GenericNextBackButtonPanel nextBackButtonPanel;
    private ShowPanel showPanel;
    private BackButtonShowPanel backButtonShowPanel;
    private DeletePanel deletePanel;
    private BackButtonDeletePanel backButtonDeletePanel;

    private ListarContratosEnVigencia listarContratosEnVigencia;
    private ListarInquilinos listarInquilinos;
    private ListarDuenios listarDuenios;
    private ListarEscribanos listarEscribanos;
    private ListarPropiedades listarPropiedades;
    private RegistrarContrato registrarContrato;
    private RegistrarAlquiler registrarAlquiler;
    private CargarInquilino cargarInquilino;
    private CargarEscribano cargarEscribano;
    private CargarPropiedad cargarPropiedad;
    private CargarDuenio cargarDuenio;

    private CancelButtonPanel cancelButtonPanel;

    private Contrato contrato;
    private Inquilino inquilino;
    private Inmueble inmueble;
    private Inquilino garante;
    private Escribano escribano;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setUndecorated(true);

        setSize(Constants.PANEL_DIMENSION);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        setResizable(false);

        setVisible(true);

        initComponents();

        goMainPanel();
    }

    private void initComponents() {
        mainPanel = new MainPanel();

        backButtonShowPanel = new BackButtonShowPanel();//TODO:SACAR
        backButtonDeletePanel = new BackButtonDeletePanel();//TODO: SACAR
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

    public void goRegistrarContrato() {
        registrarContrato = new RegistrarContrato();
        buttonsAddPanel = new ButtonsAddPanel(new NextBackButtonsInterface() {
            @Override
            public void next() {
                contrato = registrarContrato.saveFields();

                if (contrato != null) {
                    //TODO:HACER IF PARA CONTRATO ALQUILER O CONTRATO VENTA
                    getContentPane().removeAll();
                    registrarAlquiler = new RegistrarAlquiler();

                    nextBackButtonPanel = new GenericNextBackButtonPanel(new NextBackButtonsInterface() {
                        @Override
                        public void next() {
                            Alquiler aux = registrarAlquiler.saveFields();

                            if (aux != null) {
                                Alquiler alquiler = new Alquiler(contrato, aux.getFechaFin(), inquilino.getDni(), inmueble.getDireccion(), garante.getDni(), escribano.getDni());

                                BusinessObject<Alquiler> businessObject = new DAOAlquiler();

                                businessObject.create(alquiler);
                                showAltaExitosa();
                                goAdd();
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
                    getContentPane().add(nextBackButtonPanel, BorderLayout.PAGE_END);
                    revalidate();
                    repaint();
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(registrarContrato, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goSeleccionarInquilino(JButton inquilinoSeleccionadoButton) {
        listarInquilinos = new ListarInquilinos();
        getContentPane().removeAll();
        getContentPane().add(listarInquilinos, BorderLayout.CENTER);
        getContentPane().add(new GenericNextBackButtonPanel(new NextBackButtonsInterface() {
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
                    getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
                    revalidate();
                    repaint();
                }
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
                getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }
        }), BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goSeleccionarInmueble(JButton inmuebleSeleccionadoButton) {
        listarPropiedades = new ListarPropiedades();
        getContentPane().removeAll();
        getContentPane().add(listarPropiedades, BorderLayout.CENTER);
        getContentPane().add(new GenericNextBackButtonPanel(new NextBackButtonsInterface() {
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
                    getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
                    revalidate();
                    repaint();
                }
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
                getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }
        }), BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goSeleccionarGarante(JButton garanteSeleccionadoButton) {
        listarInquilinos = new ListarInquilinos();
        getContentPane().removeAll();
        getContentPane().add(listarInquilinos, BorderLayout.CENTER);
        getContentPane().add(new GenericNextBackButtonPanel(new NextBackButtonsInterface() {
            @Override
            public void next() {
                garante = listarInquilinos.getInquilino();

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
                    getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
                    revalidate();
                    repaint();
                }
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
                getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
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
        getContentPane().add(new GenericNextBackButtonPanel(new NextBackButtonsInterface() {
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
                    getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
                    revalidate();
                    repaint();
                }
            }

            @Override
            public void back() {
                getContentPane().removeAll();
                getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
                getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
                revalidate();
                repaint();
            }
        }), BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarInquilino() {
        cargarInquilino = new CargarInquilino();
        buttonsAddPanel = new ButtonsAddPanel(new NextBackButtonsInterface() {
            @Override
            public void next() {
                Inquilino inquilino = cargarInquilino.saveFields();

                if (inquilino != null) {
                    BusinessObject<Inquilino> businessObject = new DAOInquilino();

                    businessObject.create(inquilino);
                    showAltaExitosa();
                    goAdd();
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(cargarInquilino, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarEscribano() {
        cargarEscribano = new CargarEscribano();
        buttonsAddPanel = new ButtonsAddPanel(new NextBackButtonsInterface() {
            @Override
            public void next() {
                Escribano escribano = cargarEscribano.saveFields();

                if (escribano != null) {
                    BusinessObject<Escribano> businessObject = new DAOEscribano();

                    businessObject.create(escribano);
                    showAltaExitosa();
                    goAdd();
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(cargarEscribano, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarPropiedad() {
        cargarPropiedad = new CargarPropiedad();
        buttonsAddPanel = new ButtonsAddPanel(new NextBackButtonsInterface() {
            @Override
            public void next() {
                Inmueble inmueble = cargarPropiedad.saveFields();

                if (inmueble != null) {
                    BusinessObject<Inmueble> businessObject = new DAOInmueble();

                    businessObject.create(inmueble);
                    showAltaExitosa();
                    goAdd();
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(cargarPropiedad, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarDuenio() {
        cargarDuenio = new CargarDuenio();
        buttonsAddPanel = new ButtonsAddPanel(new NextBackButtonsInterface() {
            @Override
            public void next() {
                Duenio duenio = cargarDuenio.saveFields();

                if (duenio != null) {
                    BusinessObject<Duenio> businessObject = new DAODuenio();

                    businessObject.create(duenio);
                    showAltaExitosa();
                    goAdd();
                }
            }
        });
        getContentPane().removeAll();
        getContentPane().add(cargarDuenio, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
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
        getContentPane().removeAll();
        getContentPane().add(listarInquilinos, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarAlquileresEnVigencia() {
        listarContratosEnVigencia = new ListarContratosEnVigencia();
        getContentPane().removeAll();
        getContentPane().add(listarContratosEnVigencia, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarAlquileresVencidos() {
        //listarAlquileresVencidos = new ListarAlquileresVencidos();
        getContentPane().removeAll();
        //getContentPane().add(listarAlquileresVencidos, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarAlquileresAVencer() {
        //listarAlquileresAVencer = new ListarAlquileresAVencer();
        getContentPane().removeAll();
        //getContentPane().add(listarAlquileresAVencer, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarPropiedades() {
        listarPropiedades = new ListarPropiedades();
        getContentPane().removeAll();
        getContentPane().add(listarPropiedades, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarEscribanos() {
        listarEscribanos = new ListarEscribanos();
        getContentPane().removeAll();
        getContentPane().add(listarEscribanos, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarDuenios() {
        listarDuenios = new ListarDuenios();
        getContentPane().removeAll();
        getContentPane().add(listarDuenios, BorderLayout.CENTER);
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

    private void showAltaExitosa() {
        JOptionPane.showMessageDialog(this, "Alta exitosa");
    }

    public void exit() {
        dispose();
    }
}
