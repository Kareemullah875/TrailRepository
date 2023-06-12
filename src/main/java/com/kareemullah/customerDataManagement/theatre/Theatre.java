package com.kareemullah.customerDataManagement.theatre;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "threatre_info")
public class Theatre implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "theatre")
	private List<Screens> noOfScreens;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Screens> getNoOfScreens() {
		return noOfScreens;
	}

	public void setNoOfScreens(List<Screens> noOfScreens) {
		this.noOfScreens = noOfScreens;
	}

	public Theatre(Integer id, String name, String location, List<Screens> noOfScreens) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.noOfScreens = noOfScreens;
	}

	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
