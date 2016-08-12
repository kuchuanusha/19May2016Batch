
public class ThreadRunnable {

	public static void main(String[] args) {
		System.out.println("first");
		MyThreads mts=new MyThreads();
		Thread t=new Thread(mts);
		t.start();
		for(int i=0;i<10;i++){
			System.out.println("parent");
					
				
			}
		
		}
	}

class MyThreads implements Runnable{
	public int i;
	public void run(){
		for(i=0;i<10;i++){
		System.out.println("child");
				
			
		}
	}
}

