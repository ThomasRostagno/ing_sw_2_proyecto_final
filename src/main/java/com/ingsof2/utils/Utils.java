package com.ingsof2.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public enum Utils {
    INSTANCE;

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static int calculateAntiguedad(int dd, int mm, int yy) {
        LocalDate today = LocalDate.now();

        LocalDate ageBuilding = LocalDate.of(yy, mm, dd);

        return (int) ChronoUnit.YEARS.between(ageBuilding, today);
    }

    public static boolean isValidVigencia(int dd, int mm, int yy) {
        LocalDate today = LocalDate.now();
        LocalDate agefvigencia = LocalDate.of(yy, mm, dd);
        return (int) ChronoUnit.DAYS.between(today, agefvigencia) > 0;
    }
}
