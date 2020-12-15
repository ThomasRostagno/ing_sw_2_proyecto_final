package com.ingsof2.utils;

import com.ingsof2.Objetos.Alquiler;
import com.ingsof2.Objetos.Venta;

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

    public static boolean isPorVencer(int dd, int mm, int yy, int offset) {
        LocalDate today = LocalDate.now();
        LocalDate ageOfVigencia = LocalDate.of(yy, mm, dd);
        return (int) ChronoUnit.DAYS.between(today, ageOfVigencia) > 0 && (int) ChronoUnit.DAYS.between(today, ageOfVigencia) <= offset;
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

    public static List<Alquiler> filterAlquileresAVencer(List<Alquiler> alquileres, int offset) {
        for (int i = alquileres.size() - 1; i >= 0; i--) {
            String date = alquileres.get(i).getFechaFin();
            String[] dateArray = date.split("/");

            int dd = Integer.parseInt(dateArray[0]);
            int mm = Integer.parseInt(dateArray[1]);
            int yy = Integer.parseInt(dateArray[2]);

            if (!isPorVencer(dd, mm, yy, offset)) {
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

    /**
     * Entra una lista de alquileres y un anio, remuevo los alquileres que no se iniciaron ese anio
     **/
    public static List<Alquiler> filterAlquileresPorAnio(List<Alquiler> alquileres, int anio) {
        //Convierto anio de String a entero
        for (int i = alquileres.size() - 1; i >= 0; i--) {
            //Recupero la fecha de inicio en un String, luego lo hago Date y luego recupero anio. Esto se puede mejorar, ya que gasto mucha memoria asi creo.
            String stringDateAlquier = alquileres.get(i).getFecha();
            LocalDate dateAlquiler = Utils.stringToLocalDate(stringDateAlquier);
            int dateYearAlquiler = dateAlquiler.getYear();
            /**Condicional, remueve si los anios son distintos**/
            if (!(dateYearAlquiler == anio)) {
                alquileres.remove(i);
            }
        }
        return alquileres;
    }

    /**
     * Entra una lista de ventas y un anio, remuevo las ventas que no se iniciaron ese anio
     **/
    public static List<Venta> filterVentasPorAnio(List<Venta> ventas, int anio) {
        //Convierto anio de String a entero
        for (int i = ventas.size() - 1; i >= 0; i--) {
            //Recupero la fecha de inicio en un String, luego lo hago Date y luego recupero anio. Esto se puede mejorar, ya que gasto mucha memoria asi creo.
            String stringDateVenta = ventas.get(i).getFecha();
            LocalDate dateVenta = Utils.stringToLocalDate(stringDateVenta);
            int dateYearVenta = dateVenta.getYear();
            /**Condicional, remueve si los anios son distintos**/
            if (!(dateYearVenta == anio)) {
                ventas.remove(i);
            }
        }
        return ventas;
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
