package com.ingsof2.DAO;

import com.ingsof2.Objetos.Inquilino;
import com.ingsof2.Objetos.Zona;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOZona implements BusinessObject<Zona> {
    @Override
    public List<Zona> readAll() {
        List<Zona> zonas = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Zona WHERE (Status=1)");
            Zona zona;
            while (rs.next()) {
                zona = new Zona();
                zona.setCodigo(rs.getString("Codigo"));
                zona.setNombre(rs.getString("Nombre"));
                zona.setDescripcion(rs.getString("Descripcion"));
                zonas.add(zona);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return zonas;
    }

    @Override
    public Zona ReadOne(String... ids) {
        Zona zona = new Zona();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Zona WHERE (Status=1) AND (Codigo='"+ids[0]+"')");
            while(rs.next()){
                zona.setCodigo(rs.getString("Codigo"));
                zona.setNombre(rs.getString("Nombre"));
                zona.setDescripcion(rs.getString("Descripcion"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return zona;
    }

    @Override
    public int create(Zona zona) {
        String sqlInsert = " INSERT INTO Zona (Codigo, Nombre, Descripcion, Status)" +
                " VALUES (?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, zona.getCodigo());
            statement.setString(2, zona.getNombre());
            statement.setString(3, zona.getDescripcion());
            statement.setInt(4, 1);
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int update(Zona zona) {
        //TODO: borrar este comentario
        String sqlUpdate = " UPDATE Zona SET Nombre = ?, Descripcion = ?" +
                " VALUES (?, ?) WHERE (Codigo = '" + zona.getCodigo() + "')";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, zona.getNombre());
            statement.setString(2, zona.getDescripcion());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int delete(Zona zona) {
        String sqlDelete = " UPDATE Zona SET Status = 0 " +
                "WHERE (DNI = '" + zona.getCodigo() + "')";
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
