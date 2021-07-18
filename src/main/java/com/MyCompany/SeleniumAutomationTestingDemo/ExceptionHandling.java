package com.MyCompany.SeleniumAutomationTestingDemo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionHandling {

	int a = 5;
	int b;
	WebDriver driver;

	@Test
	public void test1() throws IOException {
		try {

			driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		}

		catch (ArithmeticException e) {
			b = a + a;
			System.out.println("Arthematic Exception");
		} catch (WebDriverException wde) {
			wde.printStackTrace();
			System.out.println("WebDriver Exception");
		}
		 catch (NullPointerException ne) {
				ne.printStackTrace();
				System.out.println("Null Exception");
				WebDriverManager.chromedriver().setup();
				//driver = new ChromeDriver();
				//driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			}
		
		

		catch (Exception ee) {
			ee.printStackTrace();
			System.out.println("Main Exception");
		}
		finally {
			System.out.println("Manadatory Block");
			driver = new ChromeDriver();
			driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		}

		int c = a;
		System.out.println("c value ==== " + a);

	}

}
