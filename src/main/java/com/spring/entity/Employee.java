package com.spring.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Employee_Table")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String firstname;
	private String lastName;
	private String phone;
	private LocalDateTime lastLoginTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDateTime getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(LocalDateTime lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastName=" + lastName + ", phone=" + phone
				+ ", lastLoginTime=" + lastLoginTime + "]";
	}
	public Employee(int id, String firstname, String lastName, String phone, LocalDateTime lastLoginTime) {
		this.id = id;
		this.firstname = firstname;
		this.lastName = lastName;
		this.phone = phone;
		this.lastLoginTime = lastLoginTime;
	}
	
	public Employee(String firstname, String lastName, String phone, LocalDateTime lastLoginTime) {
	    this.firstname = firstname;
	    this.lastName = lastName;
	    this.phone = phone;
	    this.lastLoginTime = lastLoginTime;
	}
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

