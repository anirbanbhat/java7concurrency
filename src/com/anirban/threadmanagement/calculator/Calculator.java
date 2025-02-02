package com.anirban.threadmanagement.calculator;

class Calculator implements Runnable {
	int number;

	public Calculator(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%s: %d*%d=%d\n", Thread.currentThread().getName(), number, i, (number * i));
		}
	}

}