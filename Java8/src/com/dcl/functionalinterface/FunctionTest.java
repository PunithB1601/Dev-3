package com.dcl.functionalinterface;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
	//to obtain the no of chars present in given string	
		
		Function<String, Integer> f=(in)->in.length();
		Integer res=f.apply("Rajath");
		System.out.println(res);
		
		Function<String, Character> f2=(in)->in.charAt(2);
		System.out.println(f2.apply("Raju"));
	}
}
