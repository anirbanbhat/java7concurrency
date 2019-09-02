package com.anirban.basicsynchronization.lock;

public class LockTest {

	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		Job job = new Job(printQueue);
		
		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(job);
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Document printing completed");
	}

}
