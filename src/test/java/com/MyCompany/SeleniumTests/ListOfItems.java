package com.MyCompany.SeleniumTests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class ListOfItems {
	WebDriver driver;
	
	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void loginAsAdmin() {

		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		clickOnElementUsingXpath("(//a[@title='Faded Short Sleeve T-shirts'])[2]");
		
		List<String> dressDetails = new ArrayList<String>();
		dressDetails.add(driver.findElement(By.cssSelector("h1[itemprop=\"name\"]")).getText());
		dressDetails.add(driver.findElement(By.cssSelector("span[itemprop=\"sku\"]")).getText());
		
		System.out.println("dressDetails ==== " + dressDetails);
	}
		
	public void clickOnElement(By locator) {
		driver.findElement(locator).click();
	}
	
	public void clickOnElementUsingXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clickOnElement(WebElement element) {
		element.click();
	}
	

	@AfterTest
	public void quitSession() {
		driver.quit();
	}

}
