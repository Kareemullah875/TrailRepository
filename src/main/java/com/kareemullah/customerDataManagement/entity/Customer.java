package com.kareemullah.customerDataManagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kareemullah.customerDataManagement.dto.CustomerDto;

import lombok.AllArgsConstructor;
import lombok.Data;  // lombok is used to remove to boiler plates code(duplicate elements) from application
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_info")
public class Customer implements Serializable      //serializable is used make properties secured
{
	
	public Customer(int i, Object object, Object object2) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	private String email;

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

	public Customer(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Customer() {
		super();
		
	}
	
	public Customer(CustomerDto dto)
	{
		this.id=dto.getId();
		this.name=dto.getName();
		this.email=dto.getEmail();
	}
	
	

}
