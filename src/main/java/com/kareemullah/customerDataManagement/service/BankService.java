package com.kareemullah.customerDataManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kareemullah.customerDataManagement.entity.BankAccount;
import com.kareemullah.customerDataManagement.repository.BankAccountDao;
import com.kareemullah.customerDataManagement.repository.BankAccountRepository;

@Service
public class BankService 
{
	@Autowired
	public BankAccountDao bankAccountDao;
	
	public List<BankAccount> getByName(String name)
	{
		return bankAccountDao.getByName(name);
	}
	
	public BankAccount getByBankId(int id)
	{
		return bankAccountDao.getByBankId(id);
	}
	
	public BankAccount deleteBankAcById(int id)
	{
		return bankAccountDao.deleteById(id);
	}
	

}
