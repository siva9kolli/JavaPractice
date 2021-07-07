package com.MyCompany.SeleniumTests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleTabsOrWindows {
	
	WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void loginAsAdmin() {

		driver.get("https://www.salesforce.com/in/?ir=1");
		
		WebElement contactUsLink = driver.findElement(By.xpath("//div[@class='inner']/div/a[normalize-space()='Contact Us']"));
		contactUsLink.click();
		
		String parentWindowId = driver.getWindowHandle();
		System.out.println("currentWindowId === " + parentWindowId);
		
		Set<String> numberOfWindows = driver.getWindowHandles();
		System.out.println("numberOfWindows====" + numberOfWindows);
		
		for(String window: numberOfWindows) {
			driver.switchTo().window(window);
		}
		
		driver.findElement(By.name("UserFirstName")).sendKeys("Testing");
		driver.close();
		
		//driver.switchTo().window(parentWindowId);
		
		Set<String> numberOfWindows1 = driver.getWindowHandles();
		System.out.println("numberOfWindows1 === " + numberOfWindows1);
		for(String window: numberOfWindows1) {
			driver.switchTo().window(window);
		}
		contactUsLink.click();
		
		System.out.println("Test");
	}

	@AfterTest
	public void quitSession() {
		driver.quit();
	}
}

