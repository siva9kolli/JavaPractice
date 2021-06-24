package com.MyCompany.SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLanuch {
	public WebDriver driver;
	String browser = "firefox";

	@Test
	public void launchBrowser() {
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver",
			// "/Users/sivareddyk/Downloads/chromedriver_a");
			driver = new ChromeDriver();
			driver.get("https://parabank.parasoft.com/");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			// System.setProperty("webdriver.chrome.driver",
			// "/Users/sivareddyk/Downloads/chromedriver_a");
			driver = new FirefoxDriver();
			driver.get("https://parabank.parasoft.com/");
			break;
		case "safari":
			driver = new SafariDriver();
			driver.get("https://parabank.parasoft.com/");
			break;
		}
		
		
	}

}
