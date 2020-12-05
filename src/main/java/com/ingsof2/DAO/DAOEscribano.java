package com.ingsof2.DAO;

import com.ingsof2.Objetos.Escribano;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOEscribano implements BusinessObject<Escribano> {
    @Override
    public List<Escribano> readAll() {
        List<Escribano> escribanos = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Escribano WHERE (Status=1)");
            Escribano escribano;
            while (rs.next()) {
                escribano = new Escribano();
                escribano.setNombre(rs.getString("Nombre"));
                escribano.setApellido(rs.getString("Apellido"));
                escribano.setTelefono(rs.getString("Telefono"));
                escribano.setDni(rs.getString("DNI"));
                escribano.setSexo(rs.getString("Sexo"));
                escribano.setDireccion(rs.getString("Direccion"));
                escribano.setFechaNac(rs.getString("Fecha_Nacimiento"));
                escribano.setEmail(rs.getString("Email"));
                escribano.setMatricula(rs.getString("Matricula"));
                escribanos.add(escribano);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return escribanos;
    }

    @Override
    public Escribano ReadOne(String... ids) {
        Escribano escribano = new Escribano();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Escribano WHERE (Status=1 AND DNI='" + ids[0] + "' AND Sexo='" + ids[1] + "')");
            while (rs.next()) {
                escribano.setNombre(rs.getString("Nombre"));
                escribano.setApellido(rs.getString("Apellido"));
                escribano.setTelefono(rs.getString("Telefono"));
                escribano.setDni(rs.getString("DNI"));
                escribano.setSexo(rs.getString("Sexo"));
                escribano.setDireccion(rs.getString("Direccion"));
                escribano.setFechaNac(rs.getString("Fecha_Nacimiento"));
                escribano.setEmail(rs.getString("Email"));
                escribano.setMatricula(rs.getString("Matricula"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return escribano;
    }

    @Override
    public int create(Escribano escribano) {
        String sqlInsert = " INSERT INTO Escribano (Nombre, Apellido, Telefono, DNI, Sexo, Direccion, Fecha_Nacimiento, Email, Matricula, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, escribano.getNombre());
            statement.setString(2, escribano.getApellido());
            statement.setString(3, escribano.getTelefono());
            statement.setString(4, escribano.getDni());
            statement.setString(5, escribano.getSexo());
            statement.setString(6, escribano.getDireccion());
            statement.setString(7, escribano.getFechaNac());
            statement.setString(8, escribano.getEmail());
            statement.setString(9, escribano.getMatricula());
            statement.setInt(10, 1);
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int update(Escribano escribano) {
        return 0;
    }

    @Override
    public int delete(Escribano escribano) {
        return 0;
    }
}
