package com.ingsof2.DAO;

import com.ingsof2.Objetos.Inmueble;
import com.ingsof2.Objetos.Inquilino;
import com.ingsof2.database.Database;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
            while(rs.next()){
                inmueble = new Inmueble();
                inmueble.setTipo(rs.getString("Tipo"));
                inmueble.setCondicion(rs.getString("Condicion"));
                inmueble.setDireccion(rs.getString("Direccion"));
                inmueble.setSuperficie(rs.getInt("Superficie"));
                inmueble.setNum_ambientes(rs.getInt("Num_Ambientes"));
                inmueble.setFecha_construccion(rs.getString("Fecha_Construccion"));
                inmueble.setValor(rs.getFloat("Valor"));
                inmueble.setClasificacion(rs.getString("Clasificacion"));

                /**Calculo Antiguedad**/
                LocalDate today = LocalDate.now();
                int dd= Integer.parseInt(inmueble.getFecha_construccion().substring(0,2));
                int mm= Integer.parseInt(inmueble.getFecha_construccion().substring(3,5));
                int yy= Integer.parseInt(inmueble.getFecha_construccion().substring(6,10));

                LocalDate agebuilding = LocalDate.of(yy,mm,dd);

                long longage = ChronoUnit.YEARS.between(agebuilding,today);
                int age = (int)longage;
                inmueble.setAntiguedad(age);

                inmuebles.add(inmueble);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
        return inmuebles;
    }

    @Override
    public int create(Inmueble inmueble) {
        String sqlInsert =  " INSERT INTO Inmueble (Tipo, Condicion, Direccion, Superficie, Num_Ambientes, Fecha_Construccion, Valor, Clasificacion, Status)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int exito = 0;
        Connection connection = Database.getInstance().getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1,inmueble.getTipo());
            statement.setString(2,inmueble.getCondicion());
            statement.setString(3,inmueble.getDireccion());
            statement.setInt(4,inmueble.getSuperficie());
            statement.setInt(5,inmueble.getNum_ambientes());
            statement.setString(6,inmueble.getFecha_construccion());
            statement.setFloat(7,inmueble.getValor());
            statement.setString(8,inmueble.getClasificacion());
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
    public int update(Inmueble inmueble) {
        return 0;
    }

    @Override
    public int delete(Inmueble inmueble) {
        return 0;
    }
}
