package com.capgemini.service;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService{

	AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository)
	{
		this.accountRepository=accountRepository;
	}
	@Override
	public Account createAccount(int accountNumber, int amount) throws InsufficientInitialBalanceException {
		
		if(amount<500)
		{
			throw new InsufficientInitialBalanceException();
		}
		Account account=new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		if(accountRepository.save(account))
		{
			return account;
		}
		return null;
	}

	@Override
	public int depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException {
		Account a=accountRepository.searchAccount(accountNumber);
		if(a!=null)
		{
				
					
					int x=a.getAmount()+amount;
					a.setAmount(x);
					return a.getAmount();
					
			    }
				
			
			
			
		
		else{
			throw new InvalidAccountNumberException();
		}
	}

	@Override
	public int withdrawAmount(int accountNumber, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		Account a=accountRepository.searchAccount(accountNumber);
		if(a!=null)
		{
			
				if(a.getAmount()>amount)
				{
					
					int x=a.getAmount()-amount;
					a.setAmount(x);
					return a.getAmount();
					
			    }
				else{
					throw new InsufficientBalanceException();
				}
			}
			
			
		
		else{
		     throw new InvalidAccountNumberException();
		}
	}

}
