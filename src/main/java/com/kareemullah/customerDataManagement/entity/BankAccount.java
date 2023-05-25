package com.kareemullah.customerDataManagement.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.sym.Name;

import lombok.Data;

@Entity
@Data
@Table(name = "bank_account_info")
public class BankAccount implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private Integer id;
	
	private String name;
	
	@Column(name = "account_number")
	private String accountNumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	@JsonIgnore
	private Person person;

	public BankAccount(int value, String name2, String name3) {
		// TODO Auto-generated constructor stub
	}

	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount(Integer id, String name, String accountNumber, Person person) {
		super();
		this.id = id;
		this.name = name;
		this.accountNumber = accountNumber;
		this.person = person;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
