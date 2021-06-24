package com.MyCompany.SeleniumAutomationTestingDemo;

public class CallInheritance extends UseInterface{

	public static void main(String[] args) {
		TInterface  testInheritance = new CallInheritance();
		testInheritance.testX();
		testInheritance.testY();
		testInheritance.testD();
		int t = testInheritance.i;
		System.out.println("t value ===="  + (t+9));
	}

}
