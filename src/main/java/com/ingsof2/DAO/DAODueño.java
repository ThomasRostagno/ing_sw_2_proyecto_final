package com.ingsof2.DAO;

import com.ingsof2.Objetos.Dueño;
import com.ingsof2.Objetos.Inquilino;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAODueño implements BusinessObject<Dueño> {
    @Override
    public List<Dueño> readAll() {
        List<Dueño> dueños = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Dueno WHERE (Status==1)");
            Dueño dueño;
            while(rs.next()){
                dueño = new Dueño();
                dueño.setNombre(rs.getString("Nombre"));
                dueño.setApellido(rs.getString("Apellido"));
                dueño.setTelefono(rs.getString("Telefono"));
                dueño.setDni(rs.getInt("DNI"));
                dueño.setTelefono(rs.getString("Sexo"));
                dueño.setTelefono(rs.getString("Direccion"));
                dueño.setTelefono(rs.getString("Fecha_Nacimiento"));
                dueño.setTelefono(rs.getString("Email"));
                dueños.add(dueño);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return dueños;
    }

    @Override
    public int create(Dueño dueño) {
        String sqlInsert =  " INSERT INTO Dueno (Nombre, Apellido, Telefono, DNI, Sexo, Direccion, Fecha_Nacimiento, Email, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1,dueño.getNombre());
            statement.setString(2,dueño.getApellido());
            statement.setString(3,dueño.getTelefono());
            statement.setInt(4,dueño.getDni());
            statement.setString(5,dueño.getSexo());
            statement.setString(6,dueño.getDireccion());
            statement.setString(7,dueño.getFecha_nac());
            statement.setString(8,dueño.getEmail());
            statement.setInt(9,1);
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int update(Dueño dueño) {
        return 0;
    }

    @Override
    public int delete(Dueño dueño) {
        return 0;
    }
}
