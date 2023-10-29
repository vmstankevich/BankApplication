package com.bankapplication.model;

public class Account {
    private String account_id;
    private double balance;
    private int userId;

    public Account(String accountNumber, double balance, int userId) {
        this.account_id = accountNumber;
        this.balance = balance;
        this.userId = userId;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
