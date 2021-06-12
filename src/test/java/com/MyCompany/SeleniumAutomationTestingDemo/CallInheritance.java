package com.MyCompany.SeleniumAutomationTestingDemo;

public class CallInheritance {

	public static void main(String[] args) {
		TestInterface  testInheritance = new UseInterface();
		testInheritance.testX();
		testInheritance.testY();
		testInheritance.testD();
		int t = testInheritance.i;
		System.out.println("t value ===="  + (t+9));
	}

}
