package com.example.simple_banking_system_with_solid_design.service;

import com.example.simple_banking_system_with_solid_design.entity.Account;

public interface AccountService {

    void deleteAccount(Long id);

    Account getAccountById(Long id);

    Account saveAccount(Account account);
}
