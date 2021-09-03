package com.java8.functionalInterface.functionalInterfaces;

public interface FunctionalInterfaceErrorExample {
	@FunctionalInterface
	public interface FunctionalInterfaceExample {
		
		public void abstractMethod1();
		
		public void abstractMethod2();		
		
		default void method(){}
		
		public static void method2() {}

	}
}
