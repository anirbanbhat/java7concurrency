package com.anirban.basicsynchronization.readwritelock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PriceInfo {
	private double price1;
	private double price2;
	private ReadWriteLock lock;
	public PriceInfo() {
		price1 = 1.0;
		price2 = 2.0;
		lock = new ReentrantReadWriteLock();
	}
	
	public void getPrice1(){
		lock.readLock().lock();
		System.out.printf("%s Reading price1\n", Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s price1: %f\n", Thread.currentThread().getName(), price1);
		lock.readLock().unlock();
	}
	
	public void getPrice2(){
		lock.readLock().lock();
		System.out.printf("%s Reading price2\n", Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s price2: %f\n", Thread.currentThread().getName(), price2);
		lock.readLock().unlock();
	}
	
	public void setPrice(double price1, double price2){
		lock.writeLock().lock();
		System.out.printf("%s Changing price1\n", Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.price1 = price1;
		System.out.printf("%s price1 changed: %f\n", Thread.currentThread().getName(), this.price1);
		System.out.printf("%s Changing price2\n", Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.price2 = price2;
		System.out.printf("%s price2 changed: %f\n", Thread.currentThread().getName(), this.price2);
		lock.writeLock().unlock();
	}
}
