package com.MyCompany.SeleniumAutomationTestingDemo;

public class AboutMainMethod {
	
	static String test = "Selenium";
	
	public AboutMainMethod(String test) {
		System.out.println("Constructor Testing ==== " + test);
		this.test = test;
	}
	
	public static void main(String args[]) {
		
		//AboutMainMethod aboutMainMethod = new AboutMainMethod("Automation");
		AboutMainMethod aboutMainMethod1= new AboutMainMethod(test);
		System.out.println("Testing Main");
		//testing();
		aboutMainMethod1.testing1();
	}
	
	public void testing() {
		System.out.println("Testing Static Normal method");
	}
	
	public void testing1() {
		System.out.println("Testing Normal method");
	}

}
