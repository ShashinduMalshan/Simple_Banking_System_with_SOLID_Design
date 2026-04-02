package com.example.simple_banking_system_with_solid_design.service;

import com.example.simple_banking_system_with_solid_design.entity.Account;

public interface AccountService {
    Account deposit(Long accountId, Double amount);

    Account withdraw(Long accountId, Double amount);

    void deleteAccount(Long id);

    Account getAccountById(Long id);

    Account saveAccount(Account account);
}
