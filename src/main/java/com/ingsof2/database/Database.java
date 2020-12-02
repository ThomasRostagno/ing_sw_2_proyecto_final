package com.ingsof2.database;

import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database INSTANCE;
    private static Connection connection;
    private static String url = "jdbc:postgresql://34.95.188.39:5432/";
    private static String user = "postgres";
    private static String password = "951753";

    public Database() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ApiException.showException(new ApiException(ErrorCode.FAIL_CONNECTING_TO_DB));
        }
    }

    private static void createInstance() {
        INSTANCE = new Database();
    }

    public static Database getInstance() {
        try {
            if (INSTANCE == null) {
                createInstance();
            } else if (INSTANCE.getConnection().isClosed()) {
                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ApiException.showException(new ApiException(ErrorCode.FAIL_CONNECTING_TO_DB));
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        try {
            connection.close();
            System.out.println("Disconnected from the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ApiException.showException(new ApiException(ErrorCode.FAIL_DISCONNECTING_TO_DB));
        }
    }
}
