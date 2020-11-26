package com.ingsof2.DAO;

import com.ingsof2.Objetos.Inmueble;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;
import com.ingsof2.utils.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOInmueble implements BusinessObject<Inmueble> {

    @Override
    public List<Inmueble> readAll() {
        List<Inmueble> inmuebles = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();

        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Inmueble WHERE (Status==1)");
            Inmueble inmueble;
            while (rs.next()) {
                inmueble = new Inmueble();
                inmueble.setTipo(rs.getString("Tipo"));
                inmueble.setCondicion(rs.getString("Condicion"));
                inmueble.setDireccion(rs.getString("Direccion"));
                inmueble.setSuperficie(rs.getInt("Superficie"));
                inmueble.setNum_ambientes(rs.getInt("Num_Ambientes"));
                inmueble.setFecha_construccion(rs.getString("Fecha_Construccion"));
                inmueble.setValor(rs.getFloat("Valor"));
                inmueble.setClasificacion(rs.getString("Clasificacion"));
                inmueble.setDni_Inquilino(rs.getString("DNI_Inquilino"));
                inmueble.setDni_Duenio(rs.getString("DNI_Dueno"));
                inmueble.setCodigo_Alquiler(rs.getString("Codigo_Alquiler"));
                inmueble.setCodigo_Zona(rs.getString("Codigo_Zona"));

                /**Calculo Antiguedad**/

                String fechaConstruccionString = inmueble.getFecha_construccion();
                String[] fechaConstruccion = fechaConstruccionString.split("/");

                int dd = Integer.parseInt(fechaConstruccion[0]);
                int mm = Integer.parseInt(fechaConstruccion[1]);
                int yy = Integer.parseInt(fechaConstruccion[2]);

                inmueble.setAntiguedad(Utils.calculateAntiguedad(dd, mm, yy));

                inmuebles.add(inmueble);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return inmuebles;
    }

    @Override
    public Inmueble ReadOne(Inmueble inmueble) {
        return null;
    }

    @Override
    public int create(Inmueble inmueble) {
        String sqlInsert = " INSERT INTO Inmueble (Tipo, Condicion, Direccion, Superficie, Num_Ambientes, Fecha_Construccion, Valor, Clasificacion, DNI_Inquilino, DNI_Dueno, Codigo_Alquiler, Codigo_Zona, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, inmueble.getTipo());
            statement.setString(2, inmueble.getCondicion());
            statement.setString(3, inmueble.getDireccion());
            statement.setInt(4, inmueble.getSuperficie());
            statement.setInt(5, inmueble.getNum_ambientes());
            statement.setString(6, inmueble.getFecha_construccion());
            statement.setFloat(7, inmueble.getValor());
            statement.setString(8, inmueble.getClasificacion());
            statement.setString(9, inmueble.getDni_Inquilino());
            statement.setString(10, inmueble.getDni_Duenio());
            statement.setString(11, inmueble.getCodigo_Alquiler());
            statement.setString(12, inmueble.getCodigo_Zona());
            statement.setInt(13, 1);
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException e) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
            System.out.println(e.getMessage());
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int update(Inmueble inmueble) {
        String sqlUpdate = " UPDATE Inmueble SET Tipo = ?, Condicion = ?, Superficie = ?, Num_Ambientes = ?, Fecha_Construccion = ?, Valor = ?, Clasificacion = ?, DNI_Inquilino = ?, DNI_Dueno = ?, Codigo_Alquiler = ?, Codigo_Zona = ?" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE (Direccion = '" + inmueble.getDireccion() + "')";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, inmueble.getTipo());
            statement.setString(2, inmueble.getCondicion());
            statement.setInt(4, inmueble.getSuperficie());
            statement.setInt(5, inmueble.getNum_ambientes());
            statement.setString(6, inmueble.getFecha_construccion());
            statement.setFloat(7, inmueble.getValor());
            statement.setString(8, inmueble.getClasificacion());
            statement.setString(9, inmueble.getDni_Inquilino());
            statement.setString(10, inmueble.getDni_Duenio());
            statement.setString(11, inmueble.getCodigo_Alquiler());
            statement.setString(12, inmueble.getCodigo_Zona());
            statement.executeUpdate();
            exito = 1;

        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_SAVING_IN_DB));
        }
        Database.getInstance().disconnect();
        return exito;
    }

    @Override
    public int delete(Inmueble inmueble) {
        return 0;
    }
}
