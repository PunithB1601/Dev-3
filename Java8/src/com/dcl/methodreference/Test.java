package com.dcl.methodreference;

public class Test {

	public Test() {
		System.out.println("0-param");
	}
	
	public Test(Integer a, Integer b) {
		System.out.println("param-con");
	}
	
	public static void main(String[] args) {
		
		// Approach-1
		DemoI d1=new DemoImpl();
		System.out.println(d1.add(10, 20)); 
		
		System.out.println("=============");
		
		// Approach-2
		DemoI d2=(a,b)-> a+b;
		System.out.println(d2.add(12, 13));
		
		System.out.println("==============");
		
		// Approach-3
		Test t=new Test();
		DemoI d3=(a,b)->t.testAdd(a, b);
		System.out.println(d3.add(20,40)); 
		
		System.out.println("==============");

		//Approach-4
//Syntax: 	FI ref-var=ref-var-of-class::instance-method-name
		DemoI d4=t::testAdd;
		System.out.println(d4.add(45, 42));
		
		System.out.println("==============");
		
		//Approach-5
//Syntax: FI ref-var=Class-name::static-method-name;
		DemoI d5=Test::compare;
		System.out.println(d5.add(21, 22)); 
		
		System.out.println("==============");
		
	//	DemoI d6=Test::new;
		
	
	
	
	}
	
	
	
	public Integer testAdd(int x, int y) {
		return x+y;
	}
	
	public static Integer compare(int m, int n) {
		if(m>n) {
			return m;
		}
		else {
			return n;
		}
	}
}
