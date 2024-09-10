package org.example.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:sqlserver://inmopro.database.windows.net:1433;database=DAO";
    private static final String USER = "InmoProAdmin@inmopro";
    private static final String PASSWORD = "AdminInmoProIshere1!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
