package com.example.simple_banking_system_with_solid_design.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long accountNumber;
    private Double balance;
    private Long customerId;
}
