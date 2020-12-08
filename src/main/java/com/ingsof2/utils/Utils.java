package com.ingsof2.utils;

import com.ingsof2.Objetos.Alquiler;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public enum Utils {
    INSTANCE;

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static LocalDate stringToLocalDate(String fecha) {
        String[] fechaADia = fecha.split("/");

        int dd = Integer.parseInt(fechaADia[0]);
        int mm = Integer.parseInt(fechaADia[1]);
        int yy = Integer.parseInt(fechaADia[2]);
        LocalDate date = LocalDate.of(yy, mm, dd);
        return date;
    }

    public static int calculateAntiguedad(LocalDate ageBuilding) {
        LocalDate today = LocalDate.now();

        return (int) ChronoUnit.YEARS.between(ageBuilding, today);
    }

    public static boolean isVigente(int dd, int mm, int yy) {
        LocalDate today = LocalDate.now();
        LocalDate agefvigencia = LocalDate.of(yy, mm, dd);
        return (int) ChronoUnit.DAYS.between(today, agefvigencia) > 0;
    }

    public static boolean isPorVencer(int dd, int mm, int yy) {
        LocalDate today = LocalDate.now();
        LocalDate agefvigencia = LocalDate.of(yy, mm, dd);
        return (int) ChronoUnit.DAYS.between(today, agefvigencia) > 0 && (int) ChronoUnit.DAYS.between(today, agefvigencia) <= 90;
    }

    public static List<Alquiler> filterAlquileresEnVigencia(List<Alquiler> alquileres) {
        for (int i = alquileres.size() - 1; i >= 0; i--) {
            String date = alquileres.get(i).getFechaFin();
            String[] dateArray = date.split("/");

            int dd = Integer.parseInt(dateArray[0]);
            int mm = Integer.parseInt(dateArray[1]);
            int yy = Integer.parseInt(dateArray[2]);

            if (!isVigente(dd, mm, yy)) {
                alquileres.remove(i);
            }
        }
        return alquileres;
    }

    public static List<Alquiler> filterAlquileresAVencer(List<Alquiler> alquileres) {
        for (int i = alquileres.size() - 1; i >= 0; i--) {
            String date = alquileres.get(i).getFechaFin();
            String[] dateArray = date.split("/");

            int dd = Integer.parseInt(dateArray[0]);
            int mm = Integer.parseInt(dateArray[1]);
            int yy = Integer.parseInt(dateArray[2]);

            if (!isPorVencer(dd, mm, yy)) {
                alquileres.remove(i);
            }
        }
        return alquileres;
    }

    public static List<Alquiler> filterAlquileresVencidos(List<Alquiler> alquileres) {
        for (int i = alquileres.size() - 1; i >= 0; i--) {
            String date = alquileres.get(i).getFechaFin();
            String[] dateArray = date.split("/");

            int dd = Integer.parseInt(dateArray[0]);
            int mm = Integer.parseInt(dateArray[1]);
            int yy = Integer.parseInt(dateArray[2]);

            if (isVigente(dd, mm, yy)) {
                alquileres.remove(i);
            }
        }
        return alquileres;
    }

    public static void showInformation(JFrame frame, Object object) {
        JOptionPane.showMessageDialog(frame, object.toString(), "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }


    public static void setFilter(JTable table, JTextField valorTextField, JComboBox<String> campoABuscarComboBox) {
        valorTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                doFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                doFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                doFilter();
            }

            private void doFilter() {
                String filter = valorTextField.getText();
                TableRowSorter<TableModel> modelo = new TableRowSorter<>(table.getModel());
                if (!filter.equals("")) {
                    modelo.setRowFilter(RowFilter.regexFilter("(?i)" + filter, campoABuscarComboBox.getSelectedIndex()));
                } else {
                    modelo.setRowFilter(null);
                }
                table.setRowSorter(modelo);
            }
        });

        valorTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char c = e.getKeyChar();
                if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }
}
