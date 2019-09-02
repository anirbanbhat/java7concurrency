package com.anirban.basicsynchronization.lock;

public class Job implements Runnable{
	private PrintQueue printQueue;
	
	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	public void run() {
		System.out.printf("Thread %s isgoing to print Documents\n", Thread.currentThread().getName());
		printQueue.print(new Object());
		System.out.printf("Thread %s has to printed Documents\n", Thread.currentThread().getName());
	}
}
