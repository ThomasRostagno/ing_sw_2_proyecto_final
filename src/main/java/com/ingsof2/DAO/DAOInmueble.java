package com.ingsof2.DAO;

import com.ingsof2.Objetos.Inmueble;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;
import com.ingsof2.utils.Utils;

import java.sql.*;
import java.time.LocalDate;
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
            ResultSet rs = statement.executeQuery("SELECT * FROM Inmueble WHERE (Status=1)");
            Inmueble inmueble;
            while (rs.next()) {
                inmueble = new Inmueble();
                inmueble.setTipo(rs.getString("Tipo"));
                inmueble.setCondicion(rs.getString("Condicion"));
                inmueble.setDireccion(rs.getString("Direccion"));
                inmueble.setSuperficie(rs.getInt("Superficie"));
                inmueble.setNumAmbientes(rs.getInt("Num_Ambientes"));
                inmueble.setFechaConstruccion(rs.getString("Fecha_Construccion"));
                inmueble.setValor(rs.getFloat("Valor"));
                inmueble.setClasificacion(rs.getString("Clasificacion"));
                inmueble.setDniDuenio(rs.getString("DNI_Dueno"));
                inmueble.setSexoDuenio(rs.getString("Sexo_Dueno"));
                inmueble.setCodigoZona(rs.getString("Codigo_Zona"));

                /**Calculo Antiguedad**/

                LocalDate fechaConstruccion = Utils.stringToLocalDate(inmueble.getFechaConstruccion());

                inmueble.setAntiguedad(Utils.calculateAntiguedad(fechaConstruccion));

                inmuebles.add(inmueble);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return inmuebles;
    }

    @Override
    public Inmueble readOne(String... ids) {
        Inmueble inmueble = new Inmueble();
        Connection connection = Database.getInstance().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Inmueble WHERE (Status=1) AND (Direccion='" + ids[0] + "')");
            while (rs.next()) {
                inmueble.setTipo(rs.getString("Tipo"));
                inmueble.setCondicion(rs.getString("Condicion"));
                inmueble.setDireccion(rs.getString("Direccion"));
                inmueble.setSuperficie(rs.getInt("Superficie"));
                inmueble.setNumAmbientes(rs.getInt("Num_Ambientes"));
                inmueble.setFechaConstruccion(rs.getString("Fecha_Construccion"));
                inmueble.setValor(rs.getFloat("Valor"));
                inmueble.setClasificacion(rs.getString("Clasificacion"));
                inmueble.setDniDuenio(rs.getString("DNI_Dueno"));
                inmueble.setSexoDuenio(rs.getString("Sexo_Dueno"));
                inmueble.setCodigoZona(rs.getString("Codigo_Zona"));

                /**Calculo Antiguedad**/

                LocalDate fechaConstruccion = Utils.stringToLocalDate(inmueble.getFechaConstruccion());

                inmueble.setAntiguedad(Utils.calculateAntiguedad(fechaConstruccion));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return inmueble;
    }

    @Override
    public int create(Inmueble inmueble) {
        String sqlInsert = " INSERT INTO Inmueble (Tipo, Condicion, Direccion, Superficie, Num_Ambientes, Fecha_Construccion, Valor, Clasificacion, DNI_Dueno, Sexo_Dueno, Codigo_Zona, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1, inmueble.getTipo());
            statement.setString(2, inmueble.getCondicion());
            statement.setString(3, inmueble.getDireccion());
            statement.setInt(4, inmueble.getSuperficie());
            statement.setInt(5, inmueble.getNumAmbientes());
            statement.setString(6, inmueble.getFechaConstruccion());
            statement.setFloat(7, inmueble.getValor());
            statement.setString(8, inmueble.getClasificacion());
            statement.setString(9, inmueble.getDniDuenio());
            statement.setString(10, inmueble.getSexoDuenio());
            statement.setString(11, inmueble.getCodigoZona());
            statement.setInt(12, 1);
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
        String sqlUpdate = " UPDATE Inmueble SET Tipo = ?, Condicion = ?, Superficie = ?, Num_Ambientes = ?, Fecha_Construccion = ?, Valor = ?, Clasificacion = ?, DNI_Dueno = ?, Sexo_Dueno = ?, Codigo_Zona = ?" +
                " WHERE (Direccion = '" + inmueble.getDireccion() + "')";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, inmueble.getTipo());
            statement.setString(2, inmueble.getCondicion());
            statement.setInt(3, inmueble.getSuperficie());
            statement.setInt(4, inmueble.getNumAmbientes());
            statement.setString(5, inmueble.getFechaConstruccion());
            statement.setFloat(6, inmueble.getValor());
            statement.setString(7, inmueble.getClasificacion());
            statement.setString(8, inmueble.getDniDuenio());
            statement.setString(9, inmueble.getSexoDuenio());
            statement.setString(10, inmueble.getCodigoZona());
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
        String sqlDelete = " UPDATE Inmueble SET Status = 0 " +
                "WHERE (Direccion = '" + inmueble.getDireccion() + "')";
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
