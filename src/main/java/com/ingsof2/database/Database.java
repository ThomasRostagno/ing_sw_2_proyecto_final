package com.ingsof2.database;

import com.ingsof2.exceptions.ApiException;
import com.ingsof2.utils.ErrorCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database INSTANCE;
    private Connection conn;
    private String url = "jdbc:postgresql://34.95.188.39:5432/";
    private String user = "postgres";
    private String password = "951753";

    public Database() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ApiException.showException(new ApiException(ErrorCode.FAIL_CONNECTING_TO_DB));
        }
    }

    private static void createInstance() {
        try {
            if (INSTANCE == null || INSTANCE.getConn().isClosed()) {
                INSTANCE = new Database();
            }
        } catch (SQLException throwables) {
            ApiException.showException(new ApiException(ErrorCode.FAIL_CONNECTING_TO_DB));
        }
    }

    public static Database getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public Connection getConn() {
        return conn;
    }

    public void disconnect() {
        try {
            conn.close();
            System.out.println("Disconnected from the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ApiException.showException(new ApiException(ErrorCode.FAIL_DISCONNECTING_TO_DB));
        }
    }
}
