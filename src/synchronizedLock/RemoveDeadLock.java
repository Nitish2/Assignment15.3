package synchronizedLock;



public class RemoveDeadLock {
	static class First_Thread implements Runnable {

		public void run() {
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName() + "locked on Integer class");
				synchronized (String.class) {
					System.out.println(Thread.currentThread().getName() + "locked on String class");
				}
			}
		}
	}
	/*
	 * In second method , we are passing the Integer and string classes but in same order 
	 */

	static class Second_Thread implements Runnable {

		public void run() {
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName() + "locked on Integer class");
				synchronized (String.class) {
					System.out.println(Thread.currentThread().getName() + "locked on Integer class");
				}
			}
		}

	}

	/**
	 * here we create the main method then create the two thread for calling the
	 * method run
	 */
	public static void main(String[] args) {
		Thread t1=new Thread(new First_Thread());
		Thread t2= new Thread(new Second_Thread());
		t1.setName("First thread ");
		t2.setName("Second thread");
		t1.start();
		t2.start();
		
	}



}
