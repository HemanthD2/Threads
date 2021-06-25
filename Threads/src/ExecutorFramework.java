import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AppServer{
	public static void login() {
		System.out.println("login Successful");
	}
}
public class ExecutorFramework {
	
	public static void main(String[] args) {
		Runnable r1=() ->{
			AppServer.login();
		};
		
		ExecutorService executor=Executors.newCachedThreadPool();
		for(int i=0;i<3;i++)
		{
			executor.submit(r1);
		}
	}

}
