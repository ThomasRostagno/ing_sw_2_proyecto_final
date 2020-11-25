package com.ingsof2.SQLTables;

import com.ingsof2.database.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Tablas {
    /**Querys de Creacion de Tablas de la DB**/

    /*Creacion Inquilino*/
    /*Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Inquilino(" +
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

    /*Creacion Inmueble*/ //Falta la foreign key del dueño
    /*Connection connection = Database.getInstance().getConnection();

    Statement statement;
        try {
        statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE Inmueble(" +
                "Tipo VARCHAR(255) NOT NULL," +
                "Condicion VARCHAR(255) NOT NULL," +
                "Direccion VARCHAR(255) NOT NULL," +
                "Superficie INT NOT NULL," +
                "Num_Ambientes INT NOT NULL," +
                "Fecha_Construccion VARCHAR(255) NOT NULL," +
                "Valor FLOAT NOT NULL," +
                "Clasficacion VARCHAR(255) NOT NULL," +
                "Status INT NOT NULL," +
                "PRIMARY KEY(Direccion)" +
                ")");
    } catch (
    SQLException throwables) {
        throwables.printStackTrace();
    }

        Database.getInstance().disconnect();*/

    /*Creacion Alquiler*/ //Falta la Foreign Key del Inquilino e Inmueble y zona, asi devuelvo los datos de esas cosas xdxdxdddd
    /*Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Alquiler(" +
                    "Codigo VARCHAR(255) NOT NULL," +
                    "Tipo INT NOT NULL," +
                    "Fecha_Contrato VARCHAR(255) NOT NULL," +
                    "Fecha_Fin VARCHAR(255) NOT NULL," +
                    "Precio FLOAT NOT NULL," +
                    "PRIMARY KEY(Codigo)" +
                    ")");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();*/

    /*Creacion Dueño*/ //ESTE TIPO ES CACA, OSEA, SE LLAMA DUENO Y NO DUEñO EN LA DATABASE, TU CULO
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

    /*Creacion (...)*/
}
