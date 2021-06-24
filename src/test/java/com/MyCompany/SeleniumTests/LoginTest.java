package com.MyCompany.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;

	@BeforeTest
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void loginAsAdmin() {

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(duration)
		driver.findElement(By.className("login")).click();
//		driver.findElement(By.id("email_create")).sendKeys("selenium@yopmail.com");
//		driver.findElement(By.name("SubmitCreate")).click();

		driver.findElement(By.id("email")).sendKeys("Testing");
		driver.findElement(By.id("passwd")).sendKeys("Testing");
		driver.findElement(By.name("SubmitLogin")).click();

		//driver.findElement(By.xpath("//*[@class='alert alert-danger']/p")).getText().equals("There is 1 erro");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@class='alert alert-danger']/p")).getText(),
				"There is 1 erro");

	}

	@AfterTest
	public void quitSession() {
		driver.quit();
	}

}
