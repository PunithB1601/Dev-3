package com.dcl.functionalinterface;


interface Operation{
	int add(int a, int b);
}

//(a,b)-> a+b;


public class Operators {
	public static void main(String[] args) {
		Operation o=(a,b)->a+b;
		System.out.println(o.add(10, 30)); 
	}
}


