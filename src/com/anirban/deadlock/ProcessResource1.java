package com.anirban.deadlock;

public class ProcessResource1 implements Runnable {
	private Resource resource;
	public ProcessResource1(Resource resource) {
		this.resource = resource;
	}
	@Override
	public void run() {
		resource.method1();
		resource.method2();
	}

}
