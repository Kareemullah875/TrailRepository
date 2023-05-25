package com.kareemullah.customerDataManagement.service;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.kareemullah.customerDataManagement.dto.CustomerDto;
import com.kareemullah.customerDataManagement.dto.ResponseStructure;
import com.kareemullah.customerDataManagement.entity.Customer;
import com.kareemullah.customerDataManagement.repository.CustomerDao;
import com.kareemullah.customerDataManagement.repository.CustomerRepository;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerDao dao;
	
	public ResponseStructure<Customer> saveCustomer(CustomerDto dto)
	{
		//return dao.saveCustomer(dto);
		Customer cus = new Customer(dto);
		Customer customer = dao.saveCustomer(cus);
		ResponseStructure<Customer> rs = new ResponseStructure<>();
		rs.setData(customer);
		rs.setTimeStamp(LocalDateTime.now());
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Customer data save Successfully");
		return rs;
		
	
	}
	
	public ResponseStructure<Customer> updateCustomer(Customer customer)
	{
	//	return dao.saveCustomer(customer);
		Customer cus= dao.saveCustomer(customer);
		ResponseStructure<Customer> rs = new ResponseStructure<>();
		rs.setData(cus);
		rs.setStatusCode(HttpStatus.ACCEPTED.value());
		rs.setTimeStamp(LocalDateTime.now());
		rs.setMessage(HttpStatus.ACCEPTED.name());
		
		return rs;
	}
	
	public ResponseStructure<Object> getAllCustomerData()
	{
		//return dao.getAllCustomerData();
		List<Customer> list = dao.getAllCustomerData();
		ResponseStructure<Object> rs = new ResponseStructure<>();

		if(list.size()!=0)
		{
			rs.setData(list);
			rs.setTimeStamp(LocalDateTime.now());
			rs.setStatusCode(HttpStatus.FOUND.value());
			rs.setMessage("Customer entry found in database ");	
		}
		else
		{
			rs.setData(null);
			rs.setTimeStamp(LocalDateTime.now());
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			rs.setMessage(" No Customer entry found in database ");		
		}
		return rs;
			
	
	}
	
	public Customer getCustomerDataById(int id)
	{
		return dao.getCustomerDataById(id);
	}

	public Customer deleteCustomerDataById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteCustomerDataById(id);
	}
	
	public List<Customer> getCustomerByName(String name)
	{
		return dao.getCustomerByName(name);	
	}
	
	public List<Customer> validateCustomer(String name, String email)
	{
		return dao.validateCustomer(name, email);
	}
}
