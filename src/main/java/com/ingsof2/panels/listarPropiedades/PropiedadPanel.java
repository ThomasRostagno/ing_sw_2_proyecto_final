package com.ingsof2.panels.listarPropiedades;

import com.ingsof2.DAO.*;
import com.ingsof2.Main;
import com.ingsof2.Objetos.Inmueble;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;
import com.ingsof2.utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PropiedadPanel extends JPanel {

    private final JTable table;

    private JLabel campoABuscarLabel = new JLabel("Campo a buscar:");
    private JLabel valorLabel = new JLabel("Valor:");

    private JComboBox<String> campoABuscarComboBox = new JComboBox<>();
    private JTextField valorTextField = new JTextField();

    public PropiedadPanel() {

        for (Object header : Inmueble.getHeaders()) {
            campoABuscarComboBox.addItem(header.toString());
        }

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setBackground(Constants.RECT_COLOR);

        DefaultTableModel dm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 9;
            }
        };

        BusinessObject<Inmueble> businessObject = new DAOInmueble();

        List<Inmueble> inmuebles = businessObject.readAll();

        Object[][] objects = Inmueble.getDataVector(inmuebles);
        Object[] headers = Inmueble.getHeaders();

        dm.setDataVector(objects, headers);

        table = new JTable(dm);

        table.setFocusable(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);

        table.getColumn("Inquilino").setCellRenderer(new ButtonRenderer());
        table.getColumn("Inquilino").setCellEditor(new ButtonEditor(new JCheckBox(), new DAOInquilino()));

        table.getColumn("Dueño").setCellRenderer(new ButtonRenderer());
        table.getColumn("Dueño").setCellEditor(new ButtonEditor(new JCheckBox(), new DAODuenio()));

        table.getColumn("Alquiler").setCellRenderer(new ButtonRenderer());
        table.getColumn("Alquiler").setCellEditor(new ButtonEditor(new JCheckBox(), new DAOAlquiler()));

        table.getColumn("Zona").setCellRenderer(new ButtonRenderer());
        table.getColumn("Zona").setCellEditor(new ButtonEditor(new JCheckBox(), new DAOZona()));

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        table.getColumnModel().getColumn(9).setPreferredWidth(100);
        table.getColumnModel().getColumn(10).setPreferredWidth(100);
        table.getColumnModel().getColumn(11).setPreferredWidth(100);
        table.getColumnModel().getColumn(12).setPreferredWidth(100);

        Utils.setFilter(table, valorTextField, campoABuscarComboBox);

        scrollPane.setPreferredSize(new Dimension(600, 450));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        add(scrollPane, gridBagConstraints);

        campoABuscarLabel.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        add(campoABuscarLabel, gridBagConstraints);

        campoABuscarComboBox.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        add(campoABuscarComboBox, gridBagConstraints);

        valorLabel.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        add(valorLabel, gridBagConstraints);

        valorTextField.setPreferredSize(new Dimension(Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT));
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        add(valorTextField, gridBagConstraints);
    }

    public Inmueble getPropiedad() {
        int row = table.getSelectedRow();
        int direccionColumn = 2;

        if (row != -1) {
            String direccion = table.getValueAt(row, direccionColumn).toString();

            BusinessObject<Inmueble> businessObject = new DAOInmueble();

            return businessObject.readOne(direccion);
        }
        ApiException.showException(new ApiException(ErrorCode.FAIL_SELECTING_PROPIEDAD));

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
        private BusinessObject businessObject;

        public ButtonEditor(JCheckBox checkBox, BusinessObject businessObject) {
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
                Object object = businessObject.readOne(label);

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