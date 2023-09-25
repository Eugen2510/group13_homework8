package org.homework8.connection;

import org.homework8.connection.ConnectConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public Connection getConnection(ConnectConstants url, ConnectConstants user, ConnectConstants password){
        String urlValue = url.getValue();
        String userValue = user.getValue();
        String passwordValue = password.getValue();
        Connection connection;
        try {
             connection = DriverManager.getConnection(urlValue, userValue, passwordValue);
             return connection;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
