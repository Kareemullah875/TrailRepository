package com.kareemullah.customerDataManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.format.number.money.CurrencyUnitFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kareemullah.customerDataManagement.dto.CustomerDto;
import com.kareemullah.customerDataManagement.entity.Customer;

@Repository
public class CustomerDao 
{
	@Autowired
	private CustomerRepository repository;
	
	public Customer saveCustomer(Customer customer)
	{
		return repository.save(customer);
	}

	public List<Customer> getAllCustomerData()
	{
		return repository.findAll();
	}

	public Customer getCustomerDataById(int id)
	{
		//return repository.findById(id).orElse(new Customer(0,null,null));
		return repository.findById(id).orElse(new Customer(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name()));
	}
	
	public Customer deleteCustomerDataById(int id)
	{
		Customer customer = getCustomerDataById(id);
		
		if(customer.getId() != 404)
		{
			repository.deleteById(id);
		}
		 return customer;
	}
	
	public Customer updateCustomerDataById(CustomerDto customerDto)
	{
		Customer byId = repository.getById(customerDto.getId());
		
		if(byId != null)
		{
			byId.setName(customerDto.getName());
			byId.setEmail(customerDto.getEmail());
		}
		
		/*Customer customerDataById = getCustomerDataById(id);
		
		if(customerDataById != null)
		{
			customerDataById.setName(name);
			customerDataById.setEmail(email);
		}
		return customerDataById;*/
		//return repository.save(byId);
		return null;
	}
	
	public List<Customer> getCustomerByName(String name)
	{
		return repository.findByName(name);		
	}
	
	public List<Customer> validateCustomer(String name, String email)
	{
		return repository.validateCustomer(name, email);
	}


	

}
