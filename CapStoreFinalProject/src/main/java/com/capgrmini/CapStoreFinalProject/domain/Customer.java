package com.capgrmini.CapStoreFinalProject.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Customer {
	
	

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private int customerId;
	
	private String name;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	private String password;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="AddressLine")
	private Set<Address> address=new HashSet();
	

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="BankACcountNumber")
	private int BankACcountNumber;
	
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "customerProduct", joinColumns = @JoinColumn(name = "customerId", referencedColumnName = "customerId") , inverseJoinColumns = @JoinColumn(name = "productId", referencedColumnName = "productId"))
	private Set<Product> products = new HashSet<Product>();

	
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "customerOrder", joinColumns = @JoinColumn(name = "customerId", referencedColumnName = "customerId") , inverseJoinColumns = @JoinColumn(name = "orderId", referencedColumnName = "orderId"))
	private Set<Order> orders = new HashSet<Order>();
	
	
	
	public Customer() {
		super();
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public int getBankACcountNumber() {
		return BankACcountNumber;
	}

	public void setBankACcountNumber(int bankACcountNumber) {
		BankACcountNumber = bankACcountNumber;
	}



}
