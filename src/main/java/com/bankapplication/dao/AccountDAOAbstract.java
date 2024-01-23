package com.bankapplication.dao;

import com.bankapplication.model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class AccountDAOAbstract extends DaoAbstractConnector<Account> {

    private final static String tableName = "bankapplication.account";

    private final static List<String> columnNames = Arrays.asList("account_id", "user_id", "bank_id", "balance");

    public AccountDAOAbstract() {
        super(tableName, columnNames);
    }

    @Override
    public PreparedStatement process(PreparedStatement ps, Account account) throws SQLException {
        int i = 0;
        ps.setInt(++i, account.getAccountId());
        ps.setInt(++i, account.getUserId());
        ps.setInt(++i, account.getBankId());
        ps.setDouble(++i, account.getBalance());
        return ps;
    }

    @Override
    protected Account mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int accountId = resultSet.getInt("account_id");
        int userId = resultSet.getInt("user_id");
        int bankId = resultSet.getInt("bank_id");
        double balance = resultSet.getDouble("balance");

        return new Account(accountId, userId, bankId, balance);
    }

}
