
public class ThreadExample1 {

	public static void main(String[] args) {
		Runnable r=new Runnable(){
			public void run(){
				System.out.println(Thread.currentThread().getName());
			}
		};
		Thread t=new Thread();
		t.start();
		System.out.println(Thread.currentThread().getName());
		
	}
}
