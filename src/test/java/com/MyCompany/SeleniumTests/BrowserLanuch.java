package com.MyCompany.SeleniumTests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLanuch {
	public WebDriver driver;
	String browser = "chrome";

	@BeforeSuite
	public void launchBrowser() {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://the-internet.herokuapp.com/");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("https://parabank.parasoft.com/");
			break;
		case "safari":
			driver = new SafariDriver();
			driver.get("https://parabank.parasoft.com/");
			break;
		}

	}

	@AfterSuite
	public void killSession() {
		driver.quit();
	}

	@AfterTest
	public void ifTestFailsThenTakeScreenshot() throws IOException {
		// ITestResult result
//		System.out.println("ITestResult.FAILURE ===== " + ITestResult.FAILURE);
//		System.out.println("result.getStatus() ====== " + result.getStatus());

		// if(ITestResult.FAILURE == result.getStatus()) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
		String baseDirectory = System.getProperty("user.dir");
		System.out.println("baseDirectory Path === " + baseDirectory);
		File destinationFile = new File(baseDirectory + "/screenshot/failTest.png");
		FileUtils.copyFile(screenshotFile, destinationFile);

	}

}
