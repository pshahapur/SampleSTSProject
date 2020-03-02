package com.test.beans;

public class ThreadTest implements Runnable{

	@Override
	public void run() {
		System.out.println("run method ");
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadTest());
		t1.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("run 2 method");
				
			}
		}).start();
		
		new Thread(() -> System.out.println("run 3")
				).start();;
	}

}
