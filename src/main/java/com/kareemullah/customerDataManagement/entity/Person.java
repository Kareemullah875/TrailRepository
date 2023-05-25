package com.kareemullah.customerDataManagement.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "person_info")
public class Person implements Serializable
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "person")
	private List<BankAccount> accounts;

	public Person(int value, String name2, String name3) {
		// TODO Auto-generated constructor stub
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(Integer id, String name, String email, List<BankAccount> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.accounts = accounts;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

}
