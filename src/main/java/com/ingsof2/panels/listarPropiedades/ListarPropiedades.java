package com.ingsof2.panels.listarPropiedades;

import com.ingsof2.panels.listarContratosEnVigencia.ContratoEnVigenciaPanel;

import javax.swing.*;
import java.awt.*;

public class ListarPropiedades extends JPanel {
    public ListarPropiedades(){
        BorderLayout borderLayout = new BorderLayout();

        setLayout(borderLayout);

        add(new ContratoEnVigenciaPanel(), BorderLayout.CENTER);
    }
}
