package com.example.simple_banking_system_with_solid_design.service.impl;

import com.example.simple_banking_system_with_solid_design.entity.Customer;
import com.example.simple_banking_system_with_solid_design.repository.CustomerRepository;
import com.example.simple_banking_system_with_solid_design.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repo;

    @Override
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    // Get a customer by ID
    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = repo.findById(id);
        return customer.orElse(null);  // or throw exception if preferred
    }

    // Save a new customer
    @Override
    public Customer saveCustomer(Customer customer) {
        return repo.save(customer);
    }

    // Update an existing customer
    @Override
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer existingCustomer = repo.findById(id).orElseThrow(() ->
                new RuntimeException("Customer not found with id " + id)
        );

        existingCustomer.setName(customerDetails.getName());
        existingCustomer.setEmail(customerDetails.getEmail());
        // add more fields as needed

        return repo.save(existingCustomer);
    }

    // Delete a customer by ID
    @Override
    public void deleteCustomer(Long id) {
        repo.deleteById(id);
    }
}
