package com.java8.functionalInterface.functionalInterfaces;

public class LambdaExpresionExample2 {
	public static void main(String[] args) {
		FunctionalInterfaceExample2 lambdaExpresion= (a,b)-> System.out.print("la suma es:"+ (a+b));
		lambdaExpresion.example2(6, 7);
		lambdaExpresion.example2(100, 200);		
	}
}
