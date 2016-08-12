package com.capgrmini.CapStoreFinalProject.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Address {
	
	
	private String city;
	private int pinCode;
	private String state;
	private String addressLine;
	
	
	@OneToMany(mappedBy="Address")
	private Set<Address> address;
	
	
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

}
