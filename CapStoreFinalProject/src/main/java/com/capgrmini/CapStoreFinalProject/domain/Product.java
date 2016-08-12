package com.capgrmini.CapStoreFinalProject.domain;

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

@Entity
public class Product {
	
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private int productId;
	private String productName;
	private int productCost;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "productOrder", joinColumns = @JoinColumn(name = "productId", referencedColumnName = "productId") , inverseJoinColumns = @JoinColumn(name = "orderId", referencedColumnName = "orderId"))
	private Set<Order> orders = new HashSet<Order>();

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	

}
