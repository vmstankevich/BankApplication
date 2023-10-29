package com.bankapplication;

import com.bankapplication.dao.BankDAO;
import com.bankapplication.model.Bank;

public class MainBankApplication {
    public static void main(String[] args) {
        Bank bank1 = new Bank(1, "Golden Bank", "01-791, Warszawa, Mazowiecka str. 23");
        Bank bank2 = new Bank(2, "PKO", "47-100, Strzelce Opolskie, Matejki str. 11");
        Bank bank3 = new Bank(3, "Santander Bank", "23-467, Poznań, Mickewicza str. 1a");
        Bank bank4 = new Bank(4, "Alior Bank", "01-791, Kraków, Armii krajowej str. 156");
        Bank bank5 = new Bank(5, "MBank", "01-791, Wrocław, Poznańska str. 3");

        BankDAO bankDao = new BankDAO();

        bankDao.createBank(bank1);
        bankDao.createBank(bank2);
        bankDao.createBank(bank3);
        bankDao.createBank(bank4);
        bankDao.createBank(bank5);
    }
}
