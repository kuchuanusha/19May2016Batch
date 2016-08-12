package com.capgemini.service;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;

public interface AccountService {
	
	public Account createAccount(int accountNumber,int amount) throws InsufficientInitialBalanceException;
	public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException;
	public int withdrawAmount(int accountNumber,int amount)throws InvalidAccountNumberException,InsufficientBalanceException;

}
