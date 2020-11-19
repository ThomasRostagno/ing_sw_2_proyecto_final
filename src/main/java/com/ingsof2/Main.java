package com.ingsof2;

import com.ingsof2.database.Database;
import com.ingsof2.frames.MainFrame;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static MainFrame mainFrame;

    public static void main(String[] args) {

        //mainFrame = new MainFrame();

        Connection sdbConn = Database.getInstance().getConn();

        Statement statement;
        try {
            statement = sdbConn.createStatement();
            statement.executeUpdate("CREATE TABLE STUDENT(ID INT NOT NULL, NAME VARCHAR)");
            statement.executeUpdate("DROP TABLE STUDENT");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Database.getInstance().disconnect();
    }
}
