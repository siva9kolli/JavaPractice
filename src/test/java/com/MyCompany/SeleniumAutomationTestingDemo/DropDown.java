package com.MyCompany.SeleniumAutomationTestingDemo;

import java.time.Duration;
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

public class DropDown {
	WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void loginAsAdmin() throws InterruptedException {

		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(5000);
		WebElement contactUsLink = driver.findElement(By.xpath("//*[@title='Contact Us']"));
		contactUsLink.click();
		
		
		Select subHeading = new Select(driver.findElement(By.id("id_contact")));
		
		subHeading.selectByVisibleText("Customer service");
		subHeading.selectByValue("1");
		subHeading.selectByIndex(1);
		String firstOption = subHeading.getFirstSelectedOption().getText();
		System.out.println("firstOption ====== " + firstOption);
		Assert.assertEquals(firstOption, "Customer service");
		System.out.println("All selected options ====" + subHeading.getAllSelectedOptions().get(0).getText());
		for(int i=0; i<subHeading.getOptions().size(); i++) {
		
		System.out.println("all options " + subHeading.getOptions().get(i).getText());
		}
		System.out.println("Test");
	}

	@AfterTest
	public void quitSession() {
		driver.quit();
	}

}
