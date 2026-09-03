package com.dcl;

//Object Creational Logic
//Factory class / Helper class / Utility class
//- is basically used to create multiple object of type interface.
public class Bill_PaymentFactory {

	public static Payment getPayment(String paymentMode) {
		
		if(paymentMode.equalsIgnoreCase("Credit Card")) {
			return new CreditCard();
		}
		else if(paymentMode.equalsIgnoreCase("Debit Card")) {
			return new DebitCard();
		}
		else if(paymentMode.equalsIgnoreCase("UPI")) {
			return new UPI();
		}
		else {
			System.out.println("Payment mode not allowed");
			return null;
		}
	}
	
}
