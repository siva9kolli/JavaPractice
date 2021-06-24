package com.MyCompany.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverTest {
	
	//@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/");
		
		driver.quit();
		
	}
	
	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://192.168.1.13:8080/src/html/");
		driver.findElement(By.name("email")).sendKeys("Selenium");
		driver.findElement(By.id("email_error")).isDisplayed();
		driver.findElement(By.className("font")).isDisplayed();
		driver.findElement(By.tagName("div")).isDisplayed();
		driver.findElement(By.xpath("//input[@type='password']")).isDisplayed();
		driver.findElement(By.cssSelector(".font.font2")).isDisplayed();
		driver.quit();
		
	}
	
	


}
