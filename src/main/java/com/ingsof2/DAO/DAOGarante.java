package com.ingsof2.DAO;

import com.ingsof2.Objetos.Garante;
import com.ingsof2.Objetos.Inquilino;
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
            ResultSet rs = statement.executeQuery("SELECT * FROM Inquilino WHERE (Status==1)");
            Garante garante;
            while(rs.next()){
                garante = new Garante();
                garante.setNombre(rs.getString("Nombre"));
                garante.setApellido(rs.getString("Apellido"));
                garante.setTelefono(rs.getString("Telefono"));
                garante.setDni(rs.getInt("DNI"));
                garante.setTelefono(rs.getString("Sexo"));
                garante.setTelefono(rs.getString("Direccion"));
                garante.setTelefono(rs.getString("Fecha_Nacimiento"));
                garante.setTelefono(rs.getString("Email"));
                garantes.add(garante);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return garantes;
    }

    @Override
    public int create(Garante garante) {
        String sqlInsert =  " INSERT INTO Garante (Nombre, Apellido, Telefono, DNI, Sexo, Direccion, Fecha_Nacimiento, Email, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1,garante.getNombre());
            statement.setString(2,garante.getApellido());
            statement.setString(3,garante.getTelefono());
            statement.setInt(4,garante.getDni());
            statement.setString(5,garante.getSexo());
            statement.setString(6,garante.getDireccion());
            statement.setString(7,garante.getFecha_nac());
            statement.setString(8,garante.getEmail());
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
    public int update(Garante garante) {
        return 0;
    }

    @Override
    public int delete(Garante garante) {
        return 0;
    }
}
