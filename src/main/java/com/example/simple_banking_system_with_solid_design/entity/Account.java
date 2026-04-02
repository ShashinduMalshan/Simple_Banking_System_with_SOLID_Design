package com.example.simple_banking_system_with_solid_design.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    private Double balance;

    @ManyToOne
    private Customer customer;

}
