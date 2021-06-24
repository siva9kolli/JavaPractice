package com.MyCompany.SeleniumAutomationTestingDemo;
import org.testng.annotations.Test;

public class MethodOverLoading {
	
	UnderstandTestNg understandTestNg;
	
	public int sum(int a, int b) {
		int c;
		System.out.println("C value === " + (a+b));
		return c = a+b;
		
	}
	
	
	public double sum(long a, int b) {
		long c;
		System.out.println("C value === " + (a+b));
		return c = a+b;
		
	}
	
	public void sum(int a, int b, int d) {
		int c;
		c = a+b+d;
		System.out.println("C value === " + c);
	}
	
	public void sum(double a, int b) {
		double c;
		c = a+b;
		System.out.println("C value === " + c);
	}
	
	@Test
	public void testOverLoading() {
		
		understandTestNg = new UnderstandTestNg();
		sum(10,20);
		sum(0.9,20);
		sum(1,2,3);
		understandTestNg.multily(6, 7);
	}
	

}
