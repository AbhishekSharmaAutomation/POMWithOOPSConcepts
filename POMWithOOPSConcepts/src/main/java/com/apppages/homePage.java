package com.apppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author HP
 *
 */
public class homePage extends pageBase {

	public homePage(WebDriver driver) {
		super(driver);
	}

	private By header = By.xpath("//i18n-string[@data-key='getting-started-ui.endToEndHeaderCopy.heading']");
	
	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}
	
	public String getHomePageTitle() {
		return getPageTitle();
	}
	
	public String getHomePageHeader() {
		
		return getPageHeader(header);
	}
	
}
