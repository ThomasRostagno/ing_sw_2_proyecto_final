package com.ingsof2.panels.listarZonas;

import com.ingsof2.DAO.BusinessObject;
import com.ingsof2.DAO.DAOInquilino;
import com.ingsof2.DAO.DAOZona;
import com.ingsof2.Objetos.Inquilino;
import com.ingsof2.Objetos.Zona;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.Constants;
import com.ingsof2.utils.ErrorCode;
import com.ingsof2.utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ZonaPanel extends JPanel {

    private final JTable table;

    private JLabel campoABuscarLabel = new JLabel("Campo a buscar:");
    private JLabel valorLabel = new JLabel("Valor:");

    private JComboBox<String> campoABuscarComboBox = new JComboBox<>();
    private JTextField valorTextField = new JTextField();

    public ZonaPanel() {

        for (Object header : Zona.getHeaders()) {
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

        BusinessObject<Zona> businessObject = new DAOZona();

        List<Zona> zonas = businessObject.readAll();

        Object[][] objects = Zona.getDataVector(zonas);
        Object[] headers = Zona.getHeaders();

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

    public Zona getZona() {
        int row = table.getSelectedRow();
        int codigoColumn = 0;

        if (row != -1) {
            String codigo = table.getValueAt(row, codigoColumn).toString();

            BusinessObject<Zona> businessObject = new DAOZona();

            return businessObject.readOne(codigo);
        }
        ApiException.showException(new ApiException(ErrorCode.FAIL_SELECTING_ZONA));

        return null;
    }
}