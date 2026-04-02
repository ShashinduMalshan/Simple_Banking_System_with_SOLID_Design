package com.example.simple_banking_system_with_solid_design.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long transactionId;

        private Double amount;
        private String type;

        private LocalDateTime date;

        @ManyToOne
        @JoinColumn(name = "accountNumber") // foreign key column
        private Account account;
}