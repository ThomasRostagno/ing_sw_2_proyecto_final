package com.ingsof2.DAO;

import com.ingsof2.Objetos.Vendedor;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOVendedor implements BusinessObject<Vendedor> {
    @Override
    public List<Vendedor> readAll() {
        List<Vendedor> vendedores = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Vendedor WHERE (Status=1)");
            Vendedor vendedor;
            while (rs.next()) {
                vendedor = new Vendedor();
                vendedor.setNombre(rs.getString("Nombre"));
                vendedor.setApellido(rs.getString("Apellido"));
                vendedor.setTelefono(rs.getString("Telefono"));
                vendedor.setDni(rs.getString("DNI"));
                vendedor.setSexo(rs.getString("Sexo"));
                vendedor.setDireccion(rs.getString("Direccion"));
                vendedor.setFechaNac(rs.getString("Fecha_Nacimiento"));
                vendedor.setEmail(rs.getString("Email"));
                vendedores.add(vendedor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return vendedores;
    }

    @Override
    public Vendedor readOne(String... ids) {
        Vendedor vendedor = new Vendedor();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Vendedor WHERE (Status=1) AND (DNI='" + ids[0] + "') AND (Sexo='" + ids[1] + "')");
            while (rs.next()) {
                vendedor.setNombre(rs.getString("Nombre"));
                vendedor.setApellido(rs.getString("Apellido"));
                vendedor.setTelefono(rs.getString("Telefono"));
                vendedor.setDni(rs.getString("DNI"));
                vendedor.setSexo(rs.getString("Sexo"));
                vendedor.setDireccion(rs.getString("Direccion"));
                vendedor.setFechaNac(rs.getString("Fecha_Nacimiento"));
                vendedor.setEmail(rs.getString("Email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vendedor;
    }

    @Override
    public int create(Vendedor vendedor) {
        String sqlInsert = " INSERT INTO Vendedor (Nombre, Apellido, Telefono, DNI, Sexo, Direccion, Fecha_Nacimiento, Email, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, vendedor.getNombre());
            statement.setString(2, vendedor.getApellido());
            statement.setString(3, vendedor.getTelefono());
            statement.setString(4, vendedor.getDni());
            statement.setString(5, vendedor.getSexo());
            statement.setString(6, vendedor.getDireccion());
            statement.setString(7, vendedor.getFechaNac());
            statement.setString(8, vendedor.getEmail());
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
    public int update(Vendedor vendedor) {
        String sqlUpdate = " UPDATE Vendedor SET Nombre = ?, Apellido = ?, Telefono = ?, Direccion = ?, Fecha_Nacimiento = ?, Email = ?" +
                " VALUES (?, ?, ?, ?, ?, ?, ?) WHERE (DNI = '" + vendedor.getDni() + "') AND (Sexo ='" + vendedor.getSexo() + "')";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, vendedor.getNombre());
            statement.setString(2, vendedor.getApellido());
            statement.setString(3, vendedor.getTelefono());
            statement.setString(4, vendedor.getDireccion());
            statement.setString(5, vendedor.getFechaNac());
            statement.setString(6, vendedor.getEmail());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int delete(Vendedor vendedor) {
        String sqlDelete = " UPDATE Vendedor SET Status = 0 " +
                "WHERE (DNI = '" + vendedor.getDni() + "') AND ('" + "Sexo =" + vendedor.getSexo() + "')";
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
