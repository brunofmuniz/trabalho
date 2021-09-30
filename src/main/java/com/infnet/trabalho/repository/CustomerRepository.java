package com.infnet.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infnet.trabalho.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
