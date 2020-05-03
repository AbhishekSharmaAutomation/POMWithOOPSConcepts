
package com.apppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Abhishek Sharma
 *
 */
public class loginPage extends pageBase{

	public loginPage(WebDriver driver) {
		super(driver); 
	}
	
	// login page locators defined
	
	private By emailId = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.id("loginBtn");
	private By header = By.xpath("//i18n-string[@data-key='login.signupLink.text']");
	
	// Public getter methods
	/**
	 * @return the emailId
	 */
	public WebElement getEmailId() {
		return getElement(emailId);
	}
	
	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}
	
	/**
	 * @return the loginButton
	 */
	public WebElement getLoginButton() {
		return getElement(loginButton);
	}
	
	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	public String getLoginPageHeader() {
		
		return getPageHeader(header);
	}
	
	
	//login function
	
	public homePage loginUser(String userName, String password) {
		getEmailId().sendKeys(userName);
		getPassword().sendKeys(password);
		getLoginButton().click();
		
		return getInstance(homePage.class);
		
	}
	
	//Negative scenario coverage login function (method overloading)
	
		public void loginUser() {
			getEmailId().sendKeys("");
			getPassword().sendKeys("");
			getLoginButton().click();
			
		}

}
