package com.bankapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Transaction {
    private int transactionId;
    private int fromAccountId;
    private int toAccountId;
    private double amount;
    private Timestamp transactionDate;
    private String description;
}
