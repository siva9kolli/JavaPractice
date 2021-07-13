package com.MyCompany.SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitTests {
	public static WebDriver abcd;
	//public WebDriverWait wait;
	
	@Test
	public void waitsTest() {
		WebDriverManager.chromedriver().setup();
		abcd = new ChromeDriver();
		
		abcd.navigate().to("http://the-internet.herokuapp.com/");
		//driver.get("http://the-internet.herokuapp.com/");
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		WebElement abTest = abcd.findElement(By.xpath("//a[normalize-space()='A/B Testing']"));
		abTest.click();
		WebDriverWait wait = new WebDriverWait(abcd,20);
		wait.until(ExpectedConditions.
				invisibilityOfElementLocated(By.xpath("//a[normalize-space()='A/B Testing']")));
		
		
	}
	
	@AfterMethod
	public void killSession() {
		abcd.quit();
	}

}
