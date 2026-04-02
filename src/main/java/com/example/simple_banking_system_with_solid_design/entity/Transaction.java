package com.example.simple_banking_system_with_solid_design.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long transactionId;

        private Double amount;
        private LocalDateTime date;

        @ManyToOne
        private Account account;

}
