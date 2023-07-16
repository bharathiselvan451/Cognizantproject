package com.cognizant.project.model;

public class Bus {
	
	private int id;
	private String name;
	private String source;
	private String destination;
	private int price;
	
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public Bus() {
		
	}
	public Bus(int id, String name, String source, String destination, int price) {
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.id = id;
	}
}
