package com.anirban.basicsynchronization.readwritelock;

public class ReadWriteLockTest {

	public static void main(String[] args) {
		PriceInfo priceInfo = new PriceInfo();
		Reader reader = new Reader(priceInfo);
		Writer writer = new Writer(priceInfo);
		Thread[] readThreads = new Thread[10];
		
		for (int i = 0; i < readThreads.length; i++) {
			readThreads[i] = new Thread(reader);
			readThreads[i].start();
		}
		Thread[] writeThreads = new Thread[3];
		
		for (int i = 0; i < writeThreads.length; i++) {
			readThreads[i] = new Thread(writer);
			readThreads[i].start();
		}
	}

}
