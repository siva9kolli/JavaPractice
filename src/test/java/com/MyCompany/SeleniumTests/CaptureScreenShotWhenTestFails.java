package com.MyCompany.SeleniumTests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CaptureScreenShotWhenTestFails extends BrowserLanuch{
	
	@Test
	public void getScreenshot() throws InterruptedException {
		
		Thread.sleep(5000);
		WebElement addemoveElement1 = driver.findElement(By.xpath("//a[text()='Add/Remove Elements']"));
		Assert.assertEquals("/add_remove_elements/", addemoveElement1.getAttribute("href"));
		
		WebElement addemoveElement2 = driver.findElement(By.xpath("//a[text()='Add/Remove Element']"));
		Assert.assertTrue(addemoveElement2.isDisplayed());
	}

}
