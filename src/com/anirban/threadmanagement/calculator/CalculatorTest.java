package com.anirban.threadmanagement.calculator;


public class CalculatorTest {
	
	public static void main(String[] args) {
		Thread threads[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator(i + 1));
			threads[i].setName("Thread " + i);
		}
		for (int i = 0; i < 10; i++) {
			threads[i].start();
		}
		for (int i = 0; i < 10; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
