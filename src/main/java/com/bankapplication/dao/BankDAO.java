package com.bankapplication.dao;

import com.bankapplication.DatabaseConnection;
import com.bankapplication.model.Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankDAO implements DaoConnector<Bank> {


    public void readBank(int bankId) {

    }

    public void updateBank(Bank bank) {

    }

    public void deleteBank(int bankId) {

    }

    @Override
    public String tableName() {
        return "bankapplication.bank";
    }


    @Override
    public List<String> columnNames() {
        return Arrays.asList("bank_id", "name", "address");
    }

    @Override
    public PreparedStatement process(PreparedStatement ps, Bank bank) throws SQLException {
        int i = 0;
        ps.setInt(++i, bank.getBankId());
        ps.setString(++i, bank.getName());
        ps.setString(++i, bank.getAddress());
        return ps;
    }
}
