package com.example.simple_banking_system_with_solid_design.service;

import com.example.simple_banking_system_with_solid_design.entity.Transaction;

import java.util.List;

public interface TransactionService {
    // Get all transactions
    List<Transaction> getAllTransactions();

    // Get a single transaction by ID
    Transaction getTransactionById(Long id);

    // Save a new transaction
    Transaction saveTransaction(Transaction transaction);

    // Update an existing transaction
    Transaction updateTransaction(Long id, Transaction transactionDetails);

    // Delete a transaction by ID
    void deleteTransaction(Long id);
}
