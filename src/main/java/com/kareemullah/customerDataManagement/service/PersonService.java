package com.kareemullah.customerDataManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kareemullah.customerDataManagement.entity.BankAccount;
import com.kareemullah.customerDataManagement.entity.Person;
import com.kareemullah.customerDataManagement.repository.BankAccountDao;
import com.kareemullah.customerDataManagement.repository.BankAccountRepository;
import com.kareemullah.customerDataManagement.repository.PersonDao;

@Service
public class PersonService 
{
	@Autowired
	public PersonDao personDao;
	
	
	public Person save(Person person)
	{
		return personDao.save(person);
		
	}
	
	public List<Person> getAll()
	{
		return personDao.getAll();
	}
	
	public List<Person> getByName(String name)
	{
		return personDao.getByName(name);
	}
	
	public Person getByPersonId(int id)
	{
		return personDao.getByPersonId(id);
	}
	
	public Person updatePersonAndBankAccount( Person person) 
	{
		return personDao.updatePersonAndBankAccount(person);
	}
	
	public Person deletePersonById(int id)
	{
		return personDao.deletePersonById(id);
	}
	
/*	public List<BankAccount> getByBankAccount(BankAccount accounts)
	{
		return personDao.getByBankAccount(accounts);
	}*/
}
