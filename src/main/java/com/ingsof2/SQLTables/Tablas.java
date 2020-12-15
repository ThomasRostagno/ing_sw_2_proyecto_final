package com.ingsof2.SQLTables;

import com.ingsof2.database.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Tablas {
    /**
     * Querys de Creacion de Tablas de la DB
     **/

    public static void tablaInquilino() {
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

    public static void tablaComprador() {
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

    public static void tablaVendedor() {
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

    public static void tablaDuenio() {
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

    public static void tablaEscribano() {
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

    public static void tablaZona() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE Zona(" +
                    "Codigo VARCHAR(255) NOT NULL," +
                    "Nombre VARCHAR(255) NOT NULL," +
                    "Descripcion VARCHAR(255) NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(Codigo)" +
                    ")");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public static void tablaGarante() {
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
                    "Sexo_Inquilino VARCHAR(255)," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(DNI,Sexo)," +
                    "FOREIGN KEY(DNI_Inquilino,Sexo_Inquilino) REFERENCES Inquilino(DNI,Sexo)" +
                    ")");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public static void tablaInmueble() {
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
                    "DNI_Dueno VARCHAR(255) ," +
                    "Sexo_Dueno VARCHAR(255)," +
                    "Codigo_Zona VARCHAR(255)," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(Direccion)," +
                    "FOREIGN KEY (DNI_Dueno,Sexo_Dueno) REFERENCES Dueno(DNI,Sexo)," +
                    "FOREIGN KEY (Codigo_Zona) REFERENCES Zona(Codigo)" +
                    ")");
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public static void relationalDuenoInmueble() {
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE RelationalDuenoInmueble(" +
                    "Direccion VARCHAR(255) NOT NULL," +
                    "DNI_Dueno VARCHAR(255) ," +
                    "Sexo_Dueno VARCHAR(255)," +
                    "PRIMARY KEY(Direccion,DNI_Dueno,Sexo_Dueno)," +
                    "FOREIGN KEY (DNI_Dueno,Sexo_Dueno) REFERENCES Dueno(DNI,Sexo)," +
                    "FOREIGN KEY (Direccion) REFERENCES Inmueble(Direccion)" +
                    ")");
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public static void tablaAlquiler() {
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
                    "Sexo_Inquilino VARCHAR(255) NOT NULL," +
                    "Domicilio_Inmueble VARCHAR(255)," +
                    "DNI_Garante VARCHAR(255) NOT NULL," +
                    "Sexo_Garante VARCHAR(255) NOT NULL," +
                    "DNI_Escribano VARCHAR(255) NOT NULL," +
                    "Sexo_Escribano VARCHAR(255) NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(Codigo)," +
                    "FOREIGN KEY(DNI_Inquilino,Sexo_Inquilino) REFERENCES Inquilino(DNI,Sexo)," +
                    "FOREIGN KEY(DNI_Garante,Sexo_Garante) REFERENCES Garante(DNI,Sexo)," +
                    "FOREIGN KEY(DNI_Escribano,Sexo_Escribano) REFERENCES Escribano(DNI,Sexo)," +
                    "FOREIGN KEY(Domicilio_Inmueble) REFERENCES Inmueble(Direccion)" +
                    ")");
            System.out.println("Create Alquiler");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public static void tablaVenta() {
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
                    "DNI_Comprador VARCHAR(255) NOT NULL," +
                    "Sexo_Comprador VARCHAR(255) NOT NULL," +
                    "Domicilio_Inmueble VARCHAR(255)," +
                    "DNI_Vendedor VARCHAR(255) NOT NULL," +
                    "Sexo_Vendedor VARCHAR(255) NOT NULL," +
                    "Status INT NOT NULL," +
                    "PRIMARY KEY(Codigo)," +
                    "FOREIGN KEY(DNI_Comprador,Sexo_Comprador) REFERENCES Comprador(DNI,Sexo)," +
                    "FOREIGN KEY(DNI_Vendedor,Sexo_Vendedor) REFERENCES Vendedor(DNI,Sexo)," +
                    "FOREIGN KEY(Domicilio_Inmueble) REFERENCES Inmueble(Direccion)" +
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

    public static void dropInquilino() {
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

    public static void dropComprador() {
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

    public static void dropVendedor() {
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

    public static void dropDuenio() {
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

    public static void dropGarante() {
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

    public static void dropEscribano() {
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

    public static void dropRelationalDuenoInmueble(){
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE RelationalDuenoInmueble");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }

    public static void dropInmueble() {
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

    public static void dropZona() {
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

    public static void dropAlquiler() {
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

    public static void dropVenta() {
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

    public static void dropAllAndCreate() {
        dropRelationalDuenoInmueble();
        dropInmueble();
        dropVenta();
        dropAlquiler();
        dropGarante();
        dropInquilino();
        dropComprador();
        dropVendedor();
        dropDuenio();
        dropEscribano();
        dropZona();

        tablaInquilino();
        tablaComprador();
        tablaVendedor();
        tablaDuenio();
        tablaEscribano();
        tablaZona();
        tablaGarante();
        tablaAlquiler();
        tablaVenta();
        tablaInmueble();
        relationalDuenoInmueble();
    }
}
