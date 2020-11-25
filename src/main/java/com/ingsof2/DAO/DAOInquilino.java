package com.ingsof2.DAO;

import com.ingsof2.Objetos.Inquilino;
import com.ingsof2.database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                inquilino.setDni(rs.getInt("DNI"));
                /*.....*/
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
        return 0;
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
