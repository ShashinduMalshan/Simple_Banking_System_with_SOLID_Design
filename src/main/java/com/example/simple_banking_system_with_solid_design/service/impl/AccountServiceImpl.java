package com.example.simple_banking_system_with_solid_design.service.impl;

import com.example.simple_banking_system_with_solid_design.entity.Account;
import com.example.simple_banking_system_with_solid_design.entity.Transaction;
import com.example.simple_banking_system_with_solid_design.repository.AccountRepository;
import com.example.simple_banking_system_with_solid_design.repository.TransactionRepository;
import com.example.simple_banking_system_with_solid_design.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public Account deposit(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        // Record the transaction
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setDate(LocalDateTime.now());
        transactionRepository.save(transaction);

        return account;
    }

    @Override
    public Account withdraw(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        // Record the transaction as negative amount
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(-amount);
        transaction.setDate(LocalDateTime.now());
        transactionRepository.save(transaction);

        return account;
    }
}