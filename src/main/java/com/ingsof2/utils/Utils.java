package com.ingsof2.utils;

import com.ingsof2.Objetos.Inmueble;
import com.ingsof2.Objetos.Inquilino;
import com.ingsof2.Objetos.Persona;

import javax.swing.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public enum Utils {
    INSTANCE;

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static LocalDate stringToLocalDate(String fecha){
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

    public static boolean isValidVigencia(int dd, int mm, int yy) {
        LocalDate today = LocalDate.now();
        LocalDate agefvigencia = LocalDate.of(yy, mm, dd);
        return (int) ChronoUnit.DAYS.between(today, agefvigencia) > 0;
    }

    public static void showInformation(JFrame frame, Persona persona) {
        JOptionPane.showMessageDialog(frame, persona.toString(), "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showInformation(JFrame frame, Inmueble inmueble) {
        JOptionPane.showMessageDialog(frame, inmueble.toString(), "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
