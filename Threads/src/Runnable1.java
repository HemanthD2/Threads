
public class Runnable1 {

	public static void main(String[] args) {
		Runnable r1 = () -> {
			try {
				Thread.sleep(3000);
				for(int i=0;i<3;i++)
				{
					System.out.println("Runnable r1 executing.."+i+" Priority "+Thread.currentThread().getPriority()+" "+Thread.currentThread().getName());
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		};
		Runnable r2 = () -> {
			try {
				Thread.sleep(6000);
				for(int i=0;i<3;i++)
				{
					System.out.println("Runnable r2 executing.."+" id is: "+Thread.currentThread().getId());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		};
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		
		String t1Name=t1.getName();
		System.out.println("t1 name by default is: "+t1Name);
		String t2Name=t2.getName();
		System.out.println("t2 name by default is: "+t2Name);

		t1.setName("runnableR1");
//		String t3Name=t1.getName();
//		System.out.println("t1 name by setName()is: "+t3Name);
		t2.setName("runnableR2");
		t1.setPriority(7);
		System.out.println("Id of Runnable r1 is: "+t1.getId());
		t1.start();
		t2.start();
		
	}
}
