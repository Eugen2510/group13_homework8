package org.homework8.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    private final Properties properties;
    private static final Connector INSTANCE = new Connector();

    private Connector(){
        properties = ConnectionConstantsLoader.loadConnectionConstants(PathConstants.DB_CONNECTION_PROPERTIES);
    }

    public static Connector getInstance(){
        return INSTANCE;
    }
    public Connection getConnection(){
        String urlValue = properties.getProperty("url");
        String userValue = properties.getProperty("user");
        String passwordValue = properties.getProperty("password");
        Connection connection;
        try {
             connection = DriverManager.getConnection(urlValue, userValue, passwordValue);
             return connection;
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
