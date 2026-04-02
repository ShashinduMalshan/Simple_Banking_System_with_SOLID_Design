package com.example.simple_banking_system_with_solid_design.repository;

import com.example.simple_banking_system_with_solid_design.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
