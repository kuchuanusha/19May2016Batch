package com.capgemini;

public class Address {
	
	@Override
	public String toString() {
		return "Address [city=" + city + "]";
	}

	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address() {
		super();
		System.out.println("from address");
	}
	
	

}
