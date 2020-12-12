package com.ingsof2.DAO;

import com.ingsof2.Objetos.Alquiler;
import com.ingsof2.Objetos.Venta;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOVenta implements BusinessObject<Venta> {
    @Override
    public List<Venta> readAll() {
        List<Venta> ventas = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Venta WHERE (Status=1)");
            Venta venta;
            while (rs.next()) {
                venta = new Venta();
                venta.setCodigo(rs.getString("Codigo"));
                venta.setTipo(2);//1 es alquiler, 2 es venta
                venta.setFecha(rs.getString("Fecha_Contrato"));
                venta.setComision(rs.getInt("Comision"));
                venta.setPrecio(rs.getFloat("Precio"));
                venta.setDniComprador(rs.getString("DNI_Comprador"));
                venta.setSexoComprador(rs.getString("Sexo_Comprador"));
                venta.setDomicilioInmueble(rs.getString("Domicilio_Inmueble"));
                venta.setDniVendedor(rs.getString("DNI_Vendedor"));
                venta.setSexoVendedor(rs.getString("Sexo_Vendedor"));
                ventas.add(venta);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return ventas;
    }

    @Override
    public Venta readOne(String... ids) {
        Venta venta = new Venta();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Venta WHERE (Status=1) AND (Codigo='" + ids[0] + "')");
            while (rs.next()) {
                venta.setCodigo(rs.getString("Codigo"));
                venta.setTipo(rs.getInt("Tipo"));
                venta.setFecha(rs.getString("Fecha_Contrato"));
                venta.setPrecio(rs.getFloat("Precio"));
                venta.setComision(rs.getInt("Comision"));
                venta.setDniComprador(rs.getString("DNI_Comprador"));
                venta.setSexoComprador(rs.getString("Sexo_Comprador"));
                venta.setDomicilioInmueble(rs.getString("Domicilio_Inmueble"));
                venta.setDniVendedor(rs.getString("DNI_Vendedor"));
                venta.setSexoVendedor(rs.getString("Sexo_Vendedor"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return venta;
    }

    @Override
    public int create(Venta venta) {
        String sqlInsert = " INSERT INTO Venta (Codigo, Tipo, Fecha_Contrato, Comision, Precio, DNI_Comprador, Sexo_Comprador, Domicilio_Inmueble, DNI_Vendedor, Sexo_Vendedor, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, venta.getCodigo());
            statement.setInt(2, venta.getTipo());
            statement.setString(3, venta.getFecha());
            statement.setInt(4, venta.getComision());
            statement.setFloat(5,venta.getPrecio());
            statement.setString(6, venta.getDniComprador());
            statement.setString(7, venta.getSexoComprador());
            statement.setString(8, venta.getDomicilioInmueble());
            statement.setString(9, venta.getDniVendedor());
            statement.setString(10, venta.getSexoVendedor());
            statement.setInt(11, 1);
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int update(Venta venta) {
        String sqlUpdate = " UPDATE Venta SET Tipo = ?, Fecha_Contrato = ?, Comision = ?, Precio = ?, DNIComprador = ?, Sexo_Comprador = ?, Domicilio_Inmueble = ?, DNI_Vendedor = ?, Sexo_Vendedor = ?" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE (Codigo = '" + venta.getCodigo() + "')";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdate);
            statement.setInt(1, venta.getTipo());
            statement.setString(2, venta.getFecha());
            statement.setInt(3, venta.getComision());
            statement.setFloat(4,venta.getPrecio());
            statement.setString(5, venta.getDniComprador());
            statement.setString(6, venta.getSexoComprador());
            statement.setString(7, venta.getDomicilioInmueble());
            statement.setString(8, venta.getDniVendedor());
            statement.setString(9, venta.getSexoVendedor());
            statement.executeUpdate();  
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int delete(Venta venta) {
        String sqlDelete = " UPDATE Venta SET Status = 0 " +
                "WHERE (Codigo = '" + venta.getCodigo() + "')";
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
