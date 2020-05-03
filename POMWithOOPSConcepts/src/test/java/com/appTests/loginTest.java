package com.appTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apppages.homePage;
import com.apppages.loginPage;

/**
 * @author Abhishek Sharma
 *
 */
public class loginTest extends baseTest {
	
	@Test(priority=1)
	public void verifyLoginPageTitle() {
		
		String title= page.getInstance(loginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login");
	}
	
	@Test(priority=2)
	public void verifyLoginPageHeaderCheck() {
		
		String header= page.getInstance(loginPage.class).getLoginPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, "Don't have an account?");
	}
	
	@Test (priority=3)
	public void verifyLoginSuccess() {
		homePage hpage= page.getInstance(loginPage.class).loginUser("abhisheksharma01@live.com", "Apr2020#");
		String headerTitle= hpage.getHomePageHeader();
		System.out.println(headerTitle);
		Assert.assertEquals(headerTitle, "Take a closer look at how HubSpot works.");
	}
}
