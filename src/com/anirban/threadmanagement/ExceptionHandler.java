/**
 * 
 */
package com.anirban.threadmanagement;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * @author abhattacherji
 *
 */
public class ExceptionHandler implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		int i = Integer.parseInt("TEST");
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ExceptionHandler e = new ExceptionHandler();
		Thread t = new Thread(e);
		t.setUncaughtExceptionHandler(e.new Handler());
		t.start();
		t.join();
		System.out.println("Back to main thread!");
	}
	
	class Handler implements UncaughtExceptionHandler {

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.printf("An Exception has been caught\n");
			System.out.printf("Thread : %s\n", t.getId());
			System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
			System.out.printf("StakeTrace:\n");
			e.printStackTrace(System.out);
			System.out.printf("Thread statue: %s", t.getState());
		}
		
	}

}
