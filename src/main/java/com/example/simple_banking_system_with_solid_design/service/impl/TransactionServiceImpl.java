package com.example.simple_banking_system_with_solid_design.service;

import com.example.simple_banking_system_with_solid_design.entity.Transaction;
import com.example.simple_banking_system_with_solid_design.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repo;

    // Get all transactions
    @Override
    public List<Transaction> getAllTransactions() {
        return repo.findAll();
    }

    // Get a single transaction by ID
    @Override
    public Transaction getTransactionById(Long id) {
        Optional<Transaction> transaction = repo.findById(id);
        return transaction.orElse(null); // or throw exception
    }

    // Save a new transaction
    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return repo.save(transaction);
    }

    // Update an existing transaction
    @Override
    public Transaction updateTransaction(Long id, Transaction transactionDetails) {
        Transaction existingTransaction = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));

        existingTransaction.setAmount(transactionDetails.getAmount());
        existingTransaction.setType(transactionDetails.getType());
        existingTransaction.setDate(transactionDetails.getDate());
        // add other fields as needed

        return repo.save(existingTransaction);
    }

    // Delete a transaction by ID
    @Override
    public void deleteTransaction(Long id) {
        repo.deleteById(id);
    }
}