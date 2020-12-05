package com.ingsof2.panels.listarContratosEnVigencia;

import com.ingsof2.DAO.BusinessObject;
import com.ingsof2.DAO.DAOAlquiler;
import com.ingsof2.DAO.DAODuenio;
import com.ingsof2.Objetos.Alquiler;
import com.ingsof2.Objetos.Duenio;
import com.ingsof2.utils.Constants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ContratoEnVigenciaPanel extends JPanel {

    public ContratoEnVigenciaPanel() {

        BorderLayout borderLayout = new BorderLayout();

        setLayout(borderLayout);

        DefaultTableModel dm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 3;
            }
        };

        BusinessObject<Alquiler> businessObject = new DAOAlquiler();

        List<Alquiler> alquileres = businessObject.readAll();

        Object[][] objects = Alquiler.getDataVector(alquileres);
        Object[] headers = Alquiler.getHeaders();

        dm.setDataVector(objects, headers);

        JTable table = new JTable(dm);

        table.setFocusable(false);
        table.setRowSelectionAllowed(false);

        table.getColumn("Inquilino").setCellRenderer(new ButtonRenderer());
        table.getColumn("Inquilino").setCellEditor(new ButtonEditor(new JCheckBox()));

        table.getColumn("Direccion Inmueble").setCellRenderer(new ButtonRenderer());
        table.getColumn("Direccion Inmueble").setCellEditor(new ButtonEditor(new JCheckBox()));

        table.getColumn("Garante").setCellRenderer(new ButtonRenderer());
        table.getColumn("Garante").setCellEditor(new ButtonEditor(new JCheckBox()));

        table.getColumn("Escribano").setCellRenderer(new ButtonRenderer());
        table.getColumn("Escribano").setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);

        add(scrollPane, BorderLayout.CENTER);
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    static class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                JOptionPane.showMessageDialog(button, label + ": Ouch!");
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }
}