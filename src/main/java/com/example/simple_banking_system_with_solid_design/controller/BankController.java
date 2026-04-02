package com.example.simple_banking_system_with_solid_design.controller;

import com.example.simple_banking_system_with_solid_design.entity.Account;
import com.example.simple_banking_system_with_solid_design.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342") // allow frontend

public class BankController {



        private final AccountService accountService;


        // Get account by ID
        @GetMapping("/{id}")
        public Account getAccountById(@PathVariable Long id) {
            return accountService.getAccountById(id);
        }

        // Create a new account
        @PostMapping
        public Account createAccount(@RequestBody Account account) {
            return accountService.saveAccount(account);
        }

        // Delete an account
        @DeleteMapping("/{id}")
        public void deleteAccount(@PathVariable Long id) {
            accountService.deleteAccount(id);
        }


    }

