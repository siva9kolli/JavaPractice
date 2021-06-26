package com.MyCompany.SeleniumTests;

import java.util.List;

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

public class ElementVerifivations {

	WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	//@Test
	public void loginAsAdmin() throws InterruptedException {

		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
		Thread.sleep(5000);
		
		WebElement logo = driver.findElement(By.cssSelector("img[alt='Salesforce']"));
		
		
		
		if(logo.isDisplayed()) { 
		driver.findElement(By.xpath("//input[starts-with(@id,'UserFirst')]")).sendKeys("Testing");
		}
		
		System.out.println("Test");
		
		
		WebElement checkBox = driver.findElement(By.cssSelector("#SubscriptionAgreement + div"));
		checkBox.isDisplayed();
		System.out.println("checkbox displayed " + checkBox.isDisplayed());
		checkBox.click();
		System.out.println("checkbox is checked "  + checkBox.isSelected());
	}
	
	
	@Test
	public void verifyCheckboxes() {
		driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
		
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes > input"));
		
		for(int i=0; i<checkboxes.size(); i++) {
			System.out.println("Status of checkboxes " + checkboxes.get(i).isSelected());
		}
		
		checkboxes.get(0).click();
		checkboxes.get(1).click();
		
		for(int i=0; i<checkboxes.size(); i++) {
			System.out.println("Status of checkboxes " + checkboxes.get(i).isSelected());
		}
	}

	@AfterTest
	public void quitSession() {
		driver.quit();
	}
}

