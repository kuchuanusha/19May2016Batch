import java.lang.Thread;
public class Client {

	public static void main(String[] args) {
		ICICIBank bank=new ICICIBank();
		
		System.out.println(bank.createAccount(101,new Customer("anu",new Address("vizag")), 2000));
		
		System.out.println(bank.createAccount(102,new Customer("prathi",new Address("visakhapatnam")), 3000));
		BankRunner bankRunner=new BankRunner(bank);
		Thread childThread1=new Thread(bankRunner,"first");
		childThread1.start();
		
		Thread childThread2=new Thread(bankRunner,"second");
		childThread2.start();

}
}