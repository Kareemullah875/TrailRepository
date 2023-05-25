package com.kareemullah.customerDataManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kareemullah.customerDataManagement.entity.Customer;

//@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>  //1-entity class name 2- data type of primary key
{

//	public Customer save(Customer customer);

	List<Customer> findByName(String name);
	
	@Query("SELECT c FROM Customer c WHERE c.name=:name AND c.email=:email")
	List<Customer> validateCustomer(@Param("name") String name, @Param("email") String email);
}
