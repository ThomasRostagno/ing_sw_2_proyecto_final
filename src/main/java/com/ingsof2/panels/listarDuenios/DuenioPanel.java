package com.ingsof2.panels.listarDuenios;

import com.ingsof2.DAO.BusinessObject;
import com.ingsof2.DAO.DAODuenio;
import com.ingsof2.Objetos.Duenio;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DuenioPanel extends JPanel {

    private final JTable table;

    public DuenioPanel() {

        BorderLayout borderLayout = new BorderLayout();

        setLayout(borderLayout);

        DefaultTableModel dm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        BusinessObject<Duenio> businessObject = new DAODuenio();

        List<Duenio> duenios = businessObject.readAll();

        Object[][] objects = Duenio.getDataVector(duenios);
        Object[] headers = Duenio.getHeaders();

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

        add(scrollPane, BorderLayout.CENTER);
        add(new JLabel("label combobox"), BorderLayout.PAGE_END);
        add(new JComboBox<String>(), BorderLayout.PAGE_END);
        add(new JLabel("label textfield"), BorderLayout.PAGE_END);
        add(new JTextField(), BorderLayout.PAGE_END);
    }

    public Duenio getDuenio() {
        int row = table.getSelectedRow();
        int dniColumn = 2;
        int sexoColumn = 4;

        if (row != -1) {
            String dni = table.getValueAt(row, dniColumn).toString();
            String sexo = table.getValueAt(row, sexoColumn).toString();

            BusinessObject<Duenio> businessObject = new DAODuenio();

            return businessObject.ReadOne(dni, sexo);
        }
        ApiException.showException(new ApiException(ErrorCode.FAIL_SELECTING_ESCRIBANO));

        return null;
    }
}