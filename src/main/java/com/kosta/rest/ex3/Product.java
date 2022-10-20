package com.kosta.rest.ex3;

public class Product {

	private int id;
	private String name;
	private int f_id;

	public Product() {
		super();
	}
	public Product(int id, String name, int f_id) {
		super();
		this.id = id;
		this.name = name;
		this.f_id = f_id;
	}
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
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	
	
}
