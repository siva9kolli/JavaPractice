package com.MyCompany.SeleniumAutomationTestingDemo;

import org.testng.annotations.Test;

public class PolyChild extends PolyParent{
	
	@Test
	public void testing() {
		PolyParent polyChild = new PolyParent();
		polyChild.sum(10, 20);
		
		sum(10, 20);
		
		sum(2, 2, 2);
		
		
	}
	
	public void sum(int a, int b) {
		int c;
		c = a+b+a+b;
		System.out.println("Sum value Child===== "  + c);
	
	}
	
	public int sum(int a, int b, int d) {
		int c;
		c = a+b+a+b;
		System.out.println("Sum value Child===== "  + c);
		return c;
	
	}
	
	public void sum(int a, float b) {
		float c;
		c = a+b;
		System.out.println("Sum value Child===== "  + c);
		//return c;
	
	}

}
