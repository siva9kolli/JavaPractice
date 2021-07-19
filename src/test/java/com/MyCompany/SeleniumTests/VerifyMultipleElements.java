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

public class VerifyMultipleElements {
	WebDriver driver;

	@AfterTest
	public void quitSession() {
		driver.quit();
	}

	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void loginAsAdmin() {

		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(getHeadingOfPage(), "Welcome to the-internet");
		Assert.assertEquals(getSubHeadingOfPage(), "Available Examples");
		
		List<String> testData = new ArrayList<String>();
		testData.add("Welcome to the-internet");
		testData.add("Available Examples");
		
		Assert.assertEquals(getTextOfHeadings(), testData);
		
		isDisplayedHeadings();
	}

	
	public String getHeadingOfPage() {
		String mainHeading = driver.findElement(By.xpath("//div/h1")).getText();
		System.out.println("mainHeading === " + mainHeading);
		return mainHeading;
	}
	
	public String getSubHeadingOfPage() {
		String subHeading = driver.findElement(By.xpath("//div/h2")).getText();
		System.out.println("subHeading === " + subHeading);
		return subHeading;
	}
	
	public List<String> getTextOfHeadings(){
		List<String>  headings = new ArrayList<String>();
		List<WebElement> headingsList = driver.findElements(By.xpath("//div[@id='content']/child::ul/preceding-sibling::*"));
		
		for(int i=1; i<headingsList.size(); i++) {
			headings.add(headingsList.get(i).getText());
		}
		System.out.println("headings ===== "  + headings);
		return headings;
		
	}
	
	public List<Boolean> isDisplayedHeadings(){
		List<Boolean>  headings = new ArrayList<Boolean>();
		List<WebElement> headingsList = driver.findElements(By.xpath("//div[@id='content']/child::ul/preceding-sibling::*"));
		
		for(int i=1; i<headingsList.size(); i++) {
			headings.add(headingsList.get(i).isDisplayed());
		}
		System.out.println("Boolean values of headings ===== "  + headings);
		return headings;
		
	}
}
