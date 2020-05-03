package com.appTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.apppages.basePage;
import com.apppages.pageBase;

import io.github.bonigarcia.wdm.WebDriverManager;


public class baseTest {
	
	WebDriver driver;
	
	public basePage page;
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void testSetup(String browser) {
		// for chrome driver
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		
		// for firefox driver
		else  if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().version("0.26.0").setup();
			driver= new FirefoxDriver();
					
		}
		
		// for ie driver
		else  if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
					
		}
		
		// for edge driver
		else  if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
					
		}
		
		else {
			System.out.println("The browser value not defined in testNG XML file");
		}
		
		driver.get("https://app.hubspot.com/login");
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//calling the constructor of basePage to provide driver
		page = new pageBase(driver);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
