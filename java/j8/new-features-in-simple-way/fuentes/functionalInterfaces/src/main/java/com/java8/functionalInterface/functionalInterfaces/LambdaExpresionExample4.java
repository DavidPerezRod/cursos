package com.java8.functionalInterface.functionalInterfaces;

public class LambdaExpresionExample4 {
	public static void main(String[] args) {
		FunctionalInterfaceExample4 lambdaExpresion= a-> a*a;
		System.out.println(lambdaExpresion.example4(3));
		System.out.println(lambdaExpresion.example4(4));		
	}
}
