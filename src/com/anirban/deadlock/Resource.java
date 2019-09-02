package com.anirban.deadlock;

import java.util.concurrent.TimeUnit;

public class Resource {

	private Object lock1;
	private Object lock2;
	public Resource() {
		this.lock1 = new Object();
		this.lock2 = new Object();
	}
	
	public void method1(){
		synchronized (lock1) {
			try {
				TimeUnit.SECONDS.wait(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void method2(){
		synchronized (lock2) {
			try {
				TimeUnit.SECONDS.wait(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
