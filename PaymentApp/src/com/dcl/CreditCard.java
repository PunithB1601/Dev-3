package com.dcl;

public class CreditCard implements Payment {

	@Override
	public void doPayment() {
		
		System.out.println("Payment made using Credit Card");

	}

}
