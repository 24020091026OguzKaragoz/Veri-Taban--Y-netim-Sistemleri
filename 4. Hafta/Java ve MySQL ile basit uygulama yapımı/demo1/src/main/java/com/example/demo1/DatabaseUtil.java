package com.example.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    // Replace with your database connection details
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Deneme";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "5879";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
}