package com.java8.functionalInterface.functionalInterfaces;

public class LambdaExpresionExample3 {
	public static void main(String[] args) {
		FunctionalInterfaceExample3 lambdaExpresion= s-> s.length();
		System.out.println(lambdaExpresion.example3("Hola"));
		System.out.println(lambdaExpresion.example3("Mundo"));		
	}
}
