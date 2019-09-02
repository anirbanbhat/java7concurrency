/**
 * 
 */
package com.anirban.threadmanagement;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author abhattacherji
 *
 */
public class FileSearch implements Runnable {
	private String initPath;
	private String fileName;
	public FileSearch(String initPath, String fileName) {
		super();
		this.initPath = initPath;
		this.fileName = fileName;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileSearch fileSearch = new FileSearch("C:\\", "OCPJP Training Schedule 2016.txt");
		FileSearch.Time time = fileSearch.new Time();
		Thread thread = new Thread(fileSearch);
		Thread timeThread = new Thread(time);
		thread.start();
		timeThread.start();
		try{
			TimeUnit.SECONDS.sleep(10);
			thread.join();
		} catch (InterruptedException e ){
			e.printStackTrace();
		}
		timeThread.interrupt();
		//thread.interrupt();
	}

	@Override
	public void run() {
		File file = new File(initPath);
		if(file.isDirectory()){
			try {
				directoryProcess(file);
			} catch (InterruptedException e) {
				System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
			}
		}
		
	}
	
	public void directoryProcess(File file) throws InterruptedException {
		File list[] = file.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if(list[i].isDirectory()){
					//System.out.printf("%s: Search Path: %s\n", Thread.currentThread().getName(), list[i].getPath());
					directoryProcess(list[i]);
				} else {
					fileProcess(list[i]);
				}
			} 
		}
		if (Thread.interrupted()){
			throw new InterruptedException();
		}
	}
	
	public void fileProcess(File file) throws InterruptedException {
		if(file.getName().equals(fileName)){
			System.out.printf("\n%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
			throw new InterruptedException();
		}
		if (Thread.interrupted()){
			throw new InterruptedException();
		}
	}
	
	class Time implements Runnable {

		@Override
		public void run() {
			int i = 1;
			System.out.print("Searching");
			while (true) {
				System.out.print(".");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					System.out.printf("%s: The time interrupted", Thread.currentThread().getName());
				}
			}
			
		}
		
	}

}
