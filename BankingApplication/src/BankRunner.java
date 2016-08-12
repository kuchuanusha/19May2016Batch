
public class BankRunner implements Runnable {
	ICICIBank bank;
	public BankRunner(ICICIBank bank){
		this.bank=bank;
	}
		public void run(){
			try{
			if(Thread.currentThread().getName().equals("first")){
				Account account=bank.searchAccount(101);
			System.out.println("before withdraw:"+account.getAmount());
				System.out.println("balance="+bank.withdrawAmount(101,1000));
			}
				else
					System.out.println("balance="+bank.depositAmount(101,2000).getAmount());	
		}catch(InvalidAccountNumberException ian)
		{
			System.out.println("Invalid account number");
		}catch(InsufficientBalanceException ibe)
		{
			System.out.println("Insufficient balance");
		}
		
	}
	
}
