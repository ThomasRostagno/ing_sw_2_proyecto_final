package com.ingsof2.panels.listarInquilinos;

import com.ingsof2.DAO.BusinessObject;
import com.ingsof2.DAO.DAOInquilino;
import com.ingsof2.Objetos.Inquilino;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InquilinoPanel extends JPanel {

    private final JTable table;

    public InquilinoPanel() {

        BorderLayout borderLayout = new BorderLayout();

        setLayout(borderLayout);

        DefaultTableModel dm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        BusinessObject<Inquilino> businessObject = new DAOInquilino();

        List<Inquilino> inquilinos = businessObject.readAll();

        Object[][] objects = Inquilino.getDataVector(inquilinos);
        Object[] headers = Inquilino.getHeaders();

        dm.setDataVector(objects, headers);

        table = new JTable(dm);

        table.setFocusable(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);

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

    public Inquilino getInquilino() {
        int row = table.getSelectedRow();
        int dniColumn = 2;
        int sexoColumn = 4;

        if (row != -1) {
            String dni = table.getValueAt(row, dniColumn).toString();
            String sexo = table.getValueAt(row, sexoColumn).toString();

            BusinessObject<Inquilino> businessObject = new DAOInquilino();

            return businessObject.ReadOne(dni, sexo);
        }
        ApiException.showException(new ApiException(ErrorCode.FAIL_SELECTING_ESCRIBANO));

        return null;
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