package com.kareemullah.customerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kareemullah.customerDataManagement.entity.BankAccount;
import com.kareemullah.customerDataManagement.service.BankService;

@RestController
public class BankController 
{
	@Autowired
	private BankService bankService;
	
	
	@GetMapping("/getbybaname")
	public @ResponseBody List<BankAccount> getByName1(@RequestParam("name") String name)
	{
		return bankService.getByName(name);
	}
	
	@GetMapping("/getbybankid")
	public @ResponseBody BankAccount getByBankId(@RequestParam("id") int id)
	{
		return bankService.getByBankId(id);
	}
	

	
	@GetMapping("/deletebankacbyid")
	public @ResponseBody BankAccount deleteBankAcById(@RequestParam("id") int id)
	{
		return bankService.deleteBankAcById(id);
	}
	


}
