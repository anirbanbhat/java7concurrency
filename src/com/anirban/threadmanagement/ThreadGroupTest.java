/**
 * 
 */
package com.anirban.threadmanagement;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author abhattacherji
 *
 */
public class ThreadGroupTest implements Runnable{
	ThreadGroupTest.Result result;


	public ThreadGroupTest.Result getResult() {
		return result;
	}


	public void setResult(ThreadGroupTest.Result result) {
		this.result = result;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		ThreadGroupTest threadGroupTest = new ThreadGroupTest();
		ThreadGroupTest.Result result = threadGroupTest.new Result();
		threadGroupTest.setResult(result);
		for (int i = 0; i <5; i++) {
			Thread thread = new Thread(threadGroup, threadGroupTest);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Number of active Threads: %d\n", threadGroup.activeCount());
		System.out.printf("Information about Thread Group");
		threadGroup.list();
		waitFinish(threadGroup);
		threadGroup.interrupt();
	}
	
	private static void waitFinish(ThreadGroup threadGroup) {
		System.out.printf("Number of active Threads: %d\n", threadGroup.activeCount());
		while(threadGroup.activeCount()>4){
			System.out.printf("Number of active Threads: %d\n", threadGroup.activeCount());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.printf("Thread %s: Started\n", name);
		try {
			doTask();
			result.setName(name);
		} catch (InterruptedException e) {
			System.out.printf("Thread %s: Ended\n", name);
		}	
	}
	
	
	public void doTask() throws InterruptedException{
		Random random = new Random(new Date().getTime());
		int value = (int) (random.nextDouble()*100);
		System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), value);
		TimeUnit.SECONDS.sleep(value);
	}

	public class Result {
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
