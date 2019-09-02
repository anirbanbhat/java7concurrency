package com.anirban.deadlock;

public class TestDeadLock {

	public static void main(String[] args) {
		Resource resource = new Resource();
		ProcessResource1 pr1 = new ProcessResource1(resource);
		ProcessResource2 pr2 = new ProcessResource2(resource);
		new Thread(pr1).start();
		new Thread(pr2).start();
	}
}
