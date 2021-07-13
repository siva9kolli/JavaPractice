package com.MyCompany.SeleniumTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleMoveToElementAndClick extends BrowserLanuch{
	
	@Test
	public void moveToElementAndClickOnWeb() {
		driver.get("http://the-internet.herokuapp.com/hovers");
		
		Actions action = new Actions(driver);
		
		List<WebElement> sourceElement = driver.findElements(By.cssSelector("*[alt='User Avatar']"));
		
		WebElement destinationElement = driver.findElement(By.xpath("//h5[text()='name: user1']/following-sibling::a"));
		
		action.moveToElement(sourceElement.get(0)).build().perform();
		action.click(destinationElement).build().perform();
		
		//action.moveToElement(destinationElement).click().build().perform();
	}

}
