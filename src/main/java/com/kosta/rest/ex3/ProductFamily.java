package com.kosta.rest.ex3;

public class ProductFamily {

	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductFamily() {
		super();
	}
	public ProductFamily(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
