package com.dcl;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the payment mode:");
		String paymentMode=sc.nextLine();
		
		Payment p=Bill_PaymentFactory.getPayment(paymentMode);
	//  Payment p=new DebitCard();	
		if(p!=null) {
			p.doPayment();
		}
	}
}
