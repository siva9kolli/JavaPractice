package com.MyCompany.SeleniumAutomationTestingDemo;

import org.testng.annotations.Test;

public class ChildClass extends ParentClass{
	
	@Test
	public void childTest() {
		parent();
		parentStatic();
		childMehtod(test);
	}
	
	public static void childMehtod(String test) {
		System.out.println("Child method ----" + test);
	}



}
