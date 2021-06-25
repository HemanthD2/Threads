
class ThreadO implements Runnable
{
	@Override
	public void run() {
		for(int i=0;i<3;i++)
		{
			System.out.println("TaskExecuting...");
		}
	}
}
public class Mainclass1 {

	public static void main(String[] args) {
		ThreadO t1=new ThreadO();// creating object of class 
		Thread tt=new Thread(t1);//passing class object(reference) to Thread
		tt.start();
	}

}
