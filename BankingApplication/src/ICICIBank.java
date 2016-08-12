import java.util.LinkedList;

public class ICICIBank {
	
	LinkedList<Account> accounts =new LinkedList<Account>();
	
	
	public String createAccount(int accountNumber,Customer customer,int amount)
	{
		
		Account account=new Account(accountNumber,customer,amount);
		accounts.add(account);
		return "account created successfully";
	}
	
	public Account searchAccount(int accountNumber)throws InvalidAccountNumberException
	{
		for(Account account:accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		
		throw new InvalidAccountNumberException();
	}
	
	public  int withdrawAmount(int accountNumber,int amount) throws InsufficientBalanceException, InvalidAccountNumberException
	{
		Account account=searchAccount(accountNumber);
		
		synchronized(account){
			//System.out.println("before withdraw"+account.getAmount());
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			System.out.println("after withdraw:"+account.getAmount());
			return account.getAmount();
		}
		}
		
		throw new InsufficientBalanceException();
		
	}
	public  Account depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException{
		Account account=searchAccount(accountNumber);
		
		synchronized(account){
			System.out.println("before deposit"+account.getAmount());
		account.setAmount(account.getAmount()+amount);	
		System.out.println("after deposit"+account.getAmount());		
		return account;   
		}
				
	}
	public Account[] transferAmount(int accountNumber1 ,int accountNumber2,int amount) throws InsufficientBalanceException, InvalidAccountNumberException,MinimumBalanceException{
		Account[] accountList=new Account[2];
		accountList[0]=searchAccount(accountNumber1);
		accountList[1]=searchAccount(accountNumber2);
		if(accountList[0].getAmount()>500)
		{
				if(accountList[0].getAmount()-amount>=0){
					
					accountList[0].setAmount(accountList[0].getAmount()-amount);
					accountList[1].setAmount(accountList[1].getAmount()+amount);
					
					return accountList;
			    }
		}
				
	 throw new MinimumBalanceException();
	}



}
