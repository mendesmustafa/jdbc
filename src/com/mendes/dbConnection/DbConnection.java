package com.mendes.dbConnection;

import com.mendes.utility.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by mendesmustafa on 24.11.2020.
 */

public class DbConnection {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/employees";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "seyf";

    public static Connection connectionPostgresql() {
        try {
            return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            Util.processSQLException(e);
            return null;
        }
    }
}