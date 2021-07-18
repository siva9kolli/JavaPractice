package com.MyCompany.SeleniumTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrames {

	WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void switchToSingleiFrame() {

		driver.get("http://the-internet.herokuapp.com/tinymce");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));
		//driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#tinymce > p")));
		WebElement textEditor = driver.findElement(By.cssSelector("#tinymce"));
		textEditor.clear();
		textEditor.sendKeys("This is Selenium Session");
		System.out.println("Test");

	}

	@AfterTest
	public void quitSession() {
		driver.quit();
	}

}
