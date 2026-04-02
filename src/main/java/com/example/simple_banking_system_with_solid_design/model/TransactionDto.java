package com.example.simple_banking_system_with_solid_design.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TransactionDto {

    private Long transactionId;
    private Double amount;
    private Long accountNumber;
    private LocalDateTime date;

}
