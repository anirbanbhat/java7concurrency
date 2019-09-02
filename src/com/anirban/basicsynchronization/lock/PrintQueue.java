package com.anirban.basicsynchronization.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	private final Lock queueLock = new ReentrantLock();
	
	public void print(Object doc){
		queueLock.lock();
		try {
			Long duration = (long) (Math.random()*10000);
			System.out.printf("Thread %s is printing for %d seconds...\n", Thread.currentThread().getName(), duration/1000);
			TimeUnit.SECONDS.sleep(duration/1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			queueLock.unlock();
		}
	}

}
