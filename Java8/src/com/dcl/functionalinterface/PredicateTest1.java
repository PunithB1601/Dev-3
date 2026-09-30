package com.dcl.functionalinterface;

import java.util.function.Predicate;

/**
interface Demo1{
	
	boolean validate(Integer i);
	
}

class DemoImpl implements Demo1{

	@Override
	public boolean validate(Integer i) {
		if(i%3==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
**/

public class PredicateTest1 {

	public static void main(String[] args) {
		
	/**	//To check given num is divisible by 3 or not.
		Demo1 d=new DemoImpl();
		boolean status=d.validate(3);
		if(status) {
			System.out.println("num is divisble");
		}
		else {
			System.out.println("num is not divisible");
		}
		**/
		Predicate<Integer> p=(i)->i%3==0;
		if(p.test(3)) {
			System.out.println("Num is divisible");
		}
		else {
			System.out.println("Num is not divisible");
		}
		
	}
}
