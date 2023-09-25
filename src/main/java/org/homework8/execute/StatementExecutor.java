package org.homework8.execute;

import org.homework8.connection.ConnectConstants;
import org.homework8.connection.Connector;
import org.homework8.statement.StatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatementExecutor {
    public ResultSet executeQuery(Connection connection, String sql){
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = new StatementCreator().getQueryStatement(connection,sql);
             resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
