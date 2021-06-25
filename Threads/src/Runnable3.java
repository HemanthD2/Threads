//By using synchronized block
public class Runnable3 {
	static String str=new String("Hello");
	public static void main(String[] args) {
		
		Runnable r1=()->{
			synchronized (str) {
				str=str.concat(" Hemanth");
				System.out.println(str);
			}
		};
		Runnable r2=()->{
			synchronized (str) {
				str=str.concat(" Ram");
				System.out.println(str);
			}
		};
		
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);


		t1.start();
		t2.start();
	}

}
