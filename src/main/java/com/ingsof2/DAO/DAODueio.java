package com.ingsof2.DAO;

import com.ingsof2.Objetos.Duenio;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAODueio implements BusinessObject<Duenio> {
    @Override
    public List<Duenio> readAll() {
        List<Duenio> duenios = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Dueno WHERE (Status==1)");
            Duenio duenio;
            while (rs.next()) {
                duenio = new Duenio();
                duenio.setNombre(rs.getString("Nombre"));
                duenio.setApellido(rs.getString("Apellido"));
                duenio.setTelefono(rs.getString("Telefono"));
                duenio.setDni(rs.getString("DNI"));
                duenio.setTelefono(rs.getString("Sexo"));
                duenio.setTelefono(rs.getString("Direccion"));
                duenio.setTelefono(rs.getString("Fecha_Nacimiento"));
                duenio.setTelefono(rs.getString("Email"));
                duenios.add(duenio);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return duenios;
    }

    @Override
    public Duenio ReadOne(Duenio duenio) {
        return null;
    }

    @Override
    public int create(Duenio duenio) {
        String sqlInsert = " INSERT INTO Dueno (Nombre, Apellido, Telefono, DNI, Sexo, Direccion, Fecha_Nacimiento, Email, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, duenio.getNombre());
            statement.setString(2, duenio.getApellido());
            statement.setString(3, duenio.getTelefono());
            statement.setString(4, duenio.getDni());
            statement.setString(5, duenio.getSexo());
            statement.setString(6, duenio.getDireccion());
            statement.setString(7, duenio.getFecha_nac());
            statement.setString(8, duenio.getEmail());
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
    public int update(Duenio duenio) {
        String sqlUpdate = " UPDATE Dueno SET Nombre = ?, Apellido = ?, Telefono = ?, Sexo = ?, Direccion = ?, Fecha_Nacimiento = ?, Email = ?" +
                " VALUES (?, ?, ?, ?, ?, ?, ?) WHERE (DNI = '" + duenio.getDni() + "') AND ('" + "Sexo =" + duenio.getSexo() + "')";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, duenio.getNombre());
            statement.setString(2, duenio.getApellido());
            statement.setString(3, duenio.getTelefono());
            statement.setString(4, duenio.getSexo());
            statement.setString(5, duenio.getDireccion());
            statement.setString(6, duenio.getFecha_nac());
            statement.setString(7, duenio.getEmail());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int delete(Duenio duenio) {
        return 0;
    }
}
