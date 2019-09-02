package com.anirban.basicsynchronization.basic;

import java.util.concurrent.TimeUnit;

public class Account {
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public synchronized void addBalance(double amount) {
		double tempBalance = balance;
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tempBalance += amount;
		balance = tempBalance;
		System.out.println(amount + " added. Current balance: " + balance);
	}
	
	public synchronized void subtractBalance(double amount) {
		double tempBalance = balance;
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tempBalance -= amount;
		balance = tempBalance;
		System.out.println(amount + " subtracted. Current balance: " + balance);
	}
}
