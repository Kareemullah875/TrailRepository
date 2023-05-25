package com.kareemullah.customerDataManagement.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.kareemullah.customerDataManagement.entity.BankAccount;
import com.kareemullah.customerDataManagement.entity.Person;

@Repository
public class BankAccountDao 
{
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	public List<BankAccount> getByName(String name)
	{
		return bankAccountRepository.findByName(name);
	}
	
	public BankAccount getByBankId(int id)
	{
		return bankAccountRepository.findById(id).orElse(new BankAccount(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name()));
	}
	
	
	public BankAccount deleteById(int id)
	{
		BankAccount bankAccount = getByBankId(id);
		if(bankAccount != null)
		{
			bankAccountRepository.deleteById(id);
		}
		return bankAccount;
	}
	
	
}
