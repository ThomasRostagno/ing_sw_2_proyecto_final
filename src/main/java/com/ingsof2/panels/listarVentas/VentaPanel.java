package com.ingsof2.panels.listarVentas;

import com.ingsof2.DAO.*;
import com.ingsof2.Main;
import com.ingsof2.Objetos.Venta;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentaPanel extends JPanel {

    private final JTable table;

    private JLabel campoABuscarLabel = new JLabel("Campo a buscar:");
    private JLabel valorLabel = new JLabel("Valor:");

    private JComboBox<String> campoABuscarComboBox = new JComboBox<>();
    private JTextField valorTextField = new JTextField();

    public VentaPanel() {

        for (Object header : Venta.getHeaders()) {
            campoABuscarComboBox.addItem(header.toString());
        }

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setBackground(Constants.RECT_COLOR);

        DefaultTableModel dm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 5;
            }
        };

        BusinessObject<Venta> businessObject = new DAOVenta();

        List<Venta> ventas = businessObject.readAll();

        Object[][] objects = Venta.getDataVector(ventas);
        Object[] headers = Venta.getHeaders();

        dm.setDataVector(objects, headers);

        table = new JTable(dm);

        table.setFocusable(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);

        table.getColumn("DNI Comprador").setCellRenderer(new ButtonRenderer());
        table.getColumn("DNI Comprador").setCellEditor(new ButtonEditor(new JCheckBox(), new DAOComprador(), true));

        table.getColumn("Dirección Inmueble").setCellRenderer(new ButtonRenderer());
        table.getColumn("Dirección Inmueble").setCellEditor(new ButtonEditor(new JCheckBox(), new DAOInmueble(), false));

        table.getColumn("DNI Vendedor").setCellRenderer(new ButtonRenderer());
        table.getColumn("DNI Vendedor").setCellEditor(new ButtonEditor(new JCheckBox(), new DAOVendedor(), true));

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);

        Utils.setFilter(table, valorTextField, campoABuscarComboBox);

        scrollPane.setPreferredSize(new Dimension(600, 450));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        add(scrollPane, gridBagConstraints);

        campoABuscarLabel.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        campoABuscarLabel.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        campoABuscarLabel.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        add(campoABuscarLabel, gridBagConstraints);

        campoABuscarComboBox.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        campoABuscarComboBox.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        campoABuscarComboBox.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        add(campoABuscarComboBox, gridBagConstraints);

        valorLabel.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        valorLabel.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        valorLabel.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        add(valorLabel, gridBagConstraints);

        valorTextField.setMinimumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        valorTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        valorTextField.setMaximumSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        add(valorTextField, gridBagConstraints);
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
        private String label2;
        private boolean isPushed;
        private boolean isLabel2;
        private BusinessObject businessObject;

        public ButtonEditor(JCheckBox checkBox, BusinessObject businessObject, boolean isLabel2) {
            super(checkBox);
            this.businessObject = businessObject;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });

            this.isLabel2 = isLabel2;
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
            if (isLabel2) {
                label2 = (value == null) ? "" : table.getValueAt(row, column + 1).toString();
            }

            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {

            String[] ids;

            if (isLabel2) {
                ids = new String[]{label, label2};
            } else {
                ids = new String[]{label};
            }

            if (isPushed) {
                Object object = businessObject.readOne(ids);

                Utils.showInformation(Main.mainFrame, object);
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