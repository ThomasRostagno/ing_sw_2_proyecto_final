package com.ingsof2;

import com.ingsof2.database.SDatabase;
import com.ingsof2.exceptions.ApiException;
import com.ingsof2.frames.MainFrame;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static MainFrame mainFrame;

    public static void main(String[] args) throws ApiException, SQLException {//sacar throws


        //mainFrame = new MainFrame();
        //Connection auxiliar = SDatabase.getInstance();
        /*SDatabase sdbConn = SDatabase.getInstance();
        sdbConn.getConn();*/
        Connection sdbConn = SDatabase.getInstance().getConn();

        //Connection con = (Connection) SDatabase.getInstance();
        /*SDatabase aux = new SDatabase();
        aux = aux.getInstance();*/


        /*Connection connection = Database.INSTANCE.connect();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE STUDENT");
            statement.executeUpdate("CREATE TABLE STUDENT(ID INT NOT NULL, NAME VARCHAR)");
            statement.executeUpdate("DROP TABLE STUDENT");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Main.mainFrame.showException(new ApiException(ErrorCode.FAIL_EXECUTING_QUERY));
        }


        Database.INSTANCE.disconnect(connection);*/
    }
}
