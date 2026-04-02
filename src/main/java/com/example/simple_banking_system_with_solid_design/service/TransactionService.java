package com.example.simple_banking_system_with_solid_design.service;

import com.example.simple_banking_system_with_solid_design.entity.Transaction;


public interface TransactionService {

    Transaction deposit(Long accountId, Double amount);

    Transaction withdraw(Long accountId, Double amount);
}
