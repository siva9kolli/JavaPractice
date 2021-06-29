package com.MyCompany.SeleniumTests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaits {

	public WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://parabank.parasoft.com/");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	//@Test
	public void implictWaitTest() {

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // for every find_element this command will be applicable
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.className("login")).click();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.findElement(By.className("logi")).click();
	}

	
	//@Test
	public void expilcitWaitTest() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("Test")));
		wait.until(ExpectedConditions.attributeContains(By.cssSelector("input.button"), "value", "Log In"));
		wait.until(ExpectedConditions.titleIs("ParaBank | Welcome | Online Banking"));
		boolean b = wait.until(ExpectedConditions.attributeToBe(By.cssSelector("input.button"), "value", "Log In"));
		System.out.println("boolean ==" + b);
		wait.until(
				ExpectedConditions
				.elementToBeClickable(By.cssSelector("input.button"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.button")));
		driver.findElement(By.cssSelector("input.button")).click();
		
	}
	
	
	@Test
	public void fluentWaitTest() {
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(4))
				.ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class)
				.withMessage("Element not found");
		
		fWait.until(ExpectedConditions.elementToBeClickable(By.xpath("Path")));
		
	}
	
	
	
	@AfterTest
	public void quitSession() {
		driver.quit();
	}
	
	
}
