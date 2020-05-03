package com.apppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class basePage {
	WebDriver driver;
	WebDriverWait wait;
	
	public basePage (WebDriver driver) {
		
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 15);
	}

	// Defining Abstract methods
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitTilElementPresent(By locator);
	
	public abstract void waitTillPageTitleAppers(String title);
	
	// Using Java Generic concept to create method  (getInstance) which return new page 
	
	public <CPage extends pageBase > CPage getInstance(Class<CPage> classPage){
		
		try {
			return classPage.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
