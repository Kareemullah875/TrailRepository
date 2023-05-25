package com.kareemullah.customerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kareemullah.customerDataManagement.entity.BankAccount;
import com.kareemullah.customerDataManagement.entity.Person;
import com.kareemullah.customerDataManagement.service.BankService;
import com.kareemullah.customerDataManagement.service.PersonService;

@RestController
public class PersonController 
{
	@Autowired
	public PersonService personService;
	
	@PostMapping(value = "/person")
	public @ResponseBody Person savePerson(@RequestBody Person person) 
	{
		return  personService.save(person);
	}
	
	@GetMapping(value = "/getperson")
	public  @ResponseBody List<Person> getAll() 
	{
		return personService.getAll();
		
	}
	
	@GetMapping("/getbypersonname/{name}")
	public @ResponseBody List<Person> getByName( @PathVariable("name") String name)
	{
		return personService.getByName(name);
	}
	
	@GetMapping(value = "/getbypersonid")
	public @ResponseBody Person getByPersonId(@RequestParam("id") int id)
	{
		return personService.getByPersonId(id);
	}
	
	@GetMapping(value = "/deletepersonbyid/{id}")
	public @ResponseBody Person deletePerson(@PathVariable("id") int id)
	{
		return  personService.deletePersonById(id);
	}
	
	/*@GetMapping("/getbybankaccount")
	public @ResponseBody List<BankAccount> getByBankAccount(@RequestParam("account") BankAccount accounts)
	{
		return personService.getByBankAccount(accounts);
	}*/
	
	@PutMapping("/updatepersonandbank")
	public Person updatePersonAndBankAccount( @RequestBody Person person) 
	{
		return personService.updatePersonAndBankAccount(person);
	}
	
	

}
