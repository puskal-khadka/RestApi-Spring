package com.puskal.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.puskal.demo.entity.Customer;
import com.puskal.demo.service.CustomerService;

@RestController
public class CustomerControl {
@Autowired
CustomerService cs;

//create customer 
@PostMapping("/customer")
public Customer create(@Valid @RequestBody Customer c) {
	return cs.insert(c);
}

//display all customer
@GetMapping("/customer")
public List<Customer> display(){
	return cs.show();
}


//display particular id 
@RequestMapping(value = "customer/{id}", method = RequestMethod.GET )
public Optional<Customer> getCust(@PathVariable("id") int id) {
	return this.cs.getCustomer(id);
}


//update record of customer

//this can be also done by applying above method 'displaying particular id" -Puskal khadka
@PutMapping("/customer/{id}")
public ResponseEntity<Customer> update(@PathVariable(value="id") int id,@Valid @RequestBody Customer cust )
{
	Customer c=cs.find(id);
	if(c==null) {
		return ResponseEntity.noContent().build();
	}
    c.setName(cust.getName());
    c.setAddress(cust.getAddress());
    
    Customer update=cs.insert(c);
    
    return ResponseEntity.ok().body(update);
}




//delete customer
@DeleteMapping ("/customer/{id}")
public ResponseEntity<Customer> deletecust(@PathVariable(value="id") int id)  {
Customer c=cs.find(id);
if(c==null) {
	return ResponseEntity.notFound().build();
}
cs.delete(c);
return ResponseEntity.ok().build();


}
}

