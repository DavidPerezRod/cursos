package com.java8.functionalInterface.functionalInterfaces;

public class ThreadDemo {

	public static void main(String[] args) {
		Runnable lambda = () -> {
			for (int i = 0; i < 50; i++) {
				System.out.println("child thread");
			}
		};

		Thread t = new Thread(lambda);
		t.start();
		for (int i = 0; i < 50; i++) {
			System.out.println("main thread");
		}
	}
}
