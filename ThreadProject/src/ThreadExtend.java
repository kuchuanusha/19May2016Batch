
public class ThreadExtend {

	public static void main(String[] args) {
		System.out.println("first");
		MyThread mt=new MyThread();
		mt.start();
		for(int i=0;i<10;i++){
		try{
			System.out.println("Parent");
			Thread.sleep(1000);
		}catch(InterruptedException e)
		{
			
		}
		}
	}
}
class MyThread extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			try{
				System.out.println("child");
				Thread.sleep(1000);
			}catch(InterruptedException e)
			{
				
			}
		
		}
	}
}
