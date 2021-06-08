package com.MyCompany.SeleniumAutomationTestingDemo;

public class PolyParent {
	
	public void sum(int a, int b) {
		int c;
		c = a+b;
		System.out.println("Sum value ===== "  + c);
		
		//return c;
	
	}
	
	public int mul(int a, int b) {
		return a*b;
	}
	
	public String name() {
		String text = "Selenium Automation";
		return text;
	}

}
