public class Runnable4 {
	static String str1=new String("hello");
	static String str2=new String("Task");
	
	public static void main(String[] args) {
		System.out.println("program starts... ");
		Runnable r1=()->{
			System.out.println("t1 waiting to lock str1");
			synchronized (str1) {
				
				System.out.println("t1 locked str1");
				System.out.println(str1);
				System.out.println("t1 waiting to lock str2");
				
				try {
					System.out.println("t1 going to wait state");
					
					Thread.sleep(1000);
					str1.wait(5000);
					System.out.println("t1 came back to execution state");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (str2) {
				System.out.println("t1 locked str2");
				System.out.println(str2.concat(str1));
				System.out.println("t1 released lock on str2");
				}
			}
			System.out.println("t1 release lock on str1");
		};
		Runnable r2=()->{
			System.out.println("t2 starts... ");
			
			System.out.println("t2 waiting to lock str2");
			synchronized (str2) {
				System.out.println("t2 locked str2");
				System.out.println(str2);
				System.out.println("t2 waiting to lock str1");
				
				synchronized (str1) {
				System.out.println("t2 locked str1");
				System.out.println(str1);
				System.out.println("t2 unlocked str1");
				}
				System.out.println("t2 unlocked str2");
			}
			System.out.println("t2 ends");
		};
		
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		t1.start();
		t2.start();
	}

}
