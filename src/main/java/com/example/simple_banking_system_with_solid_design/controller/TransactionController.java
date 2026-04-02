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


    // GET transaction by ID
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return service.getTransactionById(id);
    }

    // POST create new transaction
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return service.saveTransaction(transaction);
    }

    // PUT update existing transaction
    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        return service.updateTransaction(id, transaction);
    }

    // DELETE transaction
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        service.deleteTransaction(id);
    }
}