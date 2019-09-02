package com.anirban.deadlock;

public class ProcessResource2 implements Runnable {
	private Resource resource;
	public ProcessResource2(Resource resource) {
		this.resource = resource;
	}
	@Override
	public void run() {
		resource.method1();
		resource.method2();
	}

}