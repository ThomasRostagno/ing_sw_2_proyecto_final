package com.ingsof2;

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


        /*Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Dueno(" +
                    "Nombre VARCHAR(255) NOT NULL," +
                    "Apellido VARCHAR(255) NOT NULL," +
                    "Telefono VARCHAR(255) NOT NULL," +
                    "DNI INT NOT NULL," +
                    "Sexo VARCHAR(255) NOT NULL," +
                    "Direccion VARCHAR(255) NOT NULL," +
                    "Fecha_Nacimiento VARCHAR(255) NOT NULL," +
                    "Email VARCHAR(255) NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(DNI,Sexo)" +
                    ")");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();*/

    }
}
