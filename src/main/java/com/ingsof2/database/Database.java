package com.ingsof2.database;

import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum Database {
    INSTANCE;

    private final String url = "jdbc:postgresql://34.95.188.39:5432/";
    private final String user = "postgres";
    private final String password = "951753";

    public Connection connect() throws ApiException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ApiException.showException(new ApiException(ErrorCode.FAIL_CONNECTING_TO_DB));
        }

        return conn;
    }

    public void disconnect(Connection connection) throws ApiException {
        try {
            connection.close();
            System.out.println("Disconnected from the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ApiException.showException(new ApiException(ErrorCode.FAIL_DISCONNECTING_TO_DB));
        }
    }
}
