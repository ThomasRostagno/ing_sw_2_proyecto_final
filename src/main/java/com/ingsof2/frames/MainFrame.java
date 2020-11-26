package com.ingsof2.frames;

import com.ingsof2.exceptions.ApiException;
import com.ingsof2.panels.CancelButtonPanel;
import com.ingsof2.panels.add.AddPanel;
import com.ingsof2.panels.add.BackButtonAddPanel;
import com.ingsof2.panels.cargarDueño.CargarDueño;
import com.ingsof2.panels.cargarEscribano.CargarEscribano;
import com.ingsof2.panels.cargarPropiedad.CargarPropiedad;
import com.ingsof2.panels.delete.BackButtonDeletePanel;
import com.ingsof2.panels.delete.DeletePanel;
import com.ingsof2.panels.listarContratosEnVigencia.ListarContratosEnVigencia;
import com.ingsof2.panels.mainComponents.MainPanel;
import com.ingsof2.panels.registrarAlquiler.RegistrarAlquiler;
import com.ingsof2.panels.cargarInquilino.CargarInquilino;
import com.ingsof2.panels.show.BackButtonShowPanel;
import com.ingsof2.panels.show.ShowPanel;
import com.ingsof2.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MainPanel mainPanel;

    private AddPanel addPanel;
    private BackButtonAddPanel backButtonAddPanel;
    private ShowPanel showPanel;
    private BackButtonShowPanel backButtonShowPanel;
    private DeletePanel deletePanel;
    private BackButtonDeletePanel backButtonDeletePanel;

    private ListarContratosEnVigencia listarContratosEnVigencia;
    private RegistrarAlquiler registrarAlquiler;
    private CargarInquilino cargarInquilino;
    private CargarEscribano cargarEscribano;
    private CargarPropiedad cargarPropiedad;
    private CargarDueño cargarDueño;

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
        try {
            mainPanel = new MainPanel();

            addPanel = new AddPanel();
            backButtonAddPanel = new BackButtonAddPanel();
            showPanel = new ShowPanel();
            backButtonShowPanel = new BackButtonShowPanel();
            deletePanel = new DeletePanel();
            backButtonDeletePanel = new BackButtonDeletePanel();

            listarContratosEnVigencia = new ListarContratosEnVigencia();
            registrarAlquiler = new RegistrarAlquiler();
            cargarInquilino = new CargarInquilino();
            cargarEscribano = new CargarEscribano();
            cargarPropiedad = new CargarPropiedad();
            cargarDueño = new CargarDueño();

            cancelButtonPanel = new CancelButtonPanel();
        } catch (ApiException e) {
            ApiException.showException(e);
        }
    }

    public void goMainPanel() {
        getContentPane().removeAll();
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void goAdd() {
        getContentPane().removeAll();
        getContentPane().add(addPanel, BorderLayout.CENTER);
        getContentPane().add(cancelButtonPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goShow() {
        getContentPane().removeAll();
        getContentPane().add(showPanel, BorderLayout.CENTER);
        getContentPane().add(cancelButtonPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goDelete() {
        getContentPane().removeAll();
        getContentPane().add(deletePanel, BorderLayout.CENTER);
        getContentPane().add(cancelButtonPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goRegistrarAlquiler() {
        getContentPane().removeAll();
        getContentPane().add(registrarAlquiler, BorderLayout.CENTER);
        getContentPane().add(backButtonAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goListarAlquileresEnVigencia() {
        getContentPane().removeAll();
        getContentPane().add(listarContratosEnVigencia, BorderLayout.CENTER);
        getContentPane().add(backButtonShowPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarInquilino() {
        getContentPane().removeAll();
        getContentPane().add(cargarInquilino, BorderLayout.CENTER);
        getContentPane().add(backButtonAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarEscribano() {
        getContentPane().removeAll();
        getContentPane().add(cargarEscribano, BorderLayout.CENTER);
        getContentPane().add(backButtonAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarPropiedad() {
        getContentPane().removeAll();
        getContentPane().add(cargarPropiedad, BorderLayout.CENTER);
        getContentPane().add(backButtonAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void goCargarDueño() {
        getContentPane().removeAll();
        getContentPane().add(cargarDueño, BorderLayout.CENTER);
        getContentPane().add(backButtonAddPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    public void exit() {
        dispose();
    }

    public Dimension getBackButtonAddPanelPreferedSize() {
        return backButtonAddPanel.getPreferredSize();
    }

    public Dimension getBackButtonDeletePanelPreferedSize() {
        return backButtonDeletePanel.getPreferredSize();
    }

    public Dimension getBackButtonShowPanelPreferedSize() {
        return backButtonShowPanel.getPreferredSize();
    }

    public Dimension getCancelButtonPanelPreferedSize() {
        return cancelButtonPanel.getPreferredSize();
    }


}
