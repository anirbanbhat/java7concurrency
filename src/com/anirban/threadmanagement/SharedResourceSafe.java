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
public class SharedResourceSafe implements Runnable {
	public static ThreadLocal<Date> localDate = new ThreadLocal<Date>(){
			protected Date initialValue(){
				return new Date();
			}
	};
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Date date = localDate.get();
		System.out.printf("Starting Thread: %s : %s", Thread.currentThread().getId(), date);
		try {
			int time = (int) Math.rint((Math.random()*10));
			System.out.println(": Sleping time: " + time);
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), date);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SharedResourceSafe resource = new SharedResourceSafe();
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
