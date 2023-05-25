package com.kareemullah.customerDataManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kareemullah.customerDataManagement.entity.BankAccount;
import com.kareemullah.customerDataManagement.entity.Person;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer>
{
	List<BankAccount> findByName(String name);
	
	

}
