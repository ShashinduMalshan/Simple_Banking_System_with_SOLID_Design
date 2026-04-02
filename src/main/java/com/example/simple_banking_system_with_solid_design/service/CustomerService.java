package com.example.simple_banking_system_with_solid_design.service;

import com.example.simple_banking_system_with_solid_design.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    // Get a customer by ID
    Customer getCustomerById(Long id);

    // Save a new customer
    Customer saveCustomer(Customer customer);

    // Update an existing customer
    Customer updateCustomer(Long id, Customer customerDetails);

    // Delete a customer by ID
    void deleteCustomer(Long id);
}
