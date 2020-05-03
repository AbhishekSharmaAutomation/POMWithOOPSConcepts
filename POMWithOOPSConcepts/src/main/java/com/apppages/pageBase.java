package com.apppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class pageBase extends basePage{

	public pageBase(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		
		WebElement element=null;
		try {
			waitTilElementPresent(locator);
			
			element= driver.findElement(locator);
			return element;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitTilElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void waitTillPageTitleAppers(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
