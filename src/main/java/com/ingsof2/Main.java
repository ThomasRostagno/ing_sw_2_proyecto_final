package com.ingsof2;

import com.ingsof2.database.Database;
import com.ingsof2.frames.MainFrame;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {

    public static MainFrame mainFrame;

    public static void main(String[] args) {

        mainFrame = new MainFrame();


        /*
        String aux = "30/12/1996";
        int dd= Integer.parseInt(aux.substring(0,2));
        int mm= Integer.parseInt(aux.substring(3,5));
        int yy= Integer.parseInt(aux.substring(6,10));
        LocalDate today = LocalDate.now();
        LocalDate agebuilding = LocalDate.of(yy,mm,dd);
        long longage = ChronoUnit.YEARS.between(agebuilding,today);
        int age = (int)longage;
        System.out.println(dd);
        System.out.println(mm);
        System.out.println(yy);
        System.out.println(age);*/


        /**/

    }
}
