package com.bankapplication;

import com.bankapplication.dao.*;
import com.bankapplication.model.Account;
import com.bankapplication.model.Bank;
import com.bankapplication.model.Transaction;
import com.bankapplication.model.User;

import java.sql.SQLOutput;
import java.sql.Timestamp;


public class MainBankApplication {
    public static void main(String[] args) {

        // Добавление банков в БД

        Bank bank1 = new Bank(1, "Golden Bank", "01-791, Warszawa, Mazowiecka str. 23");
        Bank bank2 = new Bank(2, "PKO", "47-100, Strzelce Opolskie, Matejki str. 11");
        Bank bank3 = new Bank(3, "Santander Bank", "23-467, Poznań, Mickewicza str. 1a");
        Bank bank4 = new Bank(4, "Alior Bank", "01-791, Kraków, Armii krajowej str. 156");
        Bank bank5 = new Bank(5, "MBank", "01-791, Wrocław, Poznańska str. 3");


        //Добавление и чтение банков в БД

        DaoAbstractConnector<Bank> bankDao = new BankDAOAbstract();

        bankDao.read(bank1.getBankId());

        bankDao.create(bank1);
        bankDao.create(bank2);
        bankDao.create(bank3);
        bankDao.create(bank4);
        bankDao.create(bank5);

        System.out.println(bankDao.read(bank1.getBankId()));

        // Добавление и чтение пользователей в БД

        User user1 = new User(
                1, "random", "Viktar Stankevich", "1234", "vmstankevich@gmail.com");

        DaoAbstractConnector<User> userDAO = new UserDAOAbstract();

        userDAO.create(user1);
        System.out.println("Создали нового пользователя");
        System.out.println(userDAO.read(user1.getUserId()));

        // Добавление и чтение счетов в БД

        Account account1 = new Account(122456780, user1.getUserId(), bank1.getBankId(), 10.00);
        Account account2 = new Account(122456789, user1.getUserId(), bank1.getBankId(), 0.00);

        DaoAbstractConnector<Account> accountDAO = new AccountDAOAbstract();

        accountDAO.create(account1);
        accountDAO.create(account2);

        System.out.println(account1.getAccountId());

        // Добавление и чтение транзакций в БД

        Transaction transaction1 = new Transaction(
                15, account1.getAccountId(), account2.getAccountId(), 5.00,
                new Timestamp(System.currentTimeMillis()), "prezent");

        DaoAbstractConnector<Transaction> transactionDAO = new TransactionDAOAbstract();

        transactionDAO.create(transaction1);
        System.out.println(transactionDAO.read(transaction1.getTransactionId()));
    }
}
