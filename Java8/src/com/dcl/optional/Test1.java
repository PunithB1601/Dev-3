package com.dcl.optional;

import java.util.EmptyStackException;
import java.util.Optional;

public class Test1 {

	public static void main(String[] args) {
		
		String name=null;
	
		Optional<Object> oc=Optional.ofNullable(name);
	//	Integer len=(Integer)oc.get();
		
	//		String n=(String)oc.get();
	//		System.out.println(n.length());
		
		
		String abc=(String)oc.orElse(null);
		System.out.println(abc);
	}
}
