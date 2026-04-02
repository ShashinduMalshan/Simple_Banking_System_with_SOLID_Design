package com.example.simple_banking_system_with_solid_design.service;

import com.example.simple_banking_system_with_solid_design.entity.Account;
import com.example.simple_banking_system_with_solid_design.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repo;

    @Override
    public Account getAccountById(Long id) {
        Optional<Account> account = repo.findById(id);
        return account.orElse(null); // return null if not found
    }

    @Override
    public Account saveAccount(Account account) {
        return repo.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        repo.deleteById(id);
    }
}