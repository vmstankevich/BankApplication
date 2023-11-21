package com.bankapplication.dao;

import com.bankapplication.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public abstract class DaoAbstractConnector<T> implements DaoConnector<T>{
    final String tableName;

    final List<String> columnNames;

    protected DaoAbstractConnector(String tableName, List<String> columnNames) {
        this.tableName = tableName;
        this.columnNames = columnNames;
    }


    abstract  PreparedStatement process(PreparedStatement ps, T t) throws SQLException;
    @Override
    public T create(T t) {
        String questionMarks = String.join(", ", Collections.nCopies(columnNames.size(), "?"));
        String query = String.format(
                "INSERT INTO %s (%s) VALUES (%s)", tableName, String.join(", ", columnNames), questionMarks);
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     query
             )) {
            process(statement, t);


            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }
}
