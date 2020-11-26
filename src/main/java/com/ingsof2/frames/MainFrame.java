package com.ingsof2.frames;

import com.ingsof2.DAO.*;
import com.ingsof2.Objetos.Duenio;
import com.ingsof2.Objetos.Escribano;
import com.ingsof2.Objetos.Inmueble;
import com.ingsof2.Objetos.Inquilino;
import com.ingsof2.panels.CancelButtonPanel;
import com.ingsof2.panels.add.AddPanel;
import com.ingsof2.panels.add.ButtonsAddPanel;
import com.ingsof2.panels.cargarDuenio.CargarDuenio;
import com.ingsof2.panels.cargarEscribano.CargarEscribano;
import com.ingsof2.panels.cargarInquilino.CargarInquilino;
import com.ingsof2.panels.cargarPropiedad.CargarPropiedad;
import com.ingsof2.panels.delete.BackButtonDeletePanel;
import com.ingsof2.panels.delete.DeletePanel;
import com.ingsof2.panels.listarContratosEnVigencia.ListarContratosEnVigencia;
import com.ingsof2.panels.mainComponents.MainPanel;
import com.ingsof2.panels.registrarAlquiler.RegistrarContrato;
import com.ingsof2.panels.show.BackButtonShowPanel;
import com.ingsof2.panels.show.ShowPanel;
import com.ingsof2.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainPanel mainPanel;

    private AddPanel addPanel;
    private ButtonsAddPanel buttonsAddPanel;
    private ShowPanel showPanel;
    private BackButtonShowPanel backButtonShowPanel;
    private DeletePanel deletePanel;
    private BackButtonDeletePanel backButtonDeletePanel;

    private ListarContratosEnVigencia listarContratosEnVigencia;
    private RegistrarContrato registrarContrato;
    private CargarInquilino cargarInquilino;
    private CargarEscribano cargarEscribano;
    private CargarPropiedad cargarPropiedad;
    private CargarDuenio cargarDuenio;

    private CancelButtonPanel cancelButtonPanel;

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

        addPanel = new AddPanel();
        buttonsAddPanel = new ButtonsAddPanel(null);
        showPanel = new ShowPanel();
        backButtonShowPanel = new BackButtonShowPanel();
        deletePanel = new DeletePanel();
        backButtonDeletePanel = new BackButtonDeletePanel();

        listarContratosEnVigencia = new ListarContratosEnVigencia();
        registrarContrato = new RegistrarContrato();
        cargarInquilino = new CargarInquilino();
        cargarEscribano = new CargarEscribano();
        cargarPropiedad = new CargarPropiedad();
        cargarDuenio = new CargarDuenio();

        cancelButtonPanel = new CancelButtonPanel();
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
        getContentPane().removeAll();
        getContentPane().add(addPanel, BorderLayout.CENTER);
        getContentPane().add(cancelButtonPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goRegistrarContrato() {
        registrarContrato = new RegistrarContrato();
        /*buttonsAddPanel = new ButtonsAddPanel(() -> {
            Contrato contrato = registrarContrato.saveFields();

            if (contrato != null) {
                System.out.println("CARGAR EN BASE DE DATOS:" + contrato.toString());
                showAltaExitosa();
                goAdd();
            }
        });*/
        getContentPane().removeAll();
        getContentPane().add(registrarContrato, BorderLayout.CENTER);
        getContentPane().add(buttonsAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarInquilino() {
        cargarInquilino = new CargarInquilino();
        buttonsAddPanel = new ButtonsAddPanel(() -> {
            Inquilino inquilino = cargarInquilino.saveFields();

            if (inquilino != null) {
                BusinessObject<Inquilino> businessObject = new DAOInquilino();

                businessObject.create(inquilino);
                showAltaExitosa();
                goAdd();
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
        buttonsAddPanel = new ButtonsAddPanel(() -> {
            Escribano escribano = cargarEscribano.saveFields();

            if (escribano != null) {
                BusinessObject<Escribano> businessObject = new DAOEscribano();

                businessObject.create(escribano);
                showAltaExitosa();
                goAdd();
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
        buttonsAddPanel = new ButtonsAddPanel(() -> {
            Inmueble inmueble = cargarPropiedad.saveFields();

            if (inmueble != null) {
                BusinessObject<Inmueble> businessObject = new DAOInmueble();

                businessObject.create(inmueble);
                showAltaExitosa();
                goAdd();
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
        buttonsAddPanel = new ButtonsAddPanel(() -> {
            Duenio duenio = cargarDuenio.saveFields();

            if (duenio != null) {
                BusinessObject<Duenio> businessObject = new DAODueio();

                businessObject.create(duenio);
                showAltaExitosa();
                goAdd();
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
        getContentPane().removeAll();
        getContentPane().add(showPanel, BorderLayout.CENTER);
        getContentPane().add(cancelButtonPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goDelete() {
        deletePanel = new DeletePanel();
        getContentPane().removeAll();
        getContentPane().add(deletePanel, BorderLayout.CENTER);
        getContentPane().add(cancelButtonPanel, BorderLayout.PAGE_END);
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

    private void showAltaExitosa() {
        JOptionPane.showMessageDialog(this, "Alta exitosa");
    }

    public void exit() {
        dispose();
    }
}
