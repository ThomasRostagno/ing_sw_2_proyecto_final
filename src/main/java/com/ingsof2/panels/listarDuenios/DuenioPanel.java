package com.ingsof2.panels.listarDuenios;

import com.ingsof2.DAO.BusinessObject;
import com.ingsof2.DAO.DAODueio;
import com.ingsof2.DAO.DAOInquilino;
import com.ingsof2.Objetos.Duenio;
import com.ingsof2.Objetos.Inquilino;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DuenioPanel extends JPanel {

    public DuenioPanel() {

        BorderLayout borderLayout = new BorderLayout();

        setLayout(borderLayout);

        DefaultTableModel dm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 3;
            }
        };

        BusinessObject<Duenio> businessObject = new DAODueio();

        List<Duenio> duenios = businessObject.readAll();

        Object[][] objects = Duenio.getDataVector(duenios);
        Object[] headers = Duenio.getHeaders();

        dm.setDataVector(objects, headers);

        JTable table = new JTable(dm);

        table.setFocusable(false);
        table.setRowSelectionAllowed(false);

        /*table.getColumn("Inquilino").setCellRenderer(new ButtonRenderer());
        table.getColumn("Inquilino").setCellEditor(new ButtonEditor(new JCheckBox()));

        table.getColumn("Propiedad").setCellRenderer(new ButtonRenderer());
        table.getColumn("Propiedad").setCellEditor(new ButtonEditor(new JCheckBox()));

        table.getColumn("Duenio").setCellRenderer(new ButtonRenderer());
        table.getColumn("Duenio").setCellEditor(new ButtonEditor(new JCheckBox()));*/

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        /*table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);*/

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