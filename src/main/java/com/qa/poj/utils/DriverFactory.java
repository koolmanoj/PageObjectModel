package com.qa.poj.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.poj.base.TestBase;

public class DriverFactory extends TestBase{
	
	static WebDriver driver;
	
	public static WebDriver setBrowser(String browserName) {
		
		if(browserName.toLowerCase().equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.toLowerCase().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
			driver = null;
		
		return driver;
	}

}
