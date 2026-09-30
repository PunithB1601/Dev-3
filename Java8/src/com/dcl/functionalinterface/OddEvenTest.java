package com.dcl.functionalinterface;

interface OddEven{
	String checkNum(int a);
}



public class OddEvenTest {

	public static void main(String[] args) {
		OddEven oe=(a)->
		{
			if(a%2==0) {
				return "even";
			}else {
				return"odd";
			}
		};
		
		System.out.println(oe.checkNum(10)); 
		
	}
}
