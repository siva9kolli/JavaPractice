package com.MyCompany.SeleniumAutomationTestingDemo;

public class Test {
	
	public Test(int i) {
		System.out.println("i====" + 5);
	}
	
	public static void main(String args[]) {
		Test test = new Test(6);
		test1();
		test.test2();
	}
	
	public static void test1() {
		System.out.println("Testing static method");
	}
	
	public void test2() {
		System.out.println("Testing non static method");
	}

}
