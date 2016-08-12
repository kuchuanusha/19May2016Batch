package com.capgrmini.CapStoreFinalProject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankDetails {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private int bankAccountNumber;
	
	private String bankName;
	
	private int balance;

	
	
	
	public BankDetails() {
		super();
	}

	public int getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(int bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int i) {
		this.balance = i;
	}
	
	
	
}
