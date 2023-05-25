package com.kareemullah.customerDataManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kareemullah.customerDataManagement.entity.BankAccount;
import com.kareemullah.customerDataManagement.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>
{

	List<Person> findByName(String name);
	
	//List<BankAccount> getByBankAccount(BankAccount accounts);

	


	

}
