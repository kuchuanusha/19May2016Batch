
public class AssignmentThread {
	public static void main(String[] args) {
		MyThreadAssignment FirstThread=new MyThreadAssignment(1,5);
		Thread t1=new Thread(FirstThread,"FirstThread");
		MyThreadAssignment SecondThread=new MyThreadAssignment(6,10);
		Thread t2=new Thread( SecondThread,"SecondThread");
		MyThreadAssignment  ThirdThread=new MyThreadAssignment(11,15);
		
		Thread t3=new Thread(ThirdThread,"ThirdThread");
		
		t1.start();
		try{
		t2.start();
		Thread.sleep(1000);
		}catch(InterruptedException iex){
			
		}
		try{
			t3.start();
			Thread.sleep(2000);
			}catch(InterruptedException iex){
				
			}
		
	}

}
class MyThreadAssignment implements Runnable{
	int start;
	int end;
	public MyThreadAssignment(int i,int j){
		start=i;
		end=j;
	}
	
	public void run(){
		for(int i=start;i<=end;i++)
		System.out.println(MyThreadAssignment.getName()+"-"+i);
		
	}
	private static String getName() {
		// TODO Auto-generated method stub
		return Thread.currentThread().getName();
	}
}