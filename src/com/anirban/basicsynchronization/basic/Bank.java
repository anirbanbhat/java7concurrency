package com.anirban.basicsynchronization.basic;

public class Bank implements Runnable{
	private Account account;

	public Bank(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.subtractBalance(1000);
		}		
	}	
}
