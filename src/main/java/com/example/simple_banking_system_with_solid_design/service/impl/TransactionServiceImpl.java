package com.example.simple_banking_system_with_solid_design.service.impl;

import com.example.simple_banking_system_with_solid_design.entity.Account;
import com.example.simple_banking_system_with_solid_design.entity.Transaction;
import com.example.simple_banking_system_with_solid_design.repository.AccountRepository;
import com.example.simple_banking_system_with_solid_design.repository.TransactionRepository;
import com.example.simple_banking_system_with_solid_design.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepo;
    private final AccountRepository accountRepo;

    @Override
    public Transaction deposit(Long accountId, Double amount) {
        Optional<Account> accountOpt = accountRepo.findById(accountId);
        if (accountOpt.isEmpty()) return null;

        Account account = accountOpt.get();
        account.setBalance(account.getBalance() + amount);
        accountRepo.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setDate(LocalDateTime.now());

        return transactionRepo.save(transaction);
    }

    @Override
    public Transaction withdraw(Long accountId, Double amount) {
        Optional<Account> accountOpt = accountRepo.findById(accountId);
        if (accountOpt.isEmpty()) return null;

        Account account = accountOpt.get();
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        accountRepo.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(-amount); // negative for withdrawal
        transaction.setDate(LocalDateTime.now());

        return transactionRepo.save(transaction);
    }
}