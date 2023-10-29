package com.bankapplication;

import org.slf4j.LoggerFactory;

import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.crypto.Data;

public class JDBCTest {
    private static final Logger logger = LoggerFactory.getLogger(JDBCTest.class);

    public static void main(String[] args) {

        try {
            Connection connection = DatabaseConnection.getConnection();

            String sqlQuery = "SELECT * FROM bankapplication.user";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String fullName = resultSet.getString("fullname");
                String email = resultSet.getString("email");
                System.out.println("Full name: " + fullName + ", E-mail: " + email);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.error("Произошло исключение PSQLException", e);
        }
        logger.info("Это сообщение будет залогировано.");
    }
}
