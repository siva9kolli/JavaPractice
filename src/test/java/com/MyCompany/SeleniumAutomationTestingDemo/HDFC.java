package com.MyCompany.SeleniumAutomationTestingDemo;

import org.testng.annotations.*;

public class HDFC extends Bank{
	
	public static void main(String args[]) {
		Bank b = (Bank)new HDFC();
//		HDFC h = new HDFC();
		b.loanInterest();
//		h.loanInterest();
		
		loanInterest();
		System.out.println("Interest rate === 10%");
	}
	

	public static void loanInterest() {
		System.out.println("Interest is 8%");
	}
	
	

}
