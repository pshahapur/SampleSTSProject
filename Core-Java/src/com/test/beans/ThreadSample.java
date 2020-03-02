package com.test.beans;

public class ThreadSample extends Thread{

	public void run() {
		System.out.println("run method");
	}
	
	public static void main(String[] args) {
		ThreadSample t1 = new ThreadSample();
		t1.start();
	}
}
