package com.cust.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cust.sb.entity.Customer;
import com.cust.sb.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public String addCustomer(Customer customer)
	{
		 customerRepository.save(customer);
		 return "customer added";
	}
	
	public List<Customer> getAllCustomer()
	{
		return customerRepository.findAll();
		  
	}
	
	public Customer getCustomerById(Integer customerId)
	{
		 Customer customer=customerRepository.findById(customerId).orElse(null);
		 
			 return customer;
	}
	
	public String deleteCustomer(Integer customerId)
	{
		Customer customer=customerRepository.findById(customerId).orElse(null);
		 if(customer!=null)
		 {
			 customerRepository.deleteById(customerId);
			 return "customer deleted";
		 }
		 else
		 {
			 return "customer not found";
		 }
	}
	
	public String updateCustomer(Integer customerId,Customer customer) {
		Customer cust=customerRepository.findById(customerId).orElse(null);
		if(cust!=null)
		{
			customerRepository.save(customer);
			return "customer updated";
		}
		else
		{
			return "customer not found";
		}
	}

}
