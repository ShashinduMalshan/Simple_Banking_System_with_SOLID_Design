package com.example.simple_banking_system_with_solid_design.repository;

import com.example.simple_banking_system_with_solid_design.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
