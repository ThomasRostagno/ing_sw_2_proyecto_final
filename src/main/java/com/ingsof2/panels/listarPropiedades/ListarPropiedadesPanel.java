package com.ingsof2.panels.listarPropiedades;

import com.ingsof2.panels.listarContratosEnVigencia.ContratoEnVigenciaPanel;
import com.ingsof2.utils.Constants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarPropiedadesPanel extends JPanel {
    public ListarPropiedadesPanel() {
        BorderLayout borderLayout = new BorderLayout();

        setLayout(borderLayout);

        DefaultTableModel dm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 3;
            }
        };

        dm.setDataVector(Constants.DATA_VECTOR, Constants.HEADERS);

        JTable table = new JTable(dm);
        table.setFocusable(false);
        //Aca se podria ir a ver los contratos que tiene la propiedad??
        table.getColumn("Contrato").setCellRenderer(new ContratoEnVigenciaPanel.ButtonRenderer());
        table.getColumn("Contrato").setCellEditor(new ContratoEnVigenciaPanel.ButtonEditor(new JCheckBox()));

        table.getColumn("Dueño").setCellRenderer(new ContratoEnVigenciaPanel.ButtonRenderer());
        table.getColumn("Dueño").setCellEditor(new ContratoEnVigenciaPanel.ButtonEditor(new JCheckBox()));

        table.getColumn("Zona").setCellRenderer(new ContratoEnVigenciaPanel.ButtonRenderer());
        table.getColumn("Zona").setCellEditor(new ContratoEnVigenciaPanel.ButtonEditor(new JCheckBox()));
    }
}
