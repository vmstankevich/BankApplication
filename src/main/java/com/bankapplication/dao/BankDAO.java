package com.bankapplication.dao;

import com.bankapplication.DatabaseConnection;
import com.bankapplication.model.Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankDAO {
    public void createBank(Bank bank) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO bankapplication.bank (bank_id, name, address) VALUES (?, ?, ?)")) {
            statement.setInt(1, bank.getBankId());
            statement.setString(2, bank.getName());
            statement.setString(3, bank.getAddress());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readBank(int bankId) {

    }

    public void updateBank(Bank bank) {

    }

    public void deleteBank(int bankId) {

    }
}
