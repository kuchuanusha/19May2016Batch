package com.capgemini;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Employee {
	
	private int employeeNumber;
	private String name;
	
	private List<Address> address;
	private Set<Address> addressSet;
	private Map<Integer,Address> addressMap;
	private Properties addressProperties;

	public Set<Address> getAddressSet() {
		return addressSet;
	}



	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", name=" + name + ", address=" + address
				+ ", addressSet=" + addressSet + ", addressMap=" + addressMap + ", addressProperties="
				+ addressProperties + "]";
	}



	public void setAddressSet(Set<Address> addressSet) {
		this.addressSet = addressSet;
	}





	public Map<Integer, Address> getAddressMap() {
		return addressMap;
	}



	public void setAddressMap(Map<Integer, Address> addressMap) {
		this.addressMap = addressMap;
	}



	public Properties getAddressProperties() {
		return addressProperties;
	}



	public void setAddressProperties(Properties addressProperties) {
		this.addressProperties = addressProperties;
	}



	public int getEmployeeNumber() {
		return employeeNumber;
	}

	

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public List<Address> getAddress() {
		return address;
	}



	public void setAddress(List<Address> address) {
		this.address = address;
	}

	
	
}
