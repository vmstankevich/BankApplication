package com.bankapplication;

import com.bankapplication.dao.*;
import com.bankapplication.model.Account;
import com.bankapplication.model.Bank;
import com.bankapplication.model.Transaction;
import com.bankapplication.model.User;

public class ClearDataBase {
    public static void main(String[] args) {

        DaoAbstractConnector<Account> accountDao = new AccountDAOAbstract();
        DaoAbstractConnector<Bank> bankDao = new BankDAOAbstract();
        DaoAbstractConnector<Transaction> transactionDao = new TransactionDAOAbstract();
        DaoAbstractConnector<User> userDao = new UserDAOAbstract();

        accountDao.deleteDataFromTables();
        bankDao.deleteDataFromTables();
        transactionDao.deleteDataFromTables();
        userDao.deleteDataFromTables();
    }
}
