package com.dcl.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerSupplierTest {

	public static void main(String[] args) {
		
	// Supplier<Return Type>	
		Supplier<String> s=()->"Keshav";
		//public String demo(){
		//	return "Raju";
		//}
		
		//s.get();
	// Consumer<Input Type>	
		Consumer<String> c=(in)->System.out.println(in.charAt(2));
		c.accept(s.get());
	}
}
