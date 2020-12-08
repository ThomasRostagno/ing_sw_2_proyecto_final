package com.ingsof2.panels.listarVendedores;

import com.ingsof2.DAO.BusinessObject;
import com.ingsof2.DAO.DAOVendedor;
import com.ingsof2.Objetos.Vendedor;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;
import com.ingsof2.utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VendedorPanel extends JPanel {

    private final JTable table;

    private JLabel campoABuscarLabel = new JLabel("Campo a buscar:");
    private JLabel valorLabel = new JLabel("Valor:");

    private JComboBox<String> campoABuscarComboBox = new JComboBox<>();
    private JTextField valorTextField = new JTextField();

    public VendedorPanel() {

        for (Object header : Vendedor.getHeaders()) {
            campoABuscarComboBox.addItem(header.toString());
        }

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setBackground(Constants.RECT_COLOR);

        DefaultTableModel dm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        BusinessObject<Vendedor> businessObject = new DAOVendedor();

        List<Vendedor> vendedores = businessObject.readAll();

        Object[][] objects = Vendedor.getDataVector(vendedores);
        Object[] headers = Vendedor.getHeaders();

        dm.setDataVector(objects, headers);

        table = new JTable(dm);

        table.setFocusable(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        table.setPreferredScrollableViewportSize(table.getPreferredSize());

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

    public Vendedor getVendedor() {
        int row = table.getSelectedRow();
        int dniColumn = 2;
        int sexoColumn = 4;

        if (row != -1) {
            String dni = table.getValueAt(row, dniColumn).toString();
            String sexo = table.getValueAt(row, sexoColumn).toString();

            BusinessObject<Vendedor> businessObject = new DAOVendedor();

            return businessObject.readOne(dni, sexo);
        }
        ApiException.showException(new ApiException(ErrorCode.FAIL_SELECTING_ESCRIBANO));

        return null;
    }
}