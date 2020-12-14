package com.ingsof2.DAO;

import com.ingsof2.Objetos.Inquilino;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOInquilino implements BusinessObject<Inquilino> {


    @Override
    public List<Inquilino> readAll() {
        List<Inquilino> inquilinos = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Inquilino WHERE (Status=1)");
            Inquilino inquilino;
            while (rs.next()) {
                inquilino = new Inquilino();
                inquilino.setNombre(rs.getString("Nombre"));
                inquilino.setApellido(rs.getString("Apellido"));
                inquilino.setTelefono(rs.getString("Telefono"));
                inquilino.setDni(rs.getString("DNI"));
                inquilino.setSexo(rs.getString("Sexo"));
                inquilino.setDireccion(rs.getString("Direccion"));
                inquilino.setFechaNac(rs.getString("Fecha_Nacimiento"));
                inquilino.setEmail(rs.getString("Email"));
                inquilinos.add(inquilino);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return inquilinos;
    }

    @Override
    public Inquilino readOne(String... ids) {
        Inquilino inquilino = new Inquilino();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Inquilino WHERE (Status=1) AND (DNI='" + ids[0] + "') AND (Sexo='" + ids[1] + "')");
            while (rs.next()) {
                inquilino.setNombre(rs.getString("Nombre"));
                inquilino.setApellido(rs.getString("Apellido"));
                inquilino.setTelefono(rs.getString("Telefono"));
                inquilino.setDni(rs.getString("DNI"));
                inquilino.setSexo(rs.getString("Sexo"));
                inquilino.setDireccion(rs.getString("Direccion"));
                inquilino.setFechaNac(rs.getString("Fecha_Nacimiento"));
                inquilino.setEmail(rs.getString("Email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return inquilino;
    }


    @Override
    public int create(Inquilino inquilino) {
        String sqlInsert = " INSERT INTO Inquilino (Nombre, Apellido, Telefono, DNI, Sexo, Direccion, Fecha_Nacimiento, Email, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, inquilino.getNombre());
            statement.setString(2, inquilino.getApellido());
            statement.setString(3, inquilino.getTelefono());
            statement.setString(4, inquilino.getDni());
            statement.setString(5, inquilino.getSexo());
            statement.setString(6, inquilino.getDireccion());
            statement.setString(7, inquilino.getFechaNac());
            statement.setString(8, inquilino.getEmail());
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
    public int update(Inquilino inquilino) {
        String sqlUpdate = " UPDATE Inquilino SET Nombre = ?, Apellido = ?, Telefono = ?, Direccion = ?, Fecha_Nacimiento = ?, Email = ?" +
                " WHERE (DNI = '" + inquilino.getDni() + "') AND (Sexo = '" + inquilino.getSexo() + "')";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, inquilino.getNombre());
            statement.setString(2, inquilino.getApellido());
            statement.setString(3, inquilino.getTelefono());
            statement.setString(4, inquilino.getDireccion());
            statement.setString(5, inquilino.getFechaNac());
            statement.setString(6, inquilino.getEmail());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int delete(Inquilino inquilino) {
        String sqlDelete = " UPDATE Inquilino SET Status = 0 " +
                " WHERE (DNI = '" + inquilino.getDni() + "') AND (Sexo = '" + inquilino.getSexo() + "')";
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
