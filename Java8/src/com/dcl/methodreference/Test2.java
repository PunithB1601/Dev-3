package com.dcl.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test2 {

	public static void main(String[] args) {
		
		List<String> names=Arrays.asList("Rahul","Manoj","Basavraj","Sachin","Abhishek","Suraj","Syed","Akash");
		
		//1st apprach
		for(int i=0;i<names.size();i++) {
			System.out.println(names.get(i));
		}
		
		System.out.println("===========");
		
		for(String s:names) {
			System.out.println(s);
		}
		
		System.out.println("============");
		Consumer<String> c=(s)->System.out.println(s);
		names.forEach(c);
		System.out.println("============");
		names.forEach(System.out::println);
	}
}
