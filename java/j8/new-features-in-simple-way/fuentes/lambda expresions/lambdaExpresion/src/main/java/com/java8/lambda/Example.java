package com.java8.lambda;

/**
 * A Java lambda is an anonymous function, what is:
 * 		- not having name
 *      - not havind modifiers
 *      - not having any return type.
 */
public class Example {
	
	public void example1() {
		System.out.print("hello");
	}
	
	//////////////////////////////////
	/// equivalent lamda function ////
	//////////////////////////////////
	
	//   () -> {System.out.print("hello");}
	
	// curly braces could be removed when they have a single sentence
	//   () -> System.out.print("hello");
	
	public void example2(int a, int b) {
		System.out.print(a+b);
	}
	
	//////////////////////////////////
	/// equivalent lamda function ////
	//////////////////////////////////
	
	//   (int a, int b) -> {System.out.print(a+b);}

	// curly braces could be removed when they have a single sentence
	//   (int a, int b) -> System.out.print(a+b);
	
	// parameter types could be inferred by compiler
	//   (a, b) -> System.out.print(a+b);	


	public int example3(String s) {
		return s.length();
	}
	
	//////////////////////////////////
	/// equivalent lamda function ////
	//////////////////////////////////
	
	//   (String s) -> {return s.length();}
	
	// curly braces could be removed when they have a single sentence
	// (String s) -> return s.length();
	
	// parameter types could be inferred by compiler
	// (s) -> return s.length();
	
	// return directive could be inferred by compiler
	// (s) -> s.length();
	
	// patenthesis are optional with a single parameter
	// s -> s.length();

}
