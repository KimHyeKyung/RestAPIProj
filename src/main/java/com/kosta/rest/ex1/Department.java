package com.kosta.rest.ex1;

public class Department {

	String id;		//부서번호
	String name;	//부서명
	
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
	public Department() {
		super();
	}
	public Department(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
