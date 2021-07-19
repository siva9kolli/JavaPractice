package com.MyCompany.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWithJavaScriptExecutor {
	
	WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void switchToSingleiFrame() {

		driver.get("http://automationpractice.com/index.php");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement signInLink = driver.findElement(By.cssSelector("a[title='Log in to your customer account']"));
		
		//jse.executeScript("arguments[0].click()", signInLink);
		jse.executeScript("document.querySelector('a[title='Log in to your customer account']').click();");
		//jse.executeScript("document.querySelector('a[title='Log in to your customer account']').click()");
		
		WebElement passwordInputBox = driver.findElement(By.id("passwd"));
		
		jse.executeScript("arguments[0].value='Test@123'", passwordInputBox);
		System.out.println("Test");

	}

	@AfterTest
	public void quitSession() {
		driver.quit();
	}

}
