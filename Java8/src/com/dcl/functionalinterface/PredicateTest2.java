package com.dcl.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest2 {

	public static void main(String[] args) {
		
		List<String> names=Arrays.asList("Rahul","Manoj","Basavraj","Sachin","Abhishek","Suraj","Syed","Akash");
		//1. Display the names which has more than 5 characters
		//2. Display the names which starts with 'S'.
		//3. Display the names which starts with S and length is more than 4.
		
		Predicate<String> p1=(name)->name.length()>5;
		
		for(String a:names) {
			if(p1.test(a)) {
				System.out.println(a);
			}
		}
		
		System.out.println("==================");
		
		Predicate<String>p2=(name)->name.startsWith("S");
		
		for(String b:names) {
			if(p2.test(b)) {
				System.out.println(b);
			}
		}
		
		System.out.println("==================");
		
		Predicate<String> p3=(name)->name.startsWith("S")&&name.length()>4;
		for(String c:names) {
			if(p3.test(c)) {
				System.out.println(c);
			}
		}
		
		System.out.println("==================");
		Predicate<String> p31=(name)->name.startsWith("S");
		Predicate<String> p32=(name)->name.length()>4;
		
		Predicate<String> pFinal=p31.and(p32);
		for(String d:names) {
			if(pFinal.test(d)) {
				System.out.println(d);
			}
		}
	}
}


