package com.bankapplication.dao;

import com.bankapplication.model.Account;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class AccountDAOAbstract implements DaoAbstractConnector<Account> {
    @Override
    public String tableName() {
        return "bankapplication.account";
    }


    @Override
    public List<String> columnNames() {
        return Arrays.asList("account_id", "user_id", "bank_id", "balance");
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
}
