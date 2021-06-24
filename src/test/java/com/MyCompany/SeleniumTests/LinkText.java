package com.MyCompany.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkText {
	
	WebDriver driver;
	@Test
	public void linkText() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("A/B Testing")).click();
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Add/Remove")).isDisplayed();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
	}
	
	@AfterTest
	public void killBrowser() {
		driver.quit();
	}

}
