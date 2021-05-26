package com.amalitech.org.Entity;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
//import javax.persistence.Column;


@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String email;
	private String name;
	
	@CreationTimestamp
	private Date createdDate;
	
	@UpdateTimestamp
	private Date updatedDate;
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	public User(String email, String name, UserGroup userGroup, Department department) {
		super();
		this.email = email;
		this.name = name;
		this.userGroup = userGroup;
		this.department = department;
	}
	public User(String email, String name, UserGroup userGroup) {
		super();
		this.email = email;
		this.name = name;
		this.userGroup = userGroup;
		
	}
	
	//Relationship 
		@ManyToOne
		@JoinColumn(name ="Usergroup_Id")
		private UserGroup userGroup;
		
		@ManyToOne
		@JoinColumn(name ="Department_Id")
		private Department department;
		
		
	public void setUserGroup(UserGroup userGroup) {
			this.userGroup = userGroup;
		}

	public User() {
		super();
	}
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

//	public User(String name, String email) {
//		super();
////		this.id = id;
//		this.name = name;
//		this.email = email;
//	}
	
	public UserGroup getUserGroup() {
		return userGroup;
	}
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	

}
