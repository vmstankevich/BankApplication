package com.bankapplication.model;

public class Account {
    private int accountId;
    int userId;
    int bankId;
    private double balance;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(int accountId, int userId, int bankId, double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.bankId = bankId;
        this.balance = balance;
    }
}
