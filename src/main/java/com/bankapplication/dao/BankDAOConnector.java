package com.bankapplication.dao;

import com.bankapplication.model.Bank;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

//TODO поля tableName, columnNames создавались автоматиески
public class BankDAOConnector extends DaoAbstractConnector<Bank> {
    private final static String tableName = "bankapplication.bank";
    private final static List<String> columnNames = Arrays.asList("bank_id", "name", "address");

    public BankDAOConnector() {
        super(tableName, columnNames);
    }

    public void readBank(int bankId) { //List

    }

    public void updateBank(Bank bank) {

    }

    public void deleteBank(int bankId) {

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
