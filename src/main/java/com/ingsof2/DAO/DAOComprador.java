package com.ingsof2.DAO;

import com.ingsof2.Objetos.Comprador;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOComprador implements BusinessObject<Comprador> {
    @Override
    public List<Comprador> readAll() {
        List<Comprador> compradores = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Comprador WHERE (Status=1)");
            Comprador comprador;
            while (rs.next()) {
                comprador = new Comprador();
                comprador.setNombre(rs.getString("Nombre"));
                comprador.setApellido(rs.getString("Apellido"));
                comprador.setTelefono(rs.getString("Telefono"));
                comprador.setDni(rs.getString("DNI"));
                comprador.setSexo(rs.getString("Sexo"));
                comprador.setDireccion(rs.getString("Direccion"));
                comprador.setFechaNac(rs.getString("Fecha_Nacimiento"));
                comprador.setEmail(rs.getString("Email"));
                compradores.add(comprador);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return compradores;
    }

    @Override
    public Comprador readOne(String... ids) {
        Comprador comprador = new Comprador();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Comprador WHERE (Status=1) AND (DNI='" + ids[0] + "') AND (Sexo='" + ids[1] + "')");
            while (rs.next()) {
                comprador.setNombre(rs.getString("Nombre"));
                comprador.setApellido(rs.getString("Apellido"));
                comprador.setTelefono(rs.getString("Telefono"));
                comprador.setDni(rs.getString("DNI"));
                comprador.setSexo(rs.getString("Sexo"));
                comprador.setDireccion(rs.getString("Direccion"));
                comprador.setFechaNac(rs.getString("Fecha_Nacimiento"));
                comprador.setEmail(rs.getString("Email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return comprador;
    }

    @Override
    public int create(Comprador comprador) {
        String sqlInsert = " INSERT INTO Comprador (Nombre, Apellido, Telefono, DNI, Sexo, Direccion, Fecha_Nacimiento, Email, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, comprador.getNombre());
            statement.setString(2, comprador.getApellido());
            statement.setString(3, comprador.getTelefono());
            statement.setString(4, comprador.getDni());
            statement.setString(5, comprador.getSexo());
            statement.setString(6, comprador.getDireccion());
            statement.setString(7, comprador.getFechaNac());
            statement.setString(8, comprador.getEmail());
            statement.setInt(9, 1);
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int update(Comprador comprador) {
        String sqlUpdate = " UPDATE Comprador SET Nombre = ?, Apellido = ?, Telefono = ?, Direccion = ?, Fecha_Nacimiento = ?, Email = ?" +
                " WHERE (DNI = '" + comprador.getDni() + "') AND (Sexo ='" + comprador.getSexo() + "')";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, comprador.getNombre());
            statement.setString(2, comprador.getApellido());
            statement.setString(3, comprador.getTelefono());
            statement.setString(4, comprador.getDireccion());
            statement.setString(5, comprador.getFechaNac());
            statement.setString(6, comprador.getEmail());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int delete(Comprador comprador) {
        String sqlDelete = " UPDATE Comprador SET Status = 0 " +
                "WHERE (DNI = '" + comprador.getDni() + "') AND ('" + "Sexo =" + comprador.getSexo() + "')";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlDelete);
            statement.executeUpdate();
            exito = 1;
        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }
}
