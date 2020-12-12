package com.ingsof2.DAO;

import com.ingsof2.Objetos.RelationalDuenoInmueble;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAORelationalDuenoInmueble implements BusinessObject<RelationalDuenoInmueble>{

    @Override
    public List<RelationalDuenoInmueble> readAll() {
        List<RelationalDuenoInmueble> rdis = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM RelationalDuenoInmueble");
            RelationalDuenoInmueble rdi;
            while (rs.next()) {
                rdi = new RelationalDuenoInmueble();
                rdi.setDireccion(rs.getString("Direccion"));
                rdi.setDni_duenio(rs.getString("DNI_Dueno"));
                rdi.setSexo_duenio(rs.getString("Sexo_Dueno"));
                rdis.add(rdi);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return rdis;
    }

    @Override
    public RelationalDuenoInmueble readOne(String... ids) {
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        RelationalDuenoInmueble rdi = new RelationalDuenoInmueble();
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM RelationalDuenoInmueble WHERE ( (Direccion='" + ids[0] + "') AND (DNI_Dueno='" + ids[1] + "') AND (Sexo_Dueno='" + ids[2] + "'))");
            while (rs.next()) {
                rdi = new RelationalDuenoInmueble();
                rdi.setDireccion(rs.getString("Direccion"));
                rdi.setDni_duenio(rs.getString("DNI_Dueno"));
                rdi.setSexo_duenio(rs.getString("Sexo_Dueno"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return rdi;
    }

    @Override
    public int create(RelationalDuenoInmueble relationalDuenoInmueble) {
        String sqlInsert = " INSERT INTO RelationalDuenoInmueble (Direccion, DNI_Dueno, Sexo_Dueno)" +
                " VALUES (?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, relationalDuenoInmueble.getDireccion());
            statement.setString(2, relationalDuenoInmueble.getDni_duenio());
            statement.setString(3, relationalDuenoInmueble.getSexo_duenio());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int update(RelationalDuenoInmueble relationalDuenoInmueble) {
        return 0;
    }

    @Override
    public int delete(RelationalDuenoInmueble relationalDuenoInmueble) {
        String sqlDelete = " DELETE From RelationalDuenoInmueble WHERE ( (Direccion='" + relationalDuenoInmueble.getDireccion() + "') AND (DNI_Dueno='" + relationalDuenoInmueble.getDni_duenio() + "') AND (Sexo_Dueno='" + relationalDuenoInmueble.getSexo_duenio() + "'))";
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
