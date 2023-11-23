package com.bankapplication.dao;

import com.bankapplication.model.Transaction;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class TransactionDAOAbstract extends DaoAbstractConnector<Transaction> {
    private final static String tableName = "bankapplication.transaction";
    private final static List<String> columnNames = Arrays.asList(
            "transaction_id", "from_account_id", "to_account_id", "amount", "transaction_date", "description");

    public TransactionDAOAbstract() {
        super(tableName, columnNames);
    }


    @Override
    public PreparedStatement process(PreparedStatement ps, Transaction transaction) throws SQLException {
        int i = 0;
        ps.setInt(++i, transaction.getTransactionId());
        ps.setInt(++i, transaction.getFromAccountId());
        ps.setInt(++i, transaction.getToAccountId());
        ps.setDouble(++i, transaction.getAmount());
        ps.setTimestamp(++i, transaction.getTransactionDate());
        ps.setString(++i, transaction.getDescription());

        return ps;
    }
}
