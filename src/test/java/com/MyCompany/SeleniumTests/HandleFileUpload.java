package com.MyCompany.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFileUpload {
	WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void loginAsAdmin() {

		driver.get("http://the-internet.herokuapp.com/upload");
		
		WebElement fileUploadButton = driver.findElement(By.cssSelector("#file-upload"));
		fileUploadButton.sendKeys("/Users/sivareddyk/Desktop/Selenium/selenium.png");
		System.out.println("Test");
		
		/*
		 * Using Auto IT - we can do on Windows
		 * On MAc we can do with Apple script
		 */
	}

	@AfterTest
	public void quitSession() {
		driver.quit();
	}

}
