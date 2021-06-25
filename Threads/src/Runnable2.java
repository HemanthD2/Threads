//By using synchronized method
class Counter{
	static int v1=0;
	public synchronized void inCounter() 
	{
		++v1;
	}
	public synchronized void decCounter() 
	{
		--v1;
	}
	public synchronized void getCounter() 
	{
		System.out.println("v1 :"+v1);
	}
}
public class Runnable2 {
	public static void main(String[] args){
	
		Counter c1=new Counter();
		System.out.println("program starts..");
		Runnable increment= () -> {
			//Thread.yield();
			for(int i=0;i<3;i++)
			{
				c1.inCounter();
				c1.getCounter();
			}
		};
		Runnable decrement= () -> {
			for(int i=0;i<3;i++)
			{
				c1.decCounter();
				c1.getCounter();
			}
		};
		Thread t1=new Thread(increment);
		Thread t2=new Thread(decrement);
		
		t1.start();
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("program ends..");
	}

}
