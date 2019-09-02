package com.anirban.basicsynchronization.readwritelock;

public class Reader implements Runnable{
	private PriceInfo priceInfo;

	public Reader(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10 ; i++) {
			priceInfo.getPrice1();
			priceInfo.getPrice2();
		}
	}

}
