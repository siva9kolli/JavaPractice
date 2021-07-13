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

public class HandleAlerts {
	
	WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	
	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	

	//@Test
	public void loginAsAdmin() {

		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		WebElement jsAlert = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
		jsAlert.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement result = driver.findElement(By.cssSelector("p#result"));
		String resultActual = result.getText();
		
		Assert.assertEquals(resultActual, "You successfully clicked an alert");
		
		
	}
	
	
	//@Test(dependsOnMethods = "loginAsAdmin")
	public void jsConfimationTest() {
		WebElement jsConfirm = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
		jsConfirm.click();
		dismissAlert();
	
		WebElement result = driver.findElement(By.cssSelector("p#result"));
		String resultActual = result.getText();
		
		Assert.assertEquals(resultActual, "You clicked: Cancel");
	}
	
	
	@Test //(dependsOnMethods = "jsConfimationTest")
	public void jsPromtTest() {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement jsConfirm = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
		jsConfirm.click();

		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Testing");
		alert.accept();
		
	
		WebElement result = driver.findElement(By.cssSelector("p#result"));
		String resultActual = result.getText();
		
		Assert.assertEquals(resultActual, "You entered: Testing");
	}

	@AfterTest
	public void quitSession() {
		driver.quit();
	}

}
