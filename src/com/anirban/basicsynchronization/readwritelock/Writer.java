package com.anirban.basicsynchronization.readwritelock;

public class Writer implements Runnable{
	private PriceInfo priceInfo;

	public Writer(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

	@Override
	public void run() {
		System.out.printf("%s is attempting to modify price...\n", Thread.currentThread().getName());
		priceInfo.setPrice(Math.random()*8, Math.random()*9);
		System.out.printf("%s has modified price...\n", Thread.currentThread().getName());
	}
}
