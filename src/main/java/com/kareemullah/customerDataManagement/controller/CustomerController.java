package com.kareemullah.customerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kareemullah.customerDataManagement.dto.CustomerDto;
import com.kareemullah.customerDataManagement.dto.ResponseStructure;
import com.kareemullah.customerDataManagement.entity.Customer;
import com.kareemullah.customerDataManagement.exceptionHandling.NoDataFoundException;
import com.kareemullah.customerDataManagement.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired 
	private CustomerService service;
	
	/*@PostMapping("/customer")
	public @ResponseBody Customer saveCustomer(@RequestBody Customer customer)
	{
		return service.saveCustomer(dto);
	}*/
	
	@PostMapping("/customer")
	public @ResponseBody ResponseStructure<Customer> saveCustomer(@RequestBody CustomerDto dto)
	{
		return service.saveCustomer(dto);
	}
	
	
	@PutMapping("/customer")
	public @ResponseBody ResponseStructure<Customer> updateCustomer(@RequestBody Customer customer)
	{
		return service.updateCustomer(customer);
	}
	
	@GetMapping(value = "/customer")
	public @ResponseBody ResponseStructure<Object> getAllCustomerData() 
	{
		return service.getAllCustomerData();
	}
	
	@GetMapping("/customer/{id}")
	public @ResponseBody Customer getCustomerDataById(@PathVariable("id") int id)
	{
		return service.getCustomerDataById(id);
	}
	
	@DeleteMapping("/customer")
	public Customer deleteCustomerDataById(@RequestParam("id") int id)
	{
		return service.deleteCustomerDataById(id);
	}
	
	@GetMapping(value = "/customerbyname/{name}")
	public @ResponseBody List<Customer> getCustomerByName(@RequestBody @PathVariable("name") String name)
	{
		return service.getCustomerByName(name);
	}
	
	@PostMapping("/validateCustomer")
	public @ResponseBody List<Customer> validateCustomer( @RequestParam("name") String name,@RequestParam("email") String email)
	{
		return service.validateCustomer(name, email);
	}

}
