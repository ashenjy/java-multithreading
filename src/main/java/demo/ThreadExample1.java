package demo;

public class ThreadExample1 {

	public static void main(String[] args) {

		Thread3 thread1 = new Thread3("threadname1");
		thread1.start();
		Thread3 thread2 = new Thread3("threadname2");
		thread2.start();
	}
}

class Thread3 implements Runnable {

	Thread thread;
	private String name;
	Thread3(String threadname) {
		name = threadname;
	}

	public void run() {
		System.out.println("Thread running " + name);

		for (int i = 0; i < 4; i++) {
			System.out.println(i);
			System.out.println(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread has been interrupted");
			}
		}
	}

	public void start() {
		System.out.println("Thread started");

		/*taking an if condition to check whether class variable thread 
		has value in it or no. If its null then we are creating an instance using 
		thread class which takes the name as a parameter (value for which was assigned 
		in the constructor). After which the thread is started using start() method.*/
		if (thread == null) {
			thread = new Thread(this, name);
			thread.start();
		}

	}


	//OUTPUT

	/*
	 * Thread started
		Thread started
		Thread running threadname1
		0
		threadname1
		Thread running threadname2
		0
		threadname2
		1
		threadname1
		1
		threadname2
		2
		threadname1
		2
		threadname2
		3
		threadname1
		3
		threadname2
	 */
}
