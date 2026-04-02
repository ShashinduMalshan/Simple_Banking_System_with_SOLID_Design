package com.example.simple_banking_system_with_solid_design.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {

    private Long id;
    private String name;
    private String email;
}