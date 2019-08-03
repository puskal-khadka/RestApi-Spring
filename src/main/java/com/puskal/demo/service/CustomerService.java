package com.puskal.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puskal.demo.entity.Customer;
import com.puskal.demo.repository.CustomerRepo;

@Service
public class CustomerService {
@Autowired
  CustomerRepo crepo;

//create 
public Customer insert(Customer c) {
	return crepo.save(c);
}

//display all
public List<Customer> show(){
	return crepo.findAll();
}

//display particular
public Optional<Customer> getCustomer(int id) {
	return crepo.findById(id);
}

//show particular customer by id
public Customer find(int id) {
	return crepo.getOne(id);
}

//delete 
public void delete(Customer c) {
	crepo.delete(c);
}


}



