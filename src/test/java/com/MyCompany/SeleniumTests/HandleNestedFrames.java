package com.MyCompany.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleNestedFrames {
	WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void switchToSingleiFrame() {

		driver.get("http://the-internet.herokuapp.com/nested_frames");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame-top"));
		driver.switchTo().frame("frame-right");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[contains(text(),'RIGHT')]")));
		WebElement rightBox = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
		String  rightBoxText = rightBox.getText();
		System.out.println("bottonBoxText ====" + rightBoxText);
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-middle");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[contains(text(),'MIDDLE')]")));
		WebElement middleBox = driver.findElement(By.xpath("//body/div[contains(text(),'MIDDLE')]"));
		String  middleBoxText = middleBox.getText();
		System.out.println("bottonBoxText ====" + middleBoxText);
		
		driver.switchTo().defaultContent();
		

	}

	@AfterTest
	public void quitSession() {
		driver.quit();
	}
}
