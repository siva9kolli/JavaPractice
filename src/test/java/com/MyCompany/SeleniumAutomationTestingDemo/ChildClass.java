package com.MyCompany.SeleniumAutomationTestingDemo;

import org.testng.annotations.Test;

public class ChildClass extends ParentClass{
	
	@Test
	void childTest() {
		parent();
	}

}
