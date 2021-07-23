package com.MyCompany.SeleniumAutomationTestingDemo;
import org.testng.annotations.Test;
public class TestingParameters {
	
	@Test
	public void test1() {
		sum(2 , 1);
	}
	
	
	public void sum(int a, int b) {
		int c;
		c = a+b;
		System.out.println("c value ===" + c);
				
	}
	
	public void sum(int a, double b) {
		double c;
		c = a+b;
		System.out.println("c value ===" + c);
	}

}
