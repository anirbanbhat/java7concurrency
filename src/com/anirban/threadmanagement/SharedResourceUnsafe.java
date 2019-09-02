/**
 * 
 */
package com.anirban.threadmanagement;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author abhattacherji
 *
 */
public class SharedResourceUnsafe implements Runnable {
	private Date date;
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		date = new Date();
		System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), date);
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint((Math.random()*10)));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), date);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SharedResourceUnsafe resource = new SharedResourceUnsafe();
		Thread threads[] = new Thread[5];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(resource, "Thread " + i);
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();	
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
