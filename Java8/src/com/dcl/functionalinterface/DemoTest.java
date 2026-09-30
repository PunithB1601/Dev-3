package com.dcl.functionalinterface;

interface Demo{
	void x();
}

public class DemoTest {

	public static void main(String[] args) {
		Demo d=()->System.out.println("x() called");
		d.x();
	}
	
}


