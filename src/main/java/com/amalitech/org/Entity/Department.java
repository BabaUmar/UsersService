package com.amalitech.org.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Department {
	@GeneratedValue
	@Id
	private int id;
	private String departname;

	public Department(int id, String departname) {
		super();
		this.id = id;
		this.departname = departname;
	}
	
	public Department() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartname() {
		return departname;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	

}
