package com.ingsof2.SQLTables;

import com.ingsof2.database.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Tablas {
    /**
     * Querys de Creacion de Tablas de la DB
     **/

    /*Creacion Inquilino*/
    public void TablaInquilino() {
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Inquilino(" +
                    "Nombre VARCHAR(255) NOT NULL," +
                    "Apellido VARCHAR(255) NOT NULL," +
                    "Telefono VARCHAR(255) NOT NULL," +
                    "DNI VARCHAR(255) NOT NULL," +
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
        Database.getInstance().disconnect();
    }

    /*Creacion Comprador*/
    public void TablaComprador() {
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Comprador(" +
                    "Nombre VARCHAR(255) NOT NULL," +
                    "Apellido VARCHAR(255) NOT NULL," +
                    "Telefono VARCHAR(255) NOT NULL," +
                    "DNI VARCHAR(255) NOT NULL," +
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
        Database.getInstance().disconnect();
    }

    /*Creacion Inquilino*/
    public void TablaVendedor() {
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Vendedor(" +
                    "Nombre VARCHAR(255) NOT NULL," +
                    "Apellido VARCHAR(255) NOT NULL," +
                    "Telefono VARCHAR(255) NOT NULL," +
                    "DNI VARCHAR(255) NOT NULL," +
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
        Database.getInstance().disconnect();
    }

    /*Creacion Duenio*/ //Es Duenio
    public void TablaDuenio() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Dueno(" +
                    "Nombre VARCHAR(255) NOT NULL," +
                    "Apellido VARCHAR(255) NOT NULL," +
                    "Telefono VARCHAR(255) NOT NULL," +
                    "DNI VARCHAR(255) NOT NULL," +
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

        Database.getInstance().disconnect();
    }

    /*Creacion Garante*/
    public void TablaGarante() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Garante(" +
                    "Nombre VARCHAR(255) NOT NULL," +
                    "Apellido VARCHAR(255) NOT NULL," +
                    "Telefono VARCHAR(255) NOT NULL," +
                    "DNI VARCHAR(255) NOT NULL," +
                    "Sexo VARCHAR(255) NOT NULL," +
                    "Direccion VARCHAR(255) NOT NULL," +
                    "Fecha_Nacimiento VARCHAR(255) NOT NULL," +
                    "Email VARCHAR(255) NOT NULL," +
                    "DNI_Inquilino VARCHAR(255)," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(DNI,Sexo)" +
                    ")");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    /*Creacion Escribano*/
    public void TablaEscribano() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Escribano(" +
                    "Nombre VARCHAR(255) NOT NULL," +
                    "Apellido VARCHAR(255) NOT NULL," +
                    "Telefono VARCHAR(255) NOT NULL," +
                    "DNI VARCHAR(255) NOT NULL," +
                    "Sexo VARCHAR(255) NOT NULL," +
                    "Direccion VARCHAR(255) NOT NULL," +
                    "Fecha_Nacimiento VARCHAR(255) NOT NULL," +
                    "Email VARCHAR(255) NOT NULL," +
                    "Matricula VARCHAR(255) NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(DNI,Sexo)" +
                    ")");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    /*Creacion Inmueble*/
    public void TablaInmueble() {
        Connection connection = Database.getInstance().getConnection();

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
                    "Clasificacion VARCHAR(255) NOT NULL," +
                    "DNI_Inquilino VARCHAR(255)," +
                    "DNI_Dueno VARCHAR(255) ," +
                    "Codigo_Alquiler VARCHAR(255)," +
                    "Codigo_Zona VARCHAR(255)," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(Direccion)" +
                    ")");
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    /*Creacion Zona*/
    public void TablaZona() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Zona(" +
                    "Codigo VARCHAR(255) NOT NULL," +
                    "Nombre VARCHAR(255) NOT NULL," +
                    "Descripcion VARCHAR(255) NOT NULL," +
                    "PRIMARY KEY(Codigo)" +
                    ")");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    /*Creacion Alquiler*/
    public void TablaAlquiler() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Alquiler(" +
                    "Codigo VARCHAR(255) NOT NULL," +
                    "Tipo INT NOT NULL," +
                    "Fecha_Contrato VARCHAR(255) NOT NULL," +
                    "Fecha_Fin VARCHAR(255) NOT NULL," +
                    "Precio FLOAT NOT NULL," +
                    "DNI_Inquilino VARCHAR(255) NOT NULL," +
                    "Domicilio_Inmueble VARCHAR(255)," +
                    "DNI_Garante VARCHAR(255) NOT NULL," +
                    "DNI_Escribano VARCHAR(255) NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(Codigo)" +
                    ")");
            System.out.println("Create Alquiler");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    /*Creacion Venta*/
    public void TablaVenta() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Venta(" +
                    "Codigo VARCHAR(255) NOT NULL," +
                    "Tipo INT NOT NULL," +
                    "Fecha_Contrato VARCHAR(255) NOT NULL," +
                    "Comision INT NOT NULL," +
                    "Precio FLOAT NOT NULL," +
                    "DNI_Comprador INT NOT NULL," +
                    "Domicilio_Inmueble VARCHAR(255)," +
                    "DNI_Vendedor INT NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(Codigo)" +
                    ")");
            System.out.println("Create Venta");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    /**
     * Querys de Drop de las Tablas de la BD
     **/

    public void DropInquilino() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Inquilino");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public void DropComprador() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Comprador");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public void DropVendedor() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Vendedor");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public void DropDuenio() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Dueno");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public void DropGarante() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Garante");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public void DropEscribano() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Escribano");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public void DropInmueble() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Inmueble");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public void DropZona() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Zona");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public void DropAlquiler() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Alquiler");
            System.out.println("Drop Alquiler");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public void DropVenta() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE Venta");
            System.out.println("Drop Venta");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }


}
