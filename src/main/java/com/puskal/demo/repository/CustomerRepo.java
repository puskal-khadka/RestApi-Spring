package com.puskal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puskal.demo.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {


}

