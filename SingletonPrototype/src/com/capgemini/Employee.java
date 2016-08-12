package com.capgemini;

public class Employee {
	
	private int employeeNumber;
	private String name;
	
	private Address address;
	

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



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public Employee() {
		super();
		System.out.println("from employee");
	}



	
	
}
