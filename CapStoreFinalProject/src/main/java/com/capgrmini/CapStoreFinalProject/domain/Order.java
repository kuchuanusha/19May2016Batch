package com.capgrmini.CapStoreFinalProject.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private int orderId;
	
	
	@ManyToMany(mappedBy="Order")
	private Set<Product> products=new HashSet<Product>();
	
	
	@ManyToMany(mappedBy="Order")
	private Set<Customer> customers=new HashSet<Customer>();
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
}
