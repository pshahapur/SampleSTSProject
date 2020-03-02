package com.thread.test;

public class InterThread {
	public static final int MAX_NUMBER = 10;
	public static void main(String[] args) {
		InterThread ob = new InterThread();
		Thread t1 = new Thread(new runnableThread(ob, 0), "T1");
		Thread t2 = new Thread(new runnableThread(ob, 1), "T2");
		Thread t3 = new Thread(new runnableThread(ob, 2), "T3");
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}

class runnableThread implements Runnable {
	InterThread obj;
	int threadNumber;
	int number = 0;
	runnableThread(InterThread object, int result) {
		this.obj = object;
		this.threadNumber = result;
	}
	
	@Override
	public void run() {
		while(number < InterThread.MAX_NUMBER) {
			synchronized(obj) {
				if(number % 3 == threadNumber && number < InterThread.MAX_NUMBER ) {
					System.out.println(Thread.currentThread().getName() + " : " + ++number);
				}
			}
		}
	}
	
}
