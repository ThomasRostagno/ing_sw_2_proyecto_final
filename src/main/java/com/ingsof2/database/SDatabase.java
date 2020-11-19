package com.ingsof2.database;

import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SDatabase {
    private static SDatabase INSTANCE;
    private Connection conn;
    private String url = "jdbc:postgresql://34.95.188.39:5432/";
    private String user = "postgres";
    private String password = "951753";

    public SDatabase() throws ApiException{
        try{
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        }
        catch (SQLException e){
            ApiException.showException(new ApiException(ErrorCode.FAIL_CONNECTING_TO_DB));
        }
    }

    public Connection getConn(){
        return conn;
    }
    private static void createInstance() throws ApiException {
        if (INSTANCE == null){
            INSTANCE = new SDatabase();
        }
    }
    public static SDatabase getInstance() throws ApiException, SQLException {//me mete el SQLException con el metodo .isClosed()
        if (INSTANCE == null){
            createInstance();
        }//else if x si la instancia esta cerrada?
        else if (INSTANCE.getConn().isClosed()){
            createInstance();
        }
        return INSTANCE;
    }






    /*private static SDatabase INSTANCE = null;
    Connection conn;
    String url = "jdbc:postgresql://34.95.188.39:5432/";
    String user = "postgres";
    String password = "951753";

    private SDatabase(){
        //this.conn = new Connection();
        //tengo que construir la conexion aca? o el constructor va vacio y llamo al metodo Connection donde abro?
        //why we are here? what's our purpose in life?
    }

    public Connection connect () throws ApiException {
        this.conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            //System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ApiException.showException(new ApiException(ErrorCode.FAIL_CONNECTING_TO_DB));
        }
        return conn;
    }
    public void disconnect(Connection connection) throws ApiException {
        try {
            connection.close();
            //System.out.println("Disconnected from the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ApiException.showException(new ApiException(ErrorCode.FAIL_DISCONNECTING_TO_DB));
        }
    }

    private static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new SDatabase();
        }
    }

    public static SDatabase getInstance(){
        if (INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }*/
}
