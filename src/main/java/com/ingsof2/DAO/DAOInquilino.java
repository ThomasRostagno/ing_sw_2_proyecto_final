package com.ingsof2.DAO;

import com.ingsof2.Objetos.Inquilino;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOInquilino implements BusinessObject<Inquilino>  {


    @Override
    public List<Inquilino> readAll() {
        List<Inquilino> inquilinos = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Inquilino WHERE (Status==1)");
            Inquilino inquilino;
            while(rs.next()){
                inquilino = new Inquilino();
                inquilino.setNombre(rs.getString("Nombre"));
                inquilino.setApellido(rs.getString("Apellido"));
                inquilino.setTelefono(rs.getString("Telefono"));
                inquilino.setDni(rs.getInt("DNI"));
                inquilino.setTelefono(rs.getString("Sexo"));
                inquilino.setTelefono(rs.getString("Direccion"));
                inquilino.setTelefono(rs.getString("Fecha_Nacimiento"));
                inquilino.setTelefono(rs.getString("Email"));
                inquilinos.add(inquilino);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return inquilinos;
    }

    @Override
    public int create(Inquilino inquilino) {
        String sqlInsert =  " INSERT INTO Inquilino (Nombre, Apellido, Telefono, DNI, Sexo, Direccion, Fecha_Nacimiento, Email, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1,inquilino.getNombre());
            statement.setString(2,inquilino.getApellido());
            statement.setString(3,inquilino.getTelefono());
            statement.setInt(4,inquilino.getDni());
            statement.setString(5,inquilino.getSexo());
            statement.setString(6,inquilino.getDireccion());
            statement.setString(7,inquilino.getFecha_nac());
            statement.setString(8,inquilino.getEmail());
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
    public int update(Inquilino inquilino) {
        return 0;
    }

    @Override
    public int delete(Inquilino inquilino) {
        /*En realidad es un update, en eel que paso status a 0*/
        return 0;
    }
}
