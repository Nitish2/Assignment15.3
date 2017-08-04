package synchronizedLock;

public class DeadLock {
	
	// Creates first method and extends runnable interface
	// t1 tries to lock resource1 then resource2  
	static class First_Thread implements Runnable { 
		

		public void run() // Run method 
		        {
			synchronized (Integer.class) { // Passing Integer class in a synchronized method
				System.out.println(Thread.currentThread().getName()+ " locked on integer class" );
				synchronized (String.class) {// Passing string class in a synchronized method
					System.out.println(Thread.currentThread().getName()+ "locked on string class");
				}
			}
			}
		}
	
	/*
	 * In second method , we are passing the Integer and string classes but in reverse order.
	 * That's why Creates method and extends runnable interface
	 * This will arise a deadlock. 
	 */

	// t2 tries to lock resource2 then resource1  
	static class Second_Thread implements Runnable {

		public void run() {
			synchronized (String.class) {
				System.out.println(Thread.currentThread().getName()+ " locked on string class");
				synchronized (Integer.class) {
					System.out.println(Thread.currentThread().getName()+ "locked on integer class");
				}
			}
		}

	}

	public static void main(String[] args) { //Creating main method 
		// Creating threads x
		Thread t1=new Thread(new First_Thread());
		Thread t2= new Thread(new Second_Thread());
		
		//Initializing thread with string arguments 
		t1.setName("First thread ");
		t2.setName("Second thread");
		// Starting Both threads
		t1.start();
		t2.start();
		
		
	
	
	
	}

}
