package com.ingsof2.DAO;

import com.ingsof2.Objetos.Alquiler;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAlquiler implements BusinessObject<Alquiler> {
    @Override
    public List<Alquiler> readAll() {
        List<Alquiler> alquileres = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Alquiler WHERE (Status==1)");
            Alquiler alquiler;
            while (rs.next()) {
                alquiler = new Alquiler();
                alquiler.setCodigo(rs.getString("Codigo"));
                alquiler.setTipo(1);//1 es alquiler, 2 es venta
                alquiler.setFecha(rs.getString("Fecha_Contrato"));
                alquiler.setFechaFin(rs.getString("Fecha_Fin"));
                alquiler.setPrecio(rs.getFloat("Precio"));
                alquiler.setDniInquilino(rs.getString("DNI_Inquilino"));
                alquiler.setDomicilioInmueble(rs.getString("Domicilio_Inmueble"));
                alquiler.setDniGarante(rs.getString("DNI_Garante"));
                alquiler.setDniEscribano(rs.getString("DNI_Escribano"));


                alquileres.add(alquiler);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return alquileres;
    }

    @Override
    public Alquiler ReadOne(String... ids) {
        return null;
    }

    @Override
    public int create(Alquiler alquiler) {
        String sqlInsert = " INSERT INTO Alquiler (Codigo, Tipo, Fecha_Contrato, Fecha_Fin, Precio, DNI_Inquilino, Domicilio_Inmueble, DNI_Garante, DNI_Escribano, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, alquiler.getCodigo());
            statement.setInt(2, alquiler.getTipo());
            statement.setString(3, alquiler.getFecha());
            statement.setString(4, alquiler.getFechaFin());
            statement.setFloat(5, alquiler.getPrecio());
            statement.setString(6, alquiler.getDniInquilino());
            statement.setString(7, alquiler.getDomicilioInmueble());
            statement.setString(8, alquiler.getDniGarante());
            statement.setString(9, alquiler.getDniEscribano());
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
    public int update(Alquiler alquiler) {
        /*String sqlUpdate = " UPDATE Alquiler SET Nombre = ?, Apellido = ?, Telefono = ?, Sexo = ?, Direccion = ?, Fecha_Nacimiento = ?, Email = ?" +
                " VALUES (?, ?, ?, ?, ?, ?, ?) WHERE (DNI = '" + alquiler.getDni() + "') AND ('" + "Sexo =" + alquiler.getSexo() + "')";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, inquilino.getNombre());
            statement.setString(2, inquilino.getApellido());
            statement.setString(3, inquilino.getTelefono());
            statement.setString(4, inquilino.getSexo());
            statement.setString(5, inquilino.getDireccion());
            statement.setString(6, inquilino.getFechaNac());
            statement.setString(7, inquilino.getEmail());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;*/
        return 0;
    }

    @Override
    public int delete(Alquiler alquiler) {
        String sqlDelete = " UPDATE Alquiler SET Status = 0 " +
        "WHERE (Codigo = '" + alquiler.getCodigo() + "')";
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
