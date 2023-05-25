package com.kareemullah.customerDataManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.kareemullah.customerDataManagement.entity.BankAccount;
import com.kareemullah.customerDataManagement.entity.Customer;
import com.kareemullah.customerDataManagement.entity.Person;

@Repository
public class PersonDao 
{
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private BankAccountRepository br;
	
	public Person save(Person person)
	{
		List<BankAccount> list = person.getAccounts();
		
		for(int i=0;i<list.size();i++)
		{
			BankAccount account = list.get(i);
			
			account.setPerson(person);
			
			br.save(account);
			
		}
		return person;
	}

	public Person updatePersonAndBankAccount( Person p)
	{
		Person p1 = personRepository.getById(p.getId());
		
		p1.setName(p.getName());
		p1.setEmail(p.getEmail());
		
		List<BankAccount> a1=p1.getAccounts();
		
		List<BankAccount> a2=p.getAccounts();
		
		for(int i=0;i<a1.size();i++)
		{
			BankAccount account1 = a1.get(i);
			
			BankAccount account2 = a2.get(i);
			
			account1.setAccountNumber(account2.getAccountNumber());
			
			account1.setName(account2.getName());
			
			
			
		}
		return personRepository.save(p1);
		
	}
	
	public List<Person> getAll()
	{
		return personRepository.findAll();
	}
/*	public void getByBankAccount(BankAccount account)
	{
		return personRepository.findById(account);
	}*/
	
	public List<Person> getByName(String name)
	{
		return personRepository.findByName(name);
	}

	
	
	/*public Person getByBankId(int id)
	{
			return personRepository.findById(id).orElse(new Person(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name()));
	}*/
	
	public Person getByPersonId(int id)
	{
		return personRepository.findById(id).orElse(new Person(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name()));
	}
	
/*	public Person deleteBankAc(int id)
	{
		Person bankac = getByBankId(id);
		
		if(bankac.getId()!= null)
		{
		personRepository.deleteById(id);
		}
		return bankac;
	}
	*/
	public Person deletePersonById(int id)
	{
		Person per = getByPersonId(id);
		
		if(per.getId()!= null)
		{
		personRepository.deleteById(id);
		}
		return per;
	}
	
/*	public List<BankAccount> getByBankAccount(BankAccount accounts)
	{
		return personRepository.getByBankAccount(accounts);
	}*/

}
