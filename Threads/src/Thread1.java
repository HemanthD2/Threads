/*Thread is an independent part of program 
which has its own CPU time and memory for its execution.
*Threads are used for performing multiTasking in programs/applications
*Thread creation and execution is costly wrt memory and cpu time ,
so unwanted thread creation should be avoided.
*Whenever JVM starts execution it creates 3 thread
 	1.Main Thread
 	2.Garbage Collector
 	3.Thread Scheduler
 By default all the programs in java will be executed in Main Thread.
 */
class ThreadOne extends Thread
{
	@Override
	public void run() {
			for(int i=0;i<3;i++)
			{
				System.out.println("Task1 executing..");
			}	
	}
}
class ThreadTwo extends Thread
{
	@Override
	public void run() {
			for(int i=0;i<=3;i++)
			{
				System.out.println("Task2 executing.."+i+" Priority "+Thread.currentThread().getPriority());
			}
	}
}
public class Thread1 {
	
	public static void main(String[] args) {
		System.out.println("Program Starts..");
		ThreadOne t1=new ThreadOne();
		ThreadTwo t2=new ThreadTwo();
//		Runnable printFirst=new ThreadOne();
//		Runnable printSecond=new ThreadTwo();
//		Thread t1=new Thread(printFirst);
//		Thread t2=new Thread(printSecond);
		t1.setPriority(Thread.MIN_PRIORITY);
		System.out.println(t1.getPriority());
		t2.setPriority(Thread.MAX_PRIORITY);
		System.out.println(t2.getPriority());
		t1.start();
		t2.start();
		}

}
