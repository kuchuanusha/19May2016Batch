package com.capgemini.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;;
public class AccountTest {

	@Mock
	AccountRepository accountRepository;
	
	AccountService accountService;
	@Before
	public void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);	
	accountService=new AccountServiceImpl(accountRepository);
	}

	// when the amount is less than 500 it should throw exception
	// when the valid info is passed account obj should be created successfully
	
	@Test(expected = com.capgemini.exceptions.InsufficientInitialBalanceException.class)
	public void whenTheAmountIsLessThan500ItShouldThrowException() throws InsufficientInitialBalanceException
	{
		accountService.createAccount(101, 200);
	}
	
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientInitialBalanceException
	{
		Account account=new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		when(accountRepository.save(account)).thenReturn(true);
		assertEquals(account.getAmount(), accountService.createAccount(101, 5000).getAmount());
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void InValidAccountNumberExceptionDuringDeposit() throws InvalidAccountNumberException{
		accountService.depositAmount(150, 2000);
	}
	
	@Test(expected=com.capgemini.exceptions.InsufficientBalanceException.class)
	public void InsufficientBalanceExceptionDuringWithDraw() throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientInitialBalanceException{
		Account account=new Account();
		account.setAccountNumber(102);
		account.setAmount(6000);
		when(accountRepository.searchAccount(102)).thenReturn(account);
		accountService.withdrawAmount(102, 10000);
	}
	
	
}
