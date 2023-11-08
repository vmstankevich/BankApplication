package com.bankapplication.model;


public class Bank {
    private int bankId;
    private String name;
    private String address;


    public Bank() {

    }
    public Bank(int bankId, String name, String address) {
        this.bankId = bankId;
        this.name = name;
        this.address = address;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankId=" + bankId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

