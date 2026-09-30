package com.dcl.interfaceenhancement;

interface Bank{
	
	void getBalance();
	
	void deposit();
	
	default void intlDeposit() {
		System.out.println("Handle deposits in Dollars");
	}
	
	static void loanSanction() {
		System.out.println("Loan feature available");
	}
	
}

class CanaraBank implements Bank{

	@Override
	public void getBalance() {
		System.out.println("CNBK Balance : 5000");
	}

	@Override
	public void deposit() {
		System.out.println("CNBK Deposit : 10000");
	}
	
	@Override
	public void intlDeposit() {
		Bank.super.intlDeposit();
	}
	
	
}

class AxisBank implements Bank{

	@Override
	public void getBalance() {
		System.out.println("AXBK Balance : 5000");
	}

	@Override
	public void deposit() {
		System.out.println("AXBK Deposit : 10000");
		
	}
	
	@Override
	public void intlDeposit() {
		System.out.println("AXIS Bank follows BRICS currency");
	}
	
}

class XyzCoOpBank implements Bank{

	@Override
	public void getBalance() {
		System.out.println("COBK Balance : 4000");
		
	}

	@Override
	public void deposit() {
		System.out.println("COBK Deposit : 3000");
	}
	
	
	
}

public class BankTest {

	public static void main(String[] args) {
		
		Bank b1=new CanaraBank();
		b1.deposit();
		b1.getBalance();
		b1.intlDeposit();
		Bank.loanSanction();
		System.out.println("-----------");
		Bank b2=new AxisBank();
		b2.deposit();
		b2.getBalance();
		b2.intlDeposit();
		System.out.println("-----------");
		Bank b3=new XyzCoOpBank();
		b3.deposit();
		b3.getBalance();
		
	}
}
