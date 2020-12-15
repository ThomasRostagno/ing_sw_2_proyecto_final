package com.ingsof2.DAO;

import com.ingsof2.Objetos.Garante;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOGarante implements BusinessObject<Garante> {

    @Override
    public List<Garante> readAll() {
        List<Garante> garantes = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Garante WHERE (Status=1)");
            Garante garante;
            while (rs.next()) {
                garante = new Garante();
                garante.setNombre(rs.getString("Nombre"));
                garante.setApellido(rs.getString("Apellido"));
                garante.setTelefono(rs.getString("Telefono"));
                garante.setDni(rs.getString("DNI"));
                garante.setSexo(rs.getString("Sexo"));
                garante.setDireccion(rs.getString("Direccion"));
                garante.setFechaNac(rs.getString("Fecha_Nacimiento"));
                garante.setEmail(rs.getString("Email"));
                garantes.add(garante);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return garantes;
    }

    @Override
    public Garante readOne(String... ids) {
        Garante garante = new Garante();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Garante WHERE (Status=1) AND (DNI='" + ids[0] + "') AND (Sexo='" + ids[1] + "')");
            while (rs.next()) {
                garante.setNombre(rs.getString("Nombre"));
                garante.setApellido(rs.getString("Apellido"));
                garante.setTelefono(rs.getString("Telefono"));
                garante.setDni(rs.getString("DNI"));
                garante.setSexo(rs.getString("Sexo"));
                garante.setDireccion(rs.getString("Direccion"));
                garante.setFechaNac(rs.getString("Fecha_Nacimiento"));
                garante.setEmail(rs.getString("Email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return garante;
    }

    @Override
    public int create(Garante garante) {
        String sqlInsert = " INSERT INTO Garante (Nombre, Apellido, Telefono, DNI, Sexo, Direccion, Fecha_Nacimiento, Email, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, garante.getNombre());
            statement.setString(2, garante.getApellido());
            statement.setString(3, garante.getTelefono());
            statement.setString(4, garante.getDni());
            statement.setString(5, garante.getSexo());
            statement.setString(6, garante.getDireccion());
            statement.setString(7, garante.getFechaNac());
            statement.setString(8, garante.getEmail());
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
    public int update(Garante garante) {
        String sqlUpdate = " UPDATE Garante SET Nombre = ?, Apellido = ?, Telefono = ?, Direccion = ?, Fecha_Nacimiento = ?, Email = ? " +
                "WHERE (DNI = '" + garante.getDni() + "') AND (Sexo ='" + garante.getSexo() + "')";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, garante.getNombre());
            statement.setString(2, garante.getApellido());
            statement.setString(3, garante.getTelefono());
            statement.setString(4, garante.getDireccion());
            statement.setString(5, garante.getFechaNac());
            statement.setString(6, garante.getEmail());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int delete(Garante garante) {
        String sqlDelete = " UPDATE Garante SET Status = 0 " +
                "WHERE (DNI = '" + garante.getDni() + "') AND ('" + "Sexo =" + garante.getSexo() + "')";
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
