package com.dcl;

import java.util.Scanner;

//Customer-Uilization Logic
public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Engine-Type");
		String engineType=sc.next();
		
		Engine e=EngineFactory.getEngine(engineType);
		if(e!=null) {
			e.start();
		}
		
		
	}

}
