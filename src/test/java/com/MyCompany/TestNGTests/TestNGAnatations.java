package com.MyCompany.TestNGTests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

public class TestNGAnatations {
	
	@Test
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("initilize report");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("AFter Test");
		
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("AFter Class");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AFter Method");
	}
}
