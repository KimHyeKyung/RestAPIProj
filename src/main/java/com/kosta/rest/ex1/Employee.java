package com.kosta.rest.ex1;

public class Employee {

	Department department;
	String id;
	String name;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee() {
		super();
	}
	public Employee(Department department, String id, String name) {
		super();
		this.department = department;
		this.id = id;
		this.name = name;
	}
	
	
	
}
