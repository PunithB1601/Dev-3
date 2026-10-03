package com.dcl.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerTest {

	public static void main(String[] args) {
		
		String a="Rahul";
		Consumer<String> c=(in)->System.out.println(in);
		c.accept(a);
		
		System.out.println("==================");
		
		Supplier<String> s=()->a;
		System.out.println(s.get()); 
	}
}
