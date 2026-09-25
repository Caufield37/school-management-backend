package com.school.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL = "jdbc:mysql://localhost:3306/school_one";
    private static final String USERNAME = "root";
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        if (PASSWORD == null || PASSWORD.trim().isEmpty()) {
            throw new IllegalStateException("Missing DB_PASSWORD environment variable!");
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}


