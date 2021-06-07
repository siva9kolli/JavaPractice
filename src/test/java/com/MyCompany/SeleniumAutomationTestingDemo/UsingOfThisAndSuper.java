package com.MyCompany.SeleniumAutomationTestingDemo;

import org.testng.annotations.Test;

public class UsingOfThisAndSuper extends UsingSuperKeyword{
	
//	public UsingOfThisAndSuper(String test) {
//		super(test);
//		// TODO Auto-generated constructor stub
//	}

	String test = "Appium";
	AboutMainMethod aboutMainMethod;
	
	@Test
	public void testing() {
		
		System.out.println("Testing this Keyword ------ " +  this.test);
		System.out.println("Testing super Keyword ------ " +  super.test1);
		
		System.out.println("Testing super Keyword ------ " );
		super.test();
	}

}
