package org.homework8.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementCreator {

    public PreparedStatement getQueryStatement(Connection connection, String sql){
        PreparedStatement queryStatement;
        try {
             queryStatement = connection.prepareStatement(sql);
             return queryStatement;
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
}
