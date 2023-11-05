package com.bankapplication.dao;

import com.bankapplication.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public interface DaoConnector<T> {
    String tableName();
    List<String> columnNames();

    PreparedStatement process(PreparedStatement ps, T t) throws SQLException;

    default T create(T t) {
        columnNames().size();
        String questionMarks = String.join(", ", Collections.nCopies(columnNames().size(), "?"));
        String query = String.format(
                "INSERT INTO %s (%s) VALUES (%s)", tableName(), String.join(", ", columnNames()), questionMarks);
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
}
