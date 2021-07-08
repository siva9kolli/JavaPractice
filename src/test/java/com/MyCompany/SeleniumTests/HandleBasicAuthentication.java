package com.MyCompany.SeleniumTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBasicAuthentication {

	WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	

	@Test
	public void loginAsAdmin() {

		driver.get("http://the-internet.herokuapp.com/");
		WebElement baseAuthLink = driver.findElement(By.xpath("//*[text()='Basic Auth']"));
		baseAuthLink.click();
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		System.out.println("Test");
		
		
		
	}
	
}
