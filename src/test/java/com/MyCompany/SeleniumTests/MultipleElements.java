package com.MyCompany.SeleniumTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MultipleElements extends BrowserLanuch {

	@Test
	public void multipleSameElements() {

		driver.get("http://the-internet.herokuapp.com/hovers");

		Actions action = new Actions(driver);

		List<WebElement> sourceElement = driver.findElements(By.cssSelector("*[alt='User Avatar']"));
		sourceElement.get(0).click();
		//System.out.println("Number of elemets ====" + sourceElement.size());

	}

}
