package com.cust.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cust.sb.entity.Customer;

import com.cust.sb.service.CustomerService;
@RestController
@RequestMapping("/auth")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/admin/addcustomer")
	public String addCustomer(@RequestBody Customer customer)
	{
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/admin/getall")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomer();
		  
	}
	@GetMapping("/user/{customerId}")
	public Customer getCustomerById(@PathVariable Integer customerId)
	{
		  return customerService.getCustomerById(customerId);
	}
	
	@DeleteMapping("/admin/{customerId}")
	public String deleteCustomer(@PathVariable Integer customerId)
	{
		return customerService.deleteCustomer(customerId);
	}
	
	@PutMapping("/admin/{customerId}")
	public String updateCustomer(@PathVariable Integer customerId,@RequestBody Customer customer) {
		return customerService.updateCustomer(customerId, customer);
	}

}
