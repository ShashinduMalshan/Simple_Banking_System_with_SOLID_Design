package com.example.simple_banking_system_with_solid_design.controller;

import com.example.simple_banking_system_with_solid_design.entity.Transaction;
import com.example.simple_banking_system_with_solid_design.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342") // adjust for your frontend
public class TransactionController {

    private final TransactionService service;
    // Deposit money to an account
    @PostMapping("/deposit/{accountId}")
    public Transaction deposit(@PathVariable Long accountId, @RequestParam Double amount) {
        return service.deposit(accountId, amount);
    }

    // Withdraw money from an account
    @PostMapping("/withdraw/{accountId}")
    public Transaction withdraw(@PathVariable Long accountId, @RequestParam Double amount) {
        return service.withdraw(accountId, amount);
    }
}