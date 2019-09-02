package com.anirban.basicsynchronization.producerconsumer;

public class Publisher implements Runnable {
	private EventStorage eventStorage;

	public Publisher(EventStorage eventStorage) {
		this.eventStorage = eventStorage;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			eventStorage.set();
			
		}
	}
}
