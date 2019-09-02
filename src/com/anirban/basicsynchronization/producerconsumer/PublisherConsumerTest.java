package com.anirban.basicsynchronization.producerconsumer;

public class PublisherConsumerTest {
	
	public static void main(String[] args) {
		EventStorage eventStorage = new EventStorage();
		Publisher publisher = new Publisher(eventStorage);
		Consumer consumer = new Consumer(eventStorage);
		Thread publisherThread = new Thread(publisher);
		Thread consumerThread = new Thread(consumer);
		publisherThread.start();
		consumerThread.start();
		try {
			publisherThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Propcess ended");
	}
}
