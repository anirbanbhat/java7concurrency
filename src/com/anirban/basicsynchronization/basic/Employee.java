package com.anirban.basicsynchronization.basic;

public class Employee {

	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);
		
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		
		System.out.println("Initial balance: " + account.getBalance());
		bankThread.start();
		companyThread.start();
		try {
			bankThread.join();
			companyThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Final balance: " + account.getBalance());
	}

}
