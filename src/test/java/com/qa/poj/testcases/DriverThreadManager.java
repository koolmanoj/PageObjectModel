package com.qa.poj.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.poj.base.TestBase;

public class DriverThreadManager extends TestBase{
	
	static ThreadLocalTest dr;
	
	public static void intialization() {
		
		dr = new ThreadLocalTest();
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			 dr.setDriver(driver);
			
			  driver = dr.getDriver();
			
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			dr.setDriver(driver);
		}
	}
}
