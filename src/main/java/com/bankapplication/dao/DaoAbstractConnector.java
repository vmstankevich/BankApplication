package com.bankapplication.dao;

import com.bankapplication.DatabaseConnection;

import java.sql.*;
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
        try (Connection connection = databaseConnection.getConnection();
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
    @Override
    public T read(int id) {
        String sqlQuery = "SELECT * FROM " + tableName + " WHERE " + columnNames.get(0) + " = ?";
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try (Connection connection = databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
               if (resultSet.next()) {
                   System.out.println("сработал метод read()");
                   return mapResultSetToEntity(resultSet);
               }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void deleteDataFromTables() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try (Connection connection = databaseConnection.getConnection();
            Statement statement = connection.createStatement()) {
            String deleteQuery = "DELETE FROM " + tableName;
            statement.executeUpdate(deleteQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;
}
