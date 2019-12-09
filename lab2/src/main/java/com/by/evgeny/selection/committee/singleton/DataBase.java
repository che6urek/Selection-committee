package com.by.evgeny.selection.committee.singleton;


import com.by.evgeny.selection.committee.exceptions.DataBaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static DataBase dataBase;

    private Connection connection;
    private boolean connected;

    private final String url = "jdbc:mysql://localhost/epam?user=root&password=Ab123456cD";

    private DataBase() {
    }

    public static DataBase getInstance() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }
        return dataBase;
    }

    public Connection getConnection() throws DataBaseException {
        if (connected) {
            return connection;
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url);
                connected = true;
                return connection;
            } catch (ClassNotFoundException | SQLException e) {
                connected = false;
                throw new DataBaseException(e.getMessage(), e);
            }
        }
    }
}
