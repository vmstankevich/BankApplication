package com.bankapplication.dao;

import com.bankapplication.model.Bank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

//TODO поля tableName, columnNames создавались автоматиески
public class BankDAOAbstract extends DaoAbstractConnector<Bank> {
    private final static String tableName = "bankapplication.bank";
    private final static List<String> columnNames = Arrays.asList("bank_id", "name", "address");

    public BankDAOAbstract() {
        super(tableName, columnNames);
    }

    public void readBank() { //TODO метод принимает list и в зависимости от запроса возвращает или одну или несколько записей

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

    @Override
    protected Bank mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int bankId = resultSet.getInt("bank_id");
        String name = resultSet.getString("name");
        String address = resultSet.getString("address");

        return new Bank(bankId, name, address);
    }
}
